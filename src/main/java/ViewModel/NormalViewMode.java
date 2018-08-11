package ViewModel;

import model.Sheet;

public class NormalViewMode extends SheetTableViewModel{

    public NormalViewMode(Sheet model) {
        super(model);
        this.getDataStr = new GetParsedData(model);
    }
}
