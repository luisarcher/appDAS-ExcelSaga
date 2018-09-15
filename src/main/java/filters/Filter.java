package filters;

import model.ICell;
import model.Sheet;
import org.apache.log4j.Logger;

public abstract class Filter implements ICell{

    private final static Logger logger = Logger.getLogger(Filter.class);

    protected ICell decoratedCell;

    protected abstract boolean acceptedParams(String expression);
    protected abstract boolean isAcceptedParam(String param);
    protected abstract String apply(String expression);

    public Filter(ICell decoratedCell){
        this.decoratedCell = decoratedCell;
    }

    public String getValue(){
        return this.decoratedCell.getValue().replaceAll(
                decoratedCell.getValue(), this.execute()
        );
    }

    private String execute(){

        String _out = this.decoratedCell.getValue();

        if (!acceptedParams(_out)) {
            logger.debug("Params not accepted!");
            return Constants.ERROR_PARAM;
        }

        return apply(_out);
    }

    public Sheet getModel(){
        return this.decoratedCell.getModel();
    }

    public String getFilters(){
        return this.decoratedCell.getFilters();
    }
}
