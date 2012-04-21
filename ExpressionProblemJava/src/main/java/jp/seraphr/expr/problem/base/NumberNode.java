/**
 *
 */
package jp.seraphr.expr.problem.base;


/**
 *
 */
public abstract class NumberNode<V extends BaseVisitor<V, N>, N extends BaseNode<V, N>> implements BaseNode<V, N> {

    public NumberNode(int aValue) {
        super();
        mValue = aValue;
    }

    private int mValue;

    @Override
    public abstract N getThis();

    @Override
    public N getLeft() {
        throw new RuntimeException();
    }

    @Override
    public N getRight() {
        throw new RuntimeException();
    }

    @Override
    public void accept(V aVisitor) {
        aVisitor.visit(this);
    }

    public int getValue() {
        return mValue;
    }

}
