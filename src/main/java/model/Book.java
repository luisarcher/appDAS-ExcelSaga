package model;

import org.apache.log4j.Logger;
import utils.EventDispatcher;
import utils.IEventHandler;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private final static Logger logger = Logger.getLogger(Book.class);
    private static final String SHEET_NAME_PREFIX = "Sheet ";

    private EventDispatcher addSheetEventDispatcher;

    private List<Sheet> sheets;

    public Book(){


        this.sheets = new ArrayList<Sheet>();
        this.addSheetEventDispatcher = new EventDispatcher();

    }

    public void addNewSheet(){
        addNewSheet(SHEET_NAME_PREFIX + (sheets.size() + 1));
    }

    public void addNewSheet(String name){

        this.sheets.add(new Sheet(name));
        this.addSheetEventDispatcher.notifyObservers();
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

    public void addNewSheetEventListener(IEventHandler handler){

        this.addSheetEventDispatcher.register(handler);
    }

}
