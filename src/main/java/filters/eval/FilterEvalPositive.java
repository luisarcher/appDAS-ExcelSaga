package filters.eval;

import model.Cell;
import utils.Constants;
import utils.RegexMatcher;

public class FilterEvalPositive extends FilterEval {

    public FilterEvalPositive(Cell decoratedCell) {
        super(decoratedCell);
    }

    public String getFilterId(){
        return Constants.FILTER_EVAL_POSITIVE;
    }

    @Override
    String eval(String cellValue, String filterParam) {

        int compareTo = 0;
        if (!filterParam.equalsIgnoreCase("")){
            /*if (RegexMatcher.isNumber())*/
            // Esta validacao tem de ser feita na classe de cima e os param teem de ser verificados pela classe base como na classe da soma isAcceptedParam
        }

        if (Integer.parseInt(cellValue) < compareTo){
            return "";
        }

        return cellValue;
    }
}
