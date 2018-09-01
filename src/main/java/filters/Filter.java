package filters;

// Template pattern
// Decorator pattern

import model.Cell;
import org.apache.log4j.Logger;

public abstract class Filter extends Cell{

    private final static Logger logger = Logger.getLogger(Filter.class);

    protected Cell decoratedCell;

    public Filter(Cell decoratedCell){
        super(decoratedCell.getValue());
        super.setModel(decoratedCell.getModel());
        this.decoratedCell = decoratedCell;
    }

    public abstract String removeFilterName(String expression);
    public abstract String apply(String expression);

    public String getValue(){
        return this.execute();
    }

    protected boolean acceptedParams(String expression){
        return true;
    }

    private String execute(){

        String _out = this.decoratedCell.getValue();

        if (!acceptedParams(_out)) {
            logger.debug("Params not accepted!");
            return "#Error params";
        }

        _out = apply(_out);
        _out = removeFilterName(_out);

        return _out;
    }

    // Algoritmo
    // execute()

    // lá dentro tem isValid de acordo com os requisitos do filtro
    // isValidCell implementada aqui

    // os filtros extendem esta classe para preencher o algoritmo no template


}
