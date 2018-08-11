package view;

import ViewModel.SheetTableViewModel;

import javax.swing.*;

public class SheetView extends JTable {

    public SheetView(SheetTableViewModel model){

        super.setModel(model);
        this.init();

    }

    public SheetView(){

    }

    private void init(){

        //setCellSelectionEnabled(true);
    }

    public void setModel(SheetTableViewModel model){
        super.setModel(model);
    }
}
