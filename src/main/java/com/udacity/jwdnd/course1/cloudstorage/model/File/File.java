package com.udacity.jwdnd.course1.cloudstorage.model.File;

public class File {
    private int fileID,userID;
    private String fileName,contentType,fileSize;
    private byte[] fileData;

    public File(int fileID, int userID, String fileName, String contentType, String fileSize, byte[] fileData) {
        this.fileID = fileID;
        this.userID = userID;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.fileData = fileData;
    }

    public int getFileID() {
        return fileID;
    }


    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
