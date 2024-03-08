import Controller.ControllerNoteClass;
import Controller.Interfaces.IGetModel;
import Controller.Interfaces.IGetView;
import Model.NoteBook;
import View.ViewNoteClass;

public class App {
    public static void main(String[] args) throws Exception {
        String fileName = "text.csv";
        IGetModel model = new NoteBook(fileName);
        IGetView view = new ViewNoteClass();
        ControllerNoteClass controller = new ControllerNoteClass(model, view);
        controller.run();
    }
}
