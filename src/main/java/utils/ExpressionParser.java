package utils;

import filters.factory.AbstractFactory;
import model.Cell;
import org.apache.log4j.Logger;

public class ExpressionParser {

    private final static Logger logger = Logger.getLogger(ExpressionParser.class);

    private Cell decoratedCell;

    public ExpressionParser(){}

    public ExpressionParser(Cell cell){

        this.decoratedCell = cell;
    }

    public Cell parse(){

        if (this.decoratedCell == null)
            return null;

        return this.parse(this.decoratedCell);
    }

    public Cell parse(Cell cell){

        if (cell.toString().length() == 0 || !RegexMatcher.isFormula(cell.getValue())){
            return cell;
        }

        logger.debug("Formula detected, parsing data...");

        // Parse cell function formula result
        cell = parseByFilterType(Constants.FUNCTION_FILTER_TYPE, cell);

        // Apply cell filters
        //cell = parseByFilterType(Constants.EVAL_FILTER_TYPE,cell);

        return cell;
    }

    public Cell parseByFilterType(String filterType, Cell cell){

        AbstractFactory factory = AbstractFactory.getFactory(filterType);
        if (factory == null) return cell;

        String[] _parts = cell.getValue().split("\\s");
        cell = factory.getFilter(_parts[0].replaceAll("=", ""),cell);

        return cell;
    }
}
