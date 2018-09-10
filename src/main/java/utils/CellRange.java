package utils;

public class CellRange {

    // leftLimit:rightLimit
    // Examples - a1:b2, y5:b3

    private Coords leftLimit;
    private Coords rightLimit;

    public CellRange(Coords leftLimit, Coords rightLimit) {
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }

    public Coords getLeftLimit() {
        return leftLimit;
    }

    public void setLeftLimit(Coords leftLimit) {
        this.leftLimit = leftLimit;
    }

    public Coords getRightLimit() {
        return rightLimit;
    }

    public void setRightLimit(Coords rightLimit) {
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
