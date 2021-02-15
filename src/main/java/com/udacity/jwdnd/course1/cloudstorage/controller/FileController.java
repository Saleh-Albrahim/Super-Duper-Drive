package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files")
public class FileController {

    private final FileMapper fileMapper;


    public FileController(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @PostMapping("/upload")
    public String fileUpload(){
      return "";
    }


}
