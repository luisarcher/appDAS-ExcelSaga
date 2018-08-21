package model;

import org.apache.log4j.Logger;

public class Cell <T> {

    private final static Logger logger = Logger.getLogger(Cell.class);

    private int myRow;
    private int myColumn;

    private T value;

    public Cell() {

    }

    @Override
    public String toString() {
        return "" + getValue();
    }

    public Cell(T value) {
        this.value = value;
    }

    Cell(T value, int row, int column) {

        this.myRow = row;
        this.myColumn = column;
        this.value = value;

    }

    void setValueObject(T v) {
        logger.debug("New Object: " + v.getClass().getName());
        this.value = v;
    }

    T getValue(){
        return this.value;
    }
}