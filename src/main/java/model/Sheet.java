package model;

import org.apache.log4j.Logger;

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
                cells[i][j] = new Cell("", i, j);
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
        if (input.equals("=")) {
            return;
        }
        if (input != null) {
            if (input.matches("[0-9]+")){
                logger.debug("Matches integer!");
                cells[row][column].setValueObject(Integer.valueOf(input));
            } else {
                cells[row][column].setValueObject(input);
            }
        } else {
            cells[row][column].setValueObject("");
        }
    }

    public Cell getValueById(String id){

        if (id.matches("[A-Z]{1,2}[1-9][0-9]*")) {

            // Get the column
            String col = id.replaceAll("[0-9]", "");
            if (col.length() == 1) {
                col = "@".concat(col);
            }
            int c = 26 * (col.charAt(0) - 64) + col.charAt(1) - 64;

            // Get the Row
            int r = Integer.parseInt(id.replaceAll("[A-Z]", ""));

            return getValueAt(r,c);
        }
        return null;
    }
}
