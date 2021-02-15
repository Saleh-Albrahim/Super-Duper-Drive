package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File.File;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final FileMapper fileMapper;

    public NoteService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public File[] getUserFiles(int userId){
        return fileMapper.getUserFiles(userId);
    }
}
