/**
 *
 */
package jp.seraphr.expr.problem.base;

/**
 *
 */
public class AddNode<V extends BaseVisitor<V, N>, N extends BaseNode<V, N>> extends LeftRightNode<V, N> {

    public AddNode(N aLeft, N aRight) {
        super(aLeft, aRight);
    }


    @Override
    public void accept(V aVisitor) {
        aVisitor.visit(this);
    }
}
