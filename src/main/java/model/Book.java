package model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private List<Sheet> sheets;
    private static final String SHEET_NAME_PREFIX = "Sheet ";

    public Book(){

        sheets = new ArrayList<Sheet>();
        this.addNewSheet();
    }

    public void addNewSheet(){
        addNewSheet(SHEET_NAME_PREFIX + sheets.size() + 1);
    }

    public void addNewSheet(String name){
        this.sheets.add(new Sheet(name));
    }

    public void deleteSheet(int i){
        this.sheets.remove(i);
    }

    public Sheet getSheet(int i){
        return this.sheets.get(i);
    }
}
