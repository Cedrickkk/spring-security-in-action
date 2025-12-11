package org.spring.security.ssiach4ex2.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

@Configuration
public class SecurityConfiguration {

    public void bytesKeyGenerator() {
        BytesKeyGenerator bytesKeyGenerator = KeyGenerators.secureRandom();
        byte[] key = bytesKeyGenerator.generateKey();
        int keyLength = bytesKeyGenerator.getKeyLength();
    }

    public void stringKeyGenerator() {
        StringKeyGenerator stringKeyGenerator = KeyGenerators.string();
        String key = stringKeyGenerator.generateKey();
    }

    public void textEncryptor() {
        TextEncryptor textEncryptor = Encryptors.noOpText();
        String valueToEncrypt = "HELLO";
        String encrypted = textEncryptor.encrypt(valueToEncrypt);
    }

}
