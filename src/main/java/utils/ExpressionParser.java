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
        cell = parseFunctionFilters(cell);

        // Apply cell filters
        cell = parseEvalFilters(cell);

        return cell;
    }

    public Cell parseFunctionFilters(Cell cell){

        AbstractFactory factory = AbstractFactory.getFactory(Constants.FUNCTION_FILTER_TYPE);
        if (factory == null) return cell;

        String[] _parts = cell.getValue().split("\\s");
        cell = factory.getFilter(_parts[0].replaceAll("=", ""),cell);

        return cell;
    }

    public Cell parseEvalFilters(Cell cell){

        AbstractFactory factory = AbstractFactory.getFactory(Constants.EVAL_FILTER_TYPE);
        if (factory == null) return cell;

        Cell _cell = null;
        String[] _parts = cell.getFilters().split("[\\s|\\(]");
        for(String _part : _parts){
            if (RegexMatcher.isText(_part)){
                _cell = factory.getFilter(_part,cell);
                if (_cell != null){
                    cell = _cell;
                }
            }
        }
        return cell;
    }
}
