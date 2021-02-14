package com.dza.cryto.asymmetric;

import org.junit.jupiter.api.Test;

import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AsymmetricEncryptionUtilsTest {
    @Test
    void generateRSAKeyPair() throws Exception {
        KeyPair key = AsymmetricEncryptionUtils.generateRSAKeyPair();
        assertNotNull(key);
    }

    @Test
    void cryptoRSARoutine() throws Exception {
        KeyPair key = AsymmetricEncryptionUtils.generateRSAKeyPair();
        String plainText = "Victor Junior's Deza Quinteros";
        byte[] cipherText = AsymmetricEncryptionUtils.performRSAEncryption(plainText, key.getPrivate());
        String decryptedText = AsymmetricEncryptionUtils.performRSADecryption(cipherText, key.getPublic());
        assertEquals(plainText, decryptedText);
    }
}
