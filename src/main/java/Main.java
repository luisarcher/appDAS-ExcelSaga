import model.Book;
import view.MainWindow;
import controllers.MainController;

import javax.swing.*;

public class Main{
    public static void main(String[] args) {

        Book model = new Book();
        MainWindow view = new MainWindow(model);
        new MainController(model,view);

        SwingUtilities.invokeLater(view);
    }
}