/**
 *
 */
package jp.seraphr.expr.problem.base;

/**
 *
 */
public abstract class SubNode<V extends BaseVisitor<V, N>, N extends BaseNode<V, N>> extends LeftRightNode<V, N> {
    public SubNode(N aLeft, N aRight) {
        super(aLeft, aRight);
    }

    @Override
    public abstract N getThis();

    @Override
    public void accept(V aVisitor) {
        aVisitor.visit(this);
    }
}
