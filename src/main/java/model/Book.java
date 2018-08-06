package model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private static final String SHEET_NAME_PREFIX = "Sheet ";

    private List<Sheet> sheets;

    public Book(){

        sheets = new ArrayList<Sheet>();
        this.addNewSheet();
    }

    public void addNewSheet(){
        addNewSheet(SHEET_NAME_PREFIX + (sheets.size() + 1));
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

    public List<Sheet> getSheets(){
        return this.sheets;
    }

    public int getSheetCount(){
        return this.sheets.size();
    }

    public Sheet getLastSheet(){

        // We should just try catch an indexOutOfBounds here
        if (this.sheets != null && !this.sheets.isEmpty()){
            return this.sheets.get(this.sheets.size() -1);
        }
        return null;
    }
}
