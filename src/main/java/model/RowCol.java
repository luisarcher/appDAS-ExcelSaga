package model;

import filters.RegexMatcher;

public class RowCol {

    private Integer row;
    private Integer column;

    public RowCol(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public static RowCol parseCoords(String id){

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

            //logger.debug("Converting: '" + id + "' into: Row:'" + r + "' and Col: '" + c + "'");
            return new RowCol(r,c);
        }

        return null;
    }

    public static String getCoordsAsId(Integer row, int column){

        ++row;
        return toLetter(column) + row.toString();

    }

    private static String toLetter(int number) {
        StringBuilder sb = new StringBuilder();
        ++number;
        while (number-- > 0) {
            sb.append((char)('A' + (number % 26)));
            number /= 26;
        }
        return sb.reverse().toString();
    }
}
