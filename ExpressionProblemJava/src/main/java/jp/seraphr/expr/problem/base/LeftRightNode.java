/**
 *
 */
package jp.seraphr.expr.problem.base;

/**
 *
 */
public abstract class LeftRightNode<V extends BaseVisitor<V, N>, N extends BaseNode<V, N>> implements BaseNode<V, N> {
    public LeftRightNode(N aLeft, N aRight){
        mLeft = aLeft;
        mRight = aRight;
    }

    private N mLeft;
    private N mRight;

    @Override
    public N getLeft() {
        return mLeft;
    }

    @Override
    public N getRight() {
        return mRight;
    }

}
