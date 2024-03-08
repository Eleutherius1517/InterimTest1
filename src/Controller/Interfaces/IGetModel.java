package Controller.Interfaces;

import java.util.List;

import Model.Domain.Note;

public interface IGetModel {
    public List<Note> getListNotes();
    public void SaveNotes();
    public void loadNotes();
    public void addNotes(String title, String body);
    public void editNote(int id, String title, String body);
    public void deleteNote (int id);
    public void sortNotesDateTime();
    public void sortNotesId();
    public void showNoteWithId(int id);

}
