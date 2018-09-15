package filters;

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

        if (cell.toString().length() == 0){
            return cell;
        }

        if (RegexMatcher.isFormula(cell.getValue())) {

            logger.debug("Formula detected, parsing data...");

            // Parse cell function formula result
            cell = parseFunctionFilters(cell);
        }

        // Apply cell filters
        logger.debug("Parsing Eval Filters...");
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
        if (factory == null){
            return cell;
        }

        if (cell.getFilters().equalsIgnoreCase("")){
            return cell;
        }

        Cell _cell = null;
        String[] _parts = cell.getFilters().split("[\\s|\\(]");
        for(String _part : _parts){
            logger.debug("Checking if '" + _part + "' is an Eval Filter...");
            if (RegexMatcher.isText(_part)){
                logger.debug("'" + _part + "' is text...");
                _cell = factory.getFilter(_part,cell);
                if (_cell != null){
                    cell = _cell;
                }
            }
        }
        return cell;
    }
}