package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note.Note;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    Note[] getUserNotes(int userId);

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) " +
            "VALUES(#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int addNote(Note note);

    @Update("UPDATE NOTES SET notetitle = #{noteTitle} , notedescription = #{noteDescription} where noteid= #{noteId}")
    void updateNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    void deleteNote(int noteId);

}
