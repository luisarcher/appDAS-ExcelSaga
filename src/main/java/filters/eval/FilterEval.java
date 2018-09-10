package filters.eval;

import filters.Filter;
import model.Cell;

public abstract class FilterEval extends Filter{

    FilterEval(Cell decoratedCell){
        super(decoratedCell);
    }

    abstract String eval(String cellValue, String filterParam);

    @Override
    protected boolean acceptedParams(String expression) {
        return true;
    }

    @Override
    public String apply(String decoratedCellValue) {

        // vai buscar o filtro e ve se tem parametro
        // se tiver faz o parse e manda para eval
        // senao manda ""

        return null;
    }
}
