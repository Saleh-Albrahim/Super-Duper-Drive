package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File.File;
import com.udacity.jwdnd.course1.cloudstorage.model.File.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.security.UserService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

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
        String name=file.getOriginalFilename();
        String contentType=file.getContentType();
        String size=String.valueOf(file.getSize());
        byte[] data=file.getBytes();

        fileService.addFile(new File(userId,name,contentType,size,data));

        return "redirect:/home";
    }

    @GetMapping("view/{fileId}")
    public ResponseEntity<Resource> viewFile(Authentication authentication, @PathVariable int fileId)  {

        File file=fileService.getFileData(fileId);

        byte[] bytes = file.getFileData();
        ByteArrayResource resource = new ByteArrayResource(bytes);

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getFileName());
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(bytes.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping("delete/{fileId}")
    public String deleteFile(Authentication authentication, @PathVariable int fileId)  {

        fileService.deleteFile(fileId);

        return "redirect:/home";
    }


}
