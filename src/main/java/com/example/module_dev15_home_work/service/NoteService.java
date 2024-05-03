package com.example.module_dev15_home_work.service;

import com.example.module_dev15_home_work.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
@Slf4j
public class NoteService {
    private final List<Note> notes= new ArrayList<>();

    public List<Note> listAll(){
        return this.notes;
    }

    public Note ad(Note note){
        log.info("Add new note");
        note.setId(new Random().nextLong());
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        log.info("Delete note by id {}", id);
        Note noteToRemove = notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " was not found or does not exist"));
        notes.remove(noteToRemove);
    }

    public void update(Note note) {
        long id = note.getId();
        log.info("Update note with id {}", id);
        Note existingNote = notes.stream()
                .filter(n -> n.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " was not found or does not exist"));
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
    }

    public Note getById(long id){
        log.info("Get note by id {}", id);
        return notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " was not found or does not exist"));
    }
}
