package com.udacity.jwdnd.course1.cloudstorage.model.Note;

import org.springframework.web.multipart.MultipartFile;

public class NoteForm {

    private  String noteId,title,description;

    public NoteForm(String noteId, String title, String description) {
        this.noteId = noteId;
        this.title = title;
        this.description = description;
    }

    public String getNoteId() {
        return noteId;
    }
    
    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NoteForm{" +
                "noteId='" + noteId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
