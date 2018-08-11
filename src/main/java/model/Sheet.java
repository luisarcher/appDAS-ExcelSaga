package model;

public class Sheet{

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
        if (value != null) {
            cells[row][column].setValueObject(value);
        } else {
            cells[row][column].setValueObject("");
        }
    }
}
