package com.example.module_dev15_home_work.service;

import com.example.module_dev15_home_work.entity.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class NoteServiceTest {
    private NoteService noteService;

    @BeforeEach
    public void setUp() {
        noteService = new NoteService();
    }

    @Test
    public void testAddNote() {
        Note note = new Note();
        note.setTitle("Test Note");
        note.setContent("This is a test note");

        Note addedNote = noteService.ad(note);

        assertEquals("Test Note", addedNote.getTitle());
        assertEquals("This is a test note", addedNote.getContent());
    }

    @Test
    public void testDeleteNote() {
        Note note = new Note();
        note.setTitle("Test Note");
        note.setContent("This is a test note");

        Note addedNote = noteService.ad(note);

        noteService.deleteById(addedNote.getId());

        assertTrue(noteService.listAll().isEmpty());
    }

    @Test
    public void testUpdateNote() {
        Note note = new Note();
        note.setTitle("Test Note");
        note.setContent("This is a test note");

        Note addedNote = noteService.ad(note);

        addedNote.setTitle("Updated Note");
        addedNote.setContent("This is an updated note");

        noteService.update(addedNote);

        Note updatedNote = noteService.getById(addedNote.getId());

        assertEquals("Updated Note", updatedNote.getTitle());
        assertEquals("This is an updated note", updatedNote.getContent());
    }

    @Test
    public void testGetNoteById() {
        Note note = new Note();
        note.setTitle("Test Note");
        note.setContent("This is a test note");

        Note addedNote = noteService.ad(note);

        Note retrievedNote = noteService.getById(addedNote.getId());

        assertEquals("Test Note", retrievedNote.getTitle());
        assertEquals("This is a test note", retrievedNote.getContent());
    }
}