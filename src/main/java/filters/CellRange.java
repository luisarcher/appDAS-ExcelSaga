package filters;

import model.RowCol;

public class CellRange {

    // leftLimit:rightLimit
    // Examples - a1:b2, y5:b3

    private RowCol leftLimit;
    private RowCol rightLimit;

    public CellRange(RowCol leftLimit, RowCol rightLimit) {
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }

    public RowCol getLeftLimit() {
        return leftLimit;
    }

    public void setLeftLimit(RowCol leftLimit) {
        this.leftLimit = leftLimit;
    }

    public RowCol getRightLimit() {
        return rightLimit;
    }

    public void setRightLimit(RowCol rightLimit) {
        this.rightLimit = rightLimit;
    }

    public Integer getMinimumRow(){
        return (leftLimit.getRow() < rightLimit.getRow() ? leftLimit.getRow() : rightLimit.getRow());
    }

    public Integer getMaximumRow(){
        return (leftLimit.getRow() > rightLimit.getRow() ? leftLimit.getRow() : rightLimit.getRow());
    }

    public Integer getMinimumColumn(){
        return (leftLimit.getColumn() < rightLimit.getColumn() ? leftLimit.getColumn() : rightLimit.getColumn());
    }

    public Integer getMaximumColumn(){
        return (leftLimit.getColumn() > rightLimit.getColumn() ? leftLimit.getColumn() : rightLimit.getColumn());
    }
}
