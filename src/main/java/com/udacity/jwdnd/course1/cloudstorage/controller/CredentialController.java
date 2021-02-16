package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.security.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.security.UserService;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credential")
public class CredentialController {

    private final UserService userService;
    private final CredentialService credentialService;
    private final EncryptionService encryptionService;



    public CredentialController(UserService userService, CredentialService credentialService,
                                EncryptionService encryptionService) {
        this.userService = userService;
        this.credentialService = credentialService;
        this.encryptionService = encryptionService;
    }


    @PostMapping("/add")
    public String addCredential(Authentication authentication, @ModelAttribute("newCredential") CredentialForm newCredential) {

        int userId = userService.getUser(authentication.getName()).getUserId();

        credentialService.addCredential(new Credential(userId,newCredential.getUrl(),
                newCredential.getUserName(),newCredential.getPassword()));

        return "redirect:/home";
    }


    @GetMapping("/delete/{credentialId}")
    public String deleteCredential(Authentication authentication, @PathVariable int credentialId) {

        credentialService.deleteCredential(credentialId);

        return "redirect:/home";
    }


}
