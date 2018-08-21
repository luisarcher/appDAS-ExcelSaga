package filters;

public abstract class AbstractFactory {
    abstract Filter getTextFilter(String cellType);
    abstract Filter getNumericFilter(String cellType);
}
