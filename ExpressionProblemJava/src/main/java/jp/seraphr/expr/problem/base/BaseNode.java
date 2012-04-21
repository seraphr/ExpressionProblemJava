package jp.seraphr.expr.problem.base;

public interface BaseNode<V extends BaseVisitor<V, N>, N extends BaseNode<V, N>> {
    public N getLeft();
    public N getRight();

    public void accept(V aVisitor);
}

