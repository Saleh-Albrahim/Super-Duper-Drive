package com.udacity.jwdnd.course1.cloudstorage.model.Credential;

import org.springframework.web.multipart.MultipartFile;

public class CredentialForm {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
