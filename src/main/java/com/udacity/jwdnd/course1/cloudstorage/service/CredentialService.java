package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.Note;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {

    private final CredentialMapper credentialMapper;

    public CredentialService(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }

    public Credential[] getUserCredentials(int userId){
        return credentialMapper.getUserCredentials(userId);
    }

    public void addCredential(Credential credential){ credentialMapper.addCredential(credential); }

    public void deleteCredential(int credentialId){ credentialMapper.deleteCredential(credentialId); }
}
