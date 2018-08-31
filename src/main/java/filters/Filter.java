package filters;

// Template pattern
// Decorator pattern

import model.Cell;

public abstract class Filter extends Cell{

    protected Cell decoratedCell;

    public Filter(Cell decoratedCell){
        super(decoratedCell.getValue());
        this.decoratedCell = decoratedCell;
    }

    protected boolean isCell(String expression){

        return expression.matches("[a-z]{1,2}[0-9]{1,2}");
    }

    public abstract String removeFilterName(String expression);
    public abstract String apply(String expression);

    public String getValue(){
        return this.execute();
    }

    private String execute(){

        String _out = this.decoratedCell.getValue();

        _out = removeFilterName(_out);
        _out = apply(_out);

        return _out;
    }

    // Algoritmo
    // execute()

    // lá dentro tem isValid de acordo com os requisitos do filtro
    // isValidCell implementada aqui

    // os filtros extendem esta classe para preencher o algoritmo no template

}
