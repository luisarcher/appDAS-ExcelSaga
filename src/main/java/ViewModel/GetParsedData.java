package ViewModel;

import model.Cell;
import model.Sheet;
import org.apache.log4j.Logger;
import utils.ExpressionParser;

public class GetParsedData implements IGetDataStrategy{

    private final static Logger logger = Logger.getLogger(GetParsedData.class);

    private Sheet model;

    GetParsedData(Sheet model){

        this.model = model;
    }

    public Cell getValueAt(int row, int column) {

        ExpressionParser parser = new ExpressionParser(model.getValueAt(row,column));
        return parser.parse();
    }
}
