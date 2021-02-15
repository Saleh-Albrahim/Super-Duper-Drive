package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.File.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.security.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.security.UserService;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final UserService userService;
    private final FileService fileService;
    private final NoteService noteService;
    private final EncryptionService encryptionService;
    private final CredentialService credentialService;


    public NoteController(UserService userService, FileService fileService,
                          NoteService noteService, EncryptionService encryptionService, CredentialService credentialService) {
        this.userService = userService;
        this.fileService = fileService;
        this.noteService = noteService;
        this.encryptionService = encryptionService;
        this.credentialService = credentialService;
    }


    @PostMapping("/add")
    public String addNote(Authentication authentication, @ModelAttribute("newNote") NoteForm newNote) {

        int userId = userService.getUser(authentication.getName()).getUserId();
        noteService.addNote(new Note(newNote.getTitle(),newNote.getDescription(),userId));

        return "redirect:/home";
    }

    @PutMapping("/update")
    public String updateNote(Authentication authentication, @ModelAttribute("newNote") NoteForm newNote, Model model) {

        int userId = userService.getUser(authentication.getName()).getUserId();
        noteService.addNote(new Note(newNote.getTitle(),newNote.getDescription(),userId));

        return "redirect:/home";
    }


}
