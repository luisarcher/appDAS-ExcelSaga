package model;

import org.apache.log4j.Logger;
import utils.RegexMatcher;

public class Sheet{

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

    private void initCells(int rows, int cols){

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell("");

                // We need a reference to the model inside a cell in case the formula reference other cells.
                cells[i][j].setModel(this);
            }
        }
    }

    public int getRowCount() {
        return this.cells.length;
    }

    public int getColumnCount() {
        return this.cells[0].length;
    }

    public Cell getValueAt(int row, int col) {
        return cells[row][col];
    }

    public String getSheetName(){
        return this.sheetName;
    }

    public void setValueAt(Object value, int row, int column) {
        String input = (String) value;
        if (input.equals("="))
            return;

        cells[row][column].setValueObject(input);
    }

    public Cell getValueById(String id){

        if (RegexMatcher.isCell(id)) {

            // Get the column
            String col = id.replaceAll("[0-9]", "");
            if (col.length() == 1) {
                col = "@".concat(col);
            }
            int c = 26 * (col.charAt(0) - 64) + col.charAt(1) - 64;

            // Get the Row
            int r = Integer.parseInt(id.replaceAll("(?i)[A-Za-z]", ""));

            return getValueAt(r,c);
        }
        return null;
    }
}
