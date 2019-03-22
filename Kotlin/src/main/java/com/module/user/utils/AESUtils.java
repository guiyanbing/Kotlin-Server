package com.module.user.utils;

import java.io.PrintStream;
import java.security.Key;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AESUtils {
    private boolean isJdkDES;

    public AESUtils(boolean isJdkDES) {
        this.isJdkDES = isJdkDES;
    }

    public Key generateKey() {
        Key convertSecretKey = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (!this.isJdkDES) {
                Security.addProvider(new BouncyCastleProvider());
                keyGenerator = KeyGenerator.getInstance("AES", "BC");
            }

            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            convertSecretKey = new SecretKeySpec(bytesKey, "AES");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return convertSecretKey;
    }

    public String desOpt(String text, boolean isEncode, Key convertSecretKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            if (isEncode) {
                cipher.init(1, convertSecretKey);
                byte[] result = cipher.doFinal(text.getBytes());

                return Hex.encodeHexString(result);
            }
            cipher.init(2, convertSecretKey);

            return new String(cipher.doFinal(Hex.decodeHex(text.toCharArray())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}