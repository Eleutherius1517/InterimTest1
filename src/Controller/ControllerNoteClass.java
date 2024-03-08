package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.IGetModel;
import Controller.Interfaces.IGetView;
import Model.Domain.Note;

public class ControllerNoteClass {
    private IGetModel model;
    private IGetView view;
    public ControllerNoteClass(IGetModel model, IGetView view) {
        this.model = model;
        this.view = view;
    }
    public void run(){
        boolean getNewIter = true;
        while (getNewIter) {
            view.showMenu();
            String command = view.prompt("Введите номер операции: ");
            switch (command) {
                case "1":
                    System.out.println("НЕ ЗАБУДЬТЕ ОТСОРТИРОВАТЬ ЗАМЕТКИ ПО ДАТЕ ИЛИ ID");
                    view.printAllNotes(model.getListNotes());
                    break;
        
                case "2":
                    String title = view.prompt("Введите заголовок заметки: ");
                    String body = view.prompt("Введите содержание заметки: ");
                    model.addNotes(title, body);
                    System.out.println("Заметка успешно добавлена!");
                    break;
        
                case "3":
                    String strEditId;
                    int editId;
                    strEditId = view.prompt("Введите ID заметки, которую хотите отредактировать: ");
                    if (strEditId.matches("[-+]?\\d+")) {
                        editId = Integer.parseInt(strEditId);
                    }else{
                        System.out.println("Вы ввели невалидный ID! попробуйте еще раз!");
                        break;
                    }
                    String newTitle = view.prompt("Введите новый заголовок заметки: ");
                    String newBody = view.prompt("Введите новое содержание  заметки: ");
                    model.editNote(editId, newTitle, newBody);
                    System.out.println("Заметка успешно отредактирована!");
                    break;
        
                case "4":
                    String strDeleteId;
                    int deleteId;
                    strDeleteId = view.prompt("Введите ID заметки, которую хотите удалить: ");
                    if (strDeleteId.matches("[-+]?\\d+")) {
                        deleteId = Integer.parseInt(strDeleteId);
                    }else{
                        System.out.println("Вы ввели невалидный ID! попробуйте еще раз!");
                        break;
                    }
                    model.deleteNote(deleteId);
                    System.out.println("Заметка успешно удалена!");
                        break;
                case "5":
                        model.loadNotes();
                        System.out.println("Заметки успешно загруженны!");
                        System.out.println("НЕ ЗАБУДЬТЕ ОТСОРТИРОВАТЬ ЗАМЕТКИ ПО ДАТЕ ИЛИ ID");
                        view.printAllNotes(model.getListNotes());
                        break;
                case "6":
                    String strSelectId;
                    int selectId;
                    strSelectId = view.prompt("Введите ID заметки, которую хотите вывести на экран: ");
                    if (strSelectId.matches("[-+]?\\d+")) {
                        selectId = Integer.parseInt(strSelectId);
                    }else{
                        System.out.println("Вы ввели невалидный ID! попробуйте еще раз!");
                        break;
                    }
                        model.showNoteWithId(selectId);
                        System.out.println("Выбранная заметка распечатана!");
                        break;
                case "7":
                        model.sortNotesDateTime();
                        view.printAllNotes(model.getListNotes());
                        System.out.println("Заметки успешно отсортированы по дате изменения!");
                        break;
                case "8":
                        model.sortNotesId();
                        view.printAllNotes(model.getListNotes());
                        System.out.println("Заметки успешно отсортированы по ID!");
                        break;
            
                case "9":
                    model.SaveNotes();
                    System.out.println("Заметки успешно сохранены! Работа программы завершена!");
                    System.exit(0);
                    break;
        
                default:
                    System.out.println("Не распознанная команда! Повторите комманду еще раз!");
                    break;
            }
        }
        
    }
    
    
}
