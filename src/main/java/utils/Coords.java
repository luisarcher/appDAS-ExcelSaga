package utils;

public class Coords {

    private Integer row;
    private Integer column;

    public Coords(Integer row, Integer column) {
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

    public static Coords parseCoords(String id){

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
            return new Coords(r,c);
        }

        return null;
    }
}
