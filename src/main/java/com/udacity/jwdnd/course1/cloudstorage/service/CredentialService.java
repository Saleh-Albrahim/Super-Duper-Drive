package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential.Credential;
import com.udacity.jwdnd.course1.cloudstorage.security.EncryptionService;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
public class CredentialService {

    private final CredentialMapper credentialMapper;
    private final EncryptionService encryptionService;

    public CredentialService(CredentialMapper credentialMapper, EncryptionService encryptionService) {
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
    }

    public Credential[] getUserCredentials(int userId){

        Credential[] credentials = credentialMapper.getUserCredentials(userId);

        for (int i = 0; i < credentials.length; i++) {
            String decryptedPassword=encryptionService.decrypt(credentials[i].getPassword(),credentials[i].getKey());
            credentials[i].setDecryptedPassword(decryptedPassword);
        }
        return  credentials;
    }

    public void addCredential(Credential credential){

        String decryptedPassword=credential.getDecryptedPassword();
        // Generate random Key
        byte[] array = new byte[6];
        new Random().nextBytes(array);
        String key = new String(array, StandardCharsets.UTF_8);
        credential.setKey(key);

        // Encrypt the password and save
        String newPassword=encryptionService.encrypt(decryptedPassword,key);
        credential.setPassword(newPassword);
        credentialMapper.addCredential(credential);
    }

    public void UpdateCredential(Credential credential){

        String decryptedPassword=credential.getDecryptedPassword();

        // Generate random Key
        byte[] array = new byte[6];
        new Random().nextBytes(array);
        String key = new String(array, StandardCharsets.UTF_8);
        credential.setKey(key);

        // Encrypt the password and change the old password
        String newPassword=encryptionService.encrypt(decryptedPassword,key);
        credential.setPassword(newPassword);
        credentialMapper.(credential);
    }

    public void deleteCredential(int credentialId){ credentialMapper.deleteCredential(credentialId); }
}
