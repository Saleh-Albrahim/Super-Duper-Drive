package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.Note;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CredentialMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
    Credential[] getUserCredentials(int userId);

    @Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) " +
            "VALUES(#{url}, #{userName}, #{key}, #{password}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    int addCredential(Credential credential);

    @Update("UPDATE CREDENTIALS SET url = #{url} , username = #{userName}, password = #{password}, key = #{key} " +
            "where credentialid= #{credentialid}")
    void updateCredential(Credential credential);


    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    void deleteCredential(int credentialId);

}
