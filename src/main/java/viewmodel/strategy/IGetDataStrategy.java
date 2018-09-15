package viewmodel.strategy;

import model.Cell;
import model.ICell;

public interface IGetDataStrategy {

    ICell getValueAt(int row, int column);

}
