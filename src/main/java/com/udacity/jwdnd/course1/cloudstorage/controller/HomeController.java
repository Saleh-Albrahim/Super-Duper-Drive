package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.File.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.security.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHomePage(Authentication auth) {
        return "home";
    }

    @GetMapping
    public String getHomePage(Authentication authentication, @ModelAttribute("newFile") FileForm newFile,
            @ModelAttribute("newNote") NoteForm newNote, @ModelAttribute("newCredential") CredentialForm newCredential,
            Model model) {
        int userId = userService.getUser(authentication.getName()).getUserId();
        model.addAttribute("files", fileService.getFileListings(userId));
        model.addAttribute("notes", noteService.getNoteListings(userId));
        model.addAttribute("credentials", credentialService.getCredentialListings(userId));
        model.addAttribute("encryptionService", encryptionService);

        return "home";
    }


}
