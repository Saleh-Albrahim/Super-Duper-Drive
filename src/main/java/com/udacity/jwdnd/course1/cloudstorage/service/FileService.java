package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.Note;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Service
public class FileService {

    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public  File getFileData(int fileId)   {
        return fileMapper.getFileData(fileId);
    }


    public File[] getUserFiles(int userId){
        return fileMapper.getUserFiles(userId);
    }


    public void addFile(File file){
        fileMapper.addFile(file);
    }


    public void deleteFile(int fileId){ fileMapper.deleteFile(fileId); }


}
