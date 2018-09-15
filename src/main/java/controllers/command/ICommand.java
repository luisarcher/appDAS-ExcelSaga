package controllers.command;

import model.Sheet;

public interface ICommand {

    void doCommand(Sheet model);
    void undoCommand(Sheet model);

}
