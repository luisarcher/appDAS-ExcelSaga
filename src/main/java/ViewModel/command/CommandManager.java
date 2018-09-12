package ViewModel.command;

import model.Sheet;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private List<ICommand> undoList;
    private List<ICommand> redoList;
    private Sheet model;


    public CommandManager(Sheet model) {

        undoList = new ArrayList<ICommand>();
        redoList = new ArrayList<ICommand>();
        this.model = model;
    }

    public void apply(ICommand c){

        c.doCommand(this.model);
        redoList.clear();
        undoList.add(c);
    }

    public void undo(){

        if(undoList.isEmpty()){
            return;
        }

        ICommand last = undoList.remove(undoList.size() -1);
        last.undoCommand(this.model);
        redoList.add(last);
    }

    public void redo(){

        if(undoList.isEmpty()){
            return;
        }

        ICommand last = redoList.remove(redoList.size() -1);
        last.doCommand(this.model);
        undoList.add(last);

    }
}
