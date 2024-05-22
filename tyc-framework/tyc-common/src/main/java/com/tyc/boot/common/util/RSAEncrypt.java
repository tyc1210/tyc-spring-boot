package com.tyc.boot.common.util;


import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

/**
 * 加密
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-16 14:16:35
 */
public class RSAEncrypt {

    private final static String PUBKEY = "";

    private final static String PRIKEY = "";

    public static String encrypt(String text) {
        RSA rsa = new RSA(PRIKEY,PUBKEY);
        return rsa.encryptBase64(text, KeyType.PublicKey);
    }

    public static String decrypt(String text) {
        RSA rsa = new RSA(PRIKEY,PUBKEY);
        return rsa.decryptStr(text, KeyType.PrivateKey);
    }


    public static void main(String args[]) throws Exception {
        System.out.println(decrypt("FYzxY8Hqsgkuo/hdzDOOiMdEQpXGqvt8tTETIe9Skgj8e6lV9Bc1xWtJIgNuwwB3o5y3C3AMxAbt\n" +
                "nlTKgceIyA=="));
    }
}
