package jp.seraphr.expr.problem.ex;

import jp.seraphr.expr.problem.base.LeftRightNode;
import jp.seraphr.expr.problem.base.BaseNode;

public class MulNode<V extends ExVisitor<V, N>, N extends BaseNode<V, N>> extends LeftRightNode<V, N> {
    public MulNode(N aLeft, N aRight) {
        super(aLeft, aRight);
    }

    @Override
    public void accept(V aVisitor) {
        aVisitor.visit(this);
    }
}
