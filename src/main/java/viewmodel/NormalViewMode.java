package viewmodel;

import viewmodel.strategy.GetParsedData;
import model.Sheet;

public class NormalViewMode extends SheetTableViewModel{

    public NormalViewMode(Sheet model) {
        super(model);
        this.getDataStr = new GetParsedData(model);
    }
}
