package utils;

import filters.*;
import model.Cell;
import model.Sheet;
import org.apache.log4j.Logger;

public class ExpressionParser {

    private final static Logger logger = Logger.getLogger(ExpressionParser.class);

    private Cell decoratedCell;

    public ExpressionParser(){

    }

    public ExpressionParser(Sheet model , Cell cell){

        this.decoratedCell = cell;
        this.decoratedCell.setModel(model);
    }

    public Cell parse(Cell cell){

        if (cell.toString().length() == 0|| !isFormula(cell.getValue())){
            return cell;
        }

        logger.debug("Formula detected, parsing data...");

        //this.decoratedCell = cell;

        AbstractFactory factory = FactoryProducer.getFactory(ConstFilters.SPECIAL_FILTERS);
        this.decoratedCell = factory.getFilter(ConstFilters.FORMULA_CHAR_FILTER,cell);

        // Detect and decorate in case of the presence of any text filter
        this.decoratedCell = parseByFilter("text", this.decoratedCell);

        // Detect and decorate in case of the presence of any numeric filter
        this.decoratedCell = parseByFilter("numeric", this.decoratedCell);

        return this.decoratedCell;

    }

    public Cell parse(){

        if (this.decoratedCell == null)
            return null;

        return this.parse(this.decoratedCell);
    }

    private Cell parseByFilter(String filterType, Cell cell){

        AbstractFactory factory = FactoryProducer.getFactory(filterType);
        if (factory == null) return cell;

        String[] _parts = cell.getValue().split("[\\s\\(\\)]");
        for (String _part : _parts){

            logger.debug("Formula part: " + _part);
            Cell _decoratedCell = factory.getFilter(_part, cell);
            if (_decoratedCell != null){

                cell = _decoratedCell;
                logger.debug("Filter applied: " + cell.getClass().getName());

            }
        }

        return cell;
    }

    public Cell getParsedCell(){
        return this.decoratedCell;
    }

    /*public String getParsedCell(Cell cell){

    }*/

    /* ===== HELPER FUNCS ===== */

    private static boolean isFormula(String expression){
        return expression.charAt(0) == '=';
    }
}
