package viewmodel;

import viewmodel.strategy.GetRawData;
import model.Sheet;

public class FunctionalViewMode extends SheetTableViewModel{

    public FunctionalViewMode(Sheet model) {
        super(model);
        this.getDataStr = new GetRawData(model);
    }
}
