package main;

import model.Sheet;
import view.MainWindow;
import controllers.MainController;

import javax.swing.*;

public class Main{

    public static void main(String[] args) {

        Sheet model = new Sheet("Sheet");
        MainWindow view = new MainWindow(model);
        new MainController(model,view);

        SwingUtilities.invokeLater(view);
    }
}