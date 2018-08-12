package model;

public class Cell {

    private int myRow;
    private int myColumn;

    private Object value;

    public Cell(){

    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Cell(String value){
        this.value = value;
    }

    Cell(Object value, int row, int column){

        this.myRow = row;
        this.myColumn = column;
        this.value = value;

    }

    void setValueObject(Object v){
        this.value = v;
    }

}
