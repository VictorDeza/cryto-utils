package com.dza.cryto.hash;

import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class HashUtilsTest {

    @Test
    void generateRandomSalt() {
        byte[] salt = HashUtils.generateRandomSalt();
        assertNotNull(salt);
    }

    @Test
    void createSHA2Hash() throws Exception {
        byte[] salt01 = HashUtils.generateRandomSalt();
        String valueToHash = UUID.randomUUID().toString();
        byte[] hashText01 = HashUtils.createSHA2Hash(valueToHash, salt01);
        byte[] hashText02 = HashUtils.createSHA2Hash(valueToHash, salt01);
        assertEquals(DatatypeConverter.printHexBinary(hashText01), DatatypeConverter.printHexBinary(hashText02));
    }

    @Test
    void passwordRoutine() {
        String secretPhrase = "Victor Junior's Deza Quinteros";
        String passwordHash = HashUtils.hashPassword(secretPhrase);
        assertTrue(HashUtils.verifyPassword(secretPhrase, passwordHash));
    }
}