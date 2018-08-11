package ViewModel;

import model.Sheet;

public class FunctionalViewMode extends SheetTableViewModel{

    public FunctionalViewMode(Sheet model) {
        super(model);
        this.getDataStr = new GetRawData(model);
    }
}
