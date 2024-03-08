package Model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.IGetModel;
import Model.Domain.Note;

public class NoteBook implements IGetModel {
    private List<Note> notes;
    private String fileName;
    public NoteBook(String fileName) {
        this.notes = new ArrayList<>();
        this.fileName = fileName;
    }
    public List<Note> getListNotes(){
        return this.notes;
    }
    public void SaveNotes(){
        try (FileWriter fileWriter = new FileWriter(fileName); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Note note : notes) {
                bufferedWriter.write(note.getId() + ";" + 
                                     note.getTitle() + ";" +
                                     note.getBody() + ";" + 
                                     note.getCreatedDateTime() + ";" + 
                                     note.getModifiedDateTime());
                bufferedWriter.newLine();
            }
            
        } catch (IOException e) {
            System.out.println("При сохранении заметки произошла ошибка: " + e.getMessage());
        }
    }
    public void loadNotes(){
        notes.clear();
        try (FileReader fileReader = new FileReader(fileName); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(";");
                int id = Integer.parseInt(fields[0]);
                String title = fields[1];
                String body = fields[2];
                LocalDateTime createdDateTime = LocalDateTime.parse(fields[3]);
                LocalDateTime modifiedDateTime = LocalDateTime.parse(fields[4]);
                Note note = new Note(id, title, body);
                notes.add(note);
            }
            
        } catch (IOException e) {
            System.out.println("При загрузке заметки произошла ошибка: " + e.getMessage());
        }
    }
    public void addNotes(String title, String body){
        int id;
        if (notes.isEmpty()) {
            id = 1;
        } else{
            id = notes.get(notes.size() - 1).getId() + 1;
        }
        Note note = new Note(id, title, body);
        notes.add(note);

    }
    public void editNote(int id, String title, String body){
        for (Note note : notes) {
            if (note.getId() == id) {
                note.setTitle(title);
                note.setBody(body);
                break;
            }
        }

    }
    public void deleteNote (int id){
        for (Note note : notes) {
            if (note.getId() == id) {
                notes.remove(note);
                break;
            }
        }
    }
    public void printNotes(){
        for (Note note : notes) {
            System.out.println("ID: " + note.getId());
            System.out.println("Заголовок: " + note.getTitle());
            System.out.println("Содержание: " + note.getBody());
            System.out.println("Дата создания: " + note.getCreatedDateTime());
            System.out.println("Дата изменения: " + note.getModifiedDateTime());
            System.out.println("");
        }
    }

    
    
}
