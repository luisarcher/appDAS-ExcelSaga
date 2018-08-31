package filters;

import model.Cell;

public /*abstract class*/ interface AbstractFactory {

    /*abstract Filter getTextFilter(String filter);
    abstract Filter getNumericFilter(String filter);
    abstract Filter getEvaluationFilter(String filter);*/

    Filter getFilter(String filterName, Cell cell);
}
