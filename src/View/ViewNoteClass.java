package View;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.*;
import Model.Domain.Note;

public class ViewNoteClass implements IGetView {
    public void printAllNotes(List<Note> notes){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("---Список заметок---");
        for (Note note : notes) {
            System.out.println("ID: " + note.getId());
            System.out.println("Заголовок: " + note.getTitle());
            System.out.println("Содержание: " + note.getBody());
            System.out.println("Дата создания: " + note.getCreatedDateTime().format(formatter));
            System.out.println("Дата изменения: " + note.getModifiedDateTime().format(formatter));
        }
        System.out.println("----------------------------------");
    }
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }
    public void showMenu(){
        System.out.println("Меню: ");
        System.out.println("1. Посмотреть заметки");
        System.out.println("2. Добавить заметку");
        System.out.println("3. Редактировать заметку" );
        System.out.println("4. Удалить заметку" );
        System.out.println("5. Сохранить заметки и выйти" );
    }
}
