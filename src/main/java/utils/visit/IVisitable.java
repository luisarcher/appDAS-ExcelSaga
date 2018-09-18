package utils.visit;

public interface IVisitable {

    String accept(IVisitor visitor, String cellId);
}
