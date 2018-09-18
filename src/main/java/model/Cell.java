package model;

import org.apache.log4j.Logger;

public class Cell implements ICell {

    private final static Logger logger = Logger.getLogger(Cell.class);

    private IModel sheet;
    private String value;
    private RowCol coords;

    private String filters;

    /*public Cell(String value) {
        this.value = value;
    }*/

    public Cell(IModel sheet, String value) {
        this.sheet = sheet;
        this.value = value;
        this.filters = "";
        this.coords = new RowCol(-1,-1);
    }

    /*public Cell(Cell cell){
        this.sheet = cell.getModel();
        this.value = cell.getValue();
        this.filters = cell.getFilters();
        this.coords = cell.getCoords();
    }*/

    @Override
    public String toString() {
        return this.getValue();
    }

    public void setValue(String v) {
        this.value = v;
    }

    public String getValue(){
        return this.value;
    }

    public IModel getModel(){
        return this.sheet;
    }

    public void setModel(Sheet model){
        this.sheet = model;
    }

    public String getFilters() {
        return this.filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public RowCol getCoords() {
        return coords;
    }

    public void setCoords(RowCol coords) {
        this.coords = coords;
    }
}