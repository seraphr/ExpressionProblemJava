package jp.seraphr.expr.problem.base;

public interface BaseVisitor<V extends BaseVisitor<V, N>, N extends BaseNode<V, N>> {
    public V getThis();
    public void visit(AddNode<V, N> aNode);
    public void visit(SubNode<V, N> aNode);
    public void visit(NumberNode<V, N> aNode);
}
