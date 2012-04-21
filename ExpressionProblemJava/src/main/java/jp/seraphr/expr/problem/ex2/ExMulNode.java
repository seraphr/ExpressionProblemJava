package jp.seraphr.expr.problem.ex2;

import jp.seraphr.expr.problem.ex.ExVisitor;
import jp.seraphr.expr.problem.ex.MulNode;

public abstract class ExMulNode<V extends ExVisitor<V, N>, N extends ExNode<V, N>> extends MulNode<V, N> implements ExNode<V, N> {
    public ExMulNode(N aLeft, N aRight) {
        super(aLeft, aRight);
    }

    @Override
    public boolean eq(N aNode) {
        if(!aNode.getClass().equals(this.getClass()))
            return false;

        boolean tLeft = aNode.getLeft().eq(this.getLeft());
        boolean tRight = aNode.getRight().eq(this.getRight());

        return tLeft && tRight;
    }
}
