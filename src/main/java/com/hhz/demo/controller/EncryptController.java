package com.hhz.demo.controller;

import com.hhz.demo.encrypt.CodeUtil;
import com.hhz.demo.encrypt.MedusaEncryptException;
import com.hhz.demo.encrypt.MedusaEncryptor;
import com.hhz.demo.model.BackEncrypt;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * <p class="detail">
 * 功能:saas回调加密测试
 * </p>
 *
 * @author HuangHuizhou
 * @ClassName Test controller.
 * @Version V1.0.
 * @date 2019.06.13 10:32:41
 */
@RestController
public class EncryptController {


    /**
     * <p class="detail">
     * 功能:
     * </p>
     *
     * @param backEncrypt :
     * @return back encrypt
     * @author huanghuizhou
     * @date 2019.06.13 10:32:41
     */
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
