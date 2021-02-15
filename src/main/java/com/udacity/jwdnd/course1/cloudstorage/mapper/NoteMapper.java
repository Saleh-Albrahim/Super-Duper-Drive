package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.Note;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    Note[] getUserNotes(Integer userId);

    @Insert("INSERT INTO NOTES (noteid, notetitle, notedescription, userid) " +
            "VALUES(#{noteId}, #{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int addNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    void deleteNote(int noteId);

}
