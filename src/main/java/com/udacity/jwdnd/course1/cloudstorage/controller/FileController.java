package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File.File;
import com.udacity.jwdnd.course1.cloudstorage.model.File.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.security.UserService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public String uploadFile(Authentication authentication, @ModelAttribute("newFile") FileForm newFile) throws IOException {

        int userId = userService.getUser(authentication.getName()).getUserId();

        MultipartFile file=newFile.getFile();
        String name=file.getName();
        String contentType=file.getContentType();
        String size=String.valueOf(file.getSize());
        byte[] data=file.getBytes();

        fileService.addFile(new File(userId,name,contentType,size,data));

        return "redirect:/home";
    }


}
