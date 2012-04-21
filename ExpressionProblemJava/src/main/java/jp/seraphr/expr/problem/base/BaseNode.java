package jp.seraphr.expr.problem.base;

public interface BaseNode<V extends BaseVisitor<V, N>, N extends BaseNode<V, N>> {
    public N getLeft();
    public N getRight();

    /**
     * XXX 真面目にやると、これは要らない。
     * Javaでやると型引数がひどいどころじゃなくなるので、これで！
     *
     * @return
     */
    public N getThis();

    public void accept(V aVisitor);
}

