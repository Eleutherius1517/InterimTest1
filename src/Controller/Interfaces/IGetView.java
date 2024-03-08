package Controller.Interfaces;

import java.util.List;

import Model.Domain.Note;

public interface IGetView {
    public void printAllNotes(List<Note> notes);
    public String prompt(String msg);
    public void showMenu();
}
