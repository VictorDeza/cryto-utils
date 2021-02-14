package com.dza.cryto.symmetric;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SymmetricEncryptionUtilsTest {

    @Test
    void createAESKey() throws Exception {
        SecretKey key = SymmetricEncryptionUtils.createAESKey();
        assertNotNull(key);
    }

    @Test
    void cryptoAESRoutine() throws Exception {
        SecretKey key = SymmetricEncryptionUtils.createAESKey();
        byte[] initializationVector = SymmetricEncryptionUtils.createInitializationVector();
        String plainText = "Victor Junior's Deza Quinteros";
        byte[] cipherText = SymmetricEncryptionUtils.performAESEncryption(plainText, key, initializationVector);
        String decryptedText = SymmetricEncryptionUtils.performAESDecryption(cipherText, key, initializationVector);
        assertEquals(plainText, decryptedText);
    }
}