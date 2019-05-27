package com.hhz.demo.controller;

import com.hhz.demo.encrypt.CodeUtil;
import com.hhz.demo.encrypt.MedusaEncryptException;
import com.hhz.demo.encrypt.MedusaEncryptor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class TestController {


    @RequestMapping(value = "/saas/backUrl", method = RequestMethod.POST)
    public BackEncrypt aaa(@RequestBody BackEncrypt backEncrypt) {

        String token = "123";
        String aesKey = "111108bb8e6dbce3c9671d6fdb69d15066227608111";
        String suiteKey = "abc123";
        MedusaEncryptor medusaEncryptor = null;
        try {
            medusaEncryptor = new MedusaEncryptor(token, aesKey, suiteKey);
            String data = medusaEncryptor.getDecryptMsg(backEncrypt.getMsgSignature(), backEncrypt.getTimeStamp(), backEncrypt.getNonce(), backEncrypt.getEncrypt());
            System.out.println(data);
        } catch (MedusaEncryptException e) {
            e.printStackTrace();
        }


        Map<String, String> encryptedMap = null;
        try {
            String renturnMes = "success";
            encryptedMap = medusaEncryptor.getEncryptedMap(renturnMes, System.currentTimeMillis(), CodeUtil.getCode(10));
        } catch (MedusaEncryptException e) {
            e.printStackTrace();
        }

        BackEncrypt returnEncrpy = new BackEncrypt();
        returnEncrpy.setEncrypt(encryptedMap.get("encrypt"));
        returnEncrpy.setMsgSignature(encryptedMap.get("msg_signature"));
        returnEncrpy.setTimeStamp(encryptedMap.get("timeStamp"));
        returnEncrpy.setNonce(encryptedMap.get("nonce"));
        return returnEncrpy;
    }
}
