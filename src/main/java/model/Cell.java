package model;

public class Cell {

    private int row;
    private int column;

    private Object value;

    public Cell(){

    }

    public Cell(Object value){

    }

    public Cell(Object value, int row, int column){

    }

    public void setValueObject(Object v){
        this.value = v;
    }
}
