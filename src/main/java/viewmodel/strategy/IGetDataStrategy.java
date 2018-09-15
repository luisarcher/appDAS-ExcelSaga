package viewmodel.strategy;

import model.Cell;

public interface IGetDataStrategy {

    Cell getValueAt(int row, int column);

}
