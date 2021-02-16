package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File.File;
import org.apache.ibatis.annotations.*;


@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE userid= #{userid} ")
    File[] getUserFiles(int userid);

    @Select("SELECT * FROM FILES WHERE fileid= #{fileId} ")
    File getFileData(int userid);

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) " +
            "VALUES(#{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int addFile(File file);

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) " +
            "VALUES(#{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int updateFile(File file);

    @Delete("DELETE FROM FILES WHERE fileid = #{fileId}")
    void deleteFile(int fileId);

}
