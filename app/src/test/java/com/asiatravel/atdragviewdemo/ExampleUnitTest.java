package com.asiatravel.atdragviewdemo;

import android.util.Log;

import org.json.JSONObject;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String key = "yunjie2514572541463841s1a4d";
        String text = "{\"channel\":\"SeckillGroup\",\"page\":1,\"pageSize\":10,\"BaseAppType\":\"android\",\"BaseAppVersion\":\"4.5.0\",\"SystemVersion\":\"6.0\",\"_sign_\":\"A9589C6D926A220815171C949B282CE0\",\"_token_\":\"88769ef99d8f680fc1c388be90bf7a6b\",\"_wid_\":\"600000863\",\"appIdentifier\":\"com.hs.yjseller.dev\",\"shop_id\":\"10000007834\"}";
        JSONObject object = new JSONObject(text);
        object.put("page",2);
        object.remove("_sign_");
        object.put("_sign_",md5(object.toString()+key).toUpperCase());
        System.out.println(object.toString());

        //assertEquals(4,4);
    }


    String[] strDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    String md5(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }


}