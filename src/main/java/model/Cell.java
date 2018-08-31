package model;

import org.apache.log4j.Logger;

public class Cell {

    private final static Logger logger = Logger.getLogger(Cell.class);

    private String value;

    @Override
    public String toString() {
        return getValue();
    }

    public Cell(String value) {
        this.value = value;
    }

    public void setValueObject(String v) {
        logger.debug("New Object: " + v.getClass().getName());
        this.value = v;
    }

    public String getValue(){
        return this.value;
    }
}