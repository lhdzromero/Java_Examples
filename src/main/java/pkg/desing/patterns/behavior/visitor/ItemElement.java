package pkg.desing.patterns.behavior.visitor;

public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
