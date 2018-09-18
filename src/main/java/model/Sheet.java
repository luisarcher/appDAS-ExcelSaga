package model;

import org.apache.log4j.Logger;
import utils.visit.IVisitable;
import utils.visit.IVisitor;

public class Sheet implements IModel{

    private final static Logger logger = Logger.getLogger(Sheet.class);

    private static final int DEFAULT_NUM_ROWS = 30;
    private static final int DEFAULT_NUM_COLS = 40;

    private String sheetName;
    private Cell[][] cells;

    public Sheet(String name){

        this(name,DEFAULT_NUM_ROWS, DEFAULT_NUM_COLS);
    }

    public Sheet(String name, int rows, int cols){

        this.sheetName = name;

        cells = new Cell[rows][cols];
        initCells(rows,cols);
    }

    /*@Override
    public String accept(IVisitor visitor, String cellId) {
        return visitor.visit(this.getValueById(cellId).getValue());
    }*/

    /**
     *
     * @param rows
     * @param cols
     */
    private void initCells(int rows, int cols){

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(this,"");

                cells[i][j].setFilters("");
                cells[i][j].setCoords(new RowCol(i,j));
            }
        }
    }

    public int getRowCount() {
        return this.cells.length;
    }

    public int getColumnCount() {
        return this.cells[0].length;
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public Cell getValueAt(int row, int col) {
        return cells[row][col];
    }

    public String getSheetName(){
        return this.sheetName;
    }

    public void setValueAt(String value, int row, int column) {

        if (value.equals("="))
            return;

        cells[row][column].setValue(value);
    }

    public Cell getValueById(String id){

        RowCol coords = RowCol.parseCoords(id);
        return getValueAt(coords.getRow(),coords.getColumn());

    }
}
