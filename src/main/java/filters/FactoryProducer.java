package filters;

public class FactoryProducer {
    public static AbstractFactory getFactory(String cellType){
        if (cellType.equalsIgnoreCase(Integer.class.getName())){

            return new NumericFilterFactory();
        } else {

            return new TextFilterFactory();
        }
    }
}
