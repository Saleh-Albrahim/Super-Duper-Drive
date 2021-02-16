package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }


    public File[] getUserFiles(int userId){
        return fileMapper.getUserFiles(userId);
    }


    public void addFile(File file){
        fileMapper.addFile(file);
    }

    public void updateFile(File file){fileMapper.updateFile(file);}

    public void deleteFile(String filename){ fileMapper.deleteFile(filename); }


}
