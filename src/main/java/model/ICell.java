package model;

public interface ICell {

    String getValue();
    IModel getModel();
    String getFilters();
    RowCol getCoords();

}
