package filters;

import filters.factory.AbstractFactory;
import model.Cell;
import model.RowCol;
import model.ICell;
import org.apache.log4j.Logger;

public class ExpressionParser {

    private final static Logger logger = Logger.getLogger(ExpressionParser.class);

    private Cell selectedCell;

    public ExpressionParser(){}

    public ExpressionParser(Cell cell){

        this.selectedCell = cell;
    }

    public ICell parse(){

        if (this.selectedCell == null)
            return null;

        return this.parse(this.selectedCell);
    }

    public ICell parse(Cell cell){

        if (cell.toString().length() == 0){
            return cell;
        }

        // Check for cyclic redundancy
        if (cell.getValue().toUpperCase().contains(
                RowCol.getCoordsAsId(
                        cell.getCoords().getRow(),
                        cell.getCoords().getColumn()
                )
        )){
            return new FilterError(cell,Constants.ERROR_CYCLIC);
        }

        ICell decoratedCell = cell;

        if (RegexMatcher.isFormula(cell.getValue())) {

            logger.debug("Formula detected, parsing data...");

            // Parse cell function formula result
            decoratedCell = parseFunctionFilters(cell);
        }

        // Apply cell filters
        logger.debug("Parsing Eval Filters...");
        decoratedCell = parseEvalFilters(decoratedCell);

        return decoratedCell;
    }

    public ICell parseFunctionFilters(ICell cell){

        AbstractFactory factory = AbstractFactory.getFactory(Constants.FUNCTION_FILTER_TYPE);
        if (factory == null) return cell;

        String[] _parts = cell.getValue().split("\\s");
        ICell decoratedCell = factory.getFilter(_parts[0].replaceAll("=", ""),cell);

        // If the formula was not valid (no filter was created) and we could't decorate the cell.
        if (decoratedCell == null){
            return new FilterError(cell,Constants.ERROR_FORMULA);
        }

        return decoratedCell;
    }

    public ICell parseEvalFilters(ICell cell){

        AbstractFactory factory = AbstractFactory.getFactory(Constants.EVAL_FILTER_TYPE);
        if (factory == null){
            return cell;
        }

        if (cell.getFilters().equalsIgnoreCase("")){
            return cell;
        }

        String[] _parts = cell.getFilters().split("[\\s|\\(]");
        for(String _part : _parts){
            logger.debug("Checking if '" + _part + "' is an Eval Filter...");
            if (RegexMatcher.isText(_part)){
                ICell _cell = factory.getFilter(_part,cell);
                if (_cell != null){
                    cell = _cell;
                }
            }
        }
        return cell;
    }
}
