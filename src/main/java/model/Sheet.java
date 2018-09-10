package model;

import org.apache.log4j.Logger;
import utils.Coords;
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
                cells[i][j] = new Cell(this,"");

                cells[i][j].setFilters("");
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

        cells[row][column].setValue(input);
    }

    public Cell getValueById(String id){

        Coords coords = convertToCoords(id);
        return getValueAt(coords.getRow(),coords.getColumn());

    }

    public Coords convertToCoords(String id){

        id = id.toUpperCase();
        if (RegexMatcher.isCell(id)) {

            // Get the column
            String col = id.replaceAll("[0-9]", "");
            if (col.length() == 1) {
                col = "@".concat(col);
            }
            int c = 26 * (col.charAt(0) - 64) + col.charAt(1) - 64;

            // Get the Row
            int r = Integer.parseInt(id.replaceAll("(?i)[A-Za-z]", ""));

            r = r - 1;
            c = c - 1;

            logger.debug("Converting: '" + id + "' into: Row:'" + r + "' and Col: '" + c + "'");
            return new Coords(r,c);
        }

        return null;
    }
}
