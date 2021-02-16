package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.security.UserService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;
    private final UserService userService;

    public FileController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @PostMapping("/upload")
    public String uploadFile(@ModelAttribute("newFile") FileForm newFile){

        System.out.println(newFile.getFile());

        return "redirect:/home";
    }


}
