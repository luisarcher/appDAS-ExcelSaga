package view;

import ViewModel.SheetTableViewModel;

import javax.swing.*;
import java.awt.*;

public class SheetView extends JTable {

    public SheetView(SheetTableViewModel model){

        super.setModel(model);
        this.init();

    }

    SheetView(){

        this.init();
    }

    private void init(){

        setFont(new Font("Times", Font.PLAIN, 16));
        setCellSelectionEnabled(true);
        setRowHeight(30);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    public void setup(){
        resizeAndRepaint();
    }

    public void setModel(SheetTableViewModel model){
        super.setModel(model);
    }
}
