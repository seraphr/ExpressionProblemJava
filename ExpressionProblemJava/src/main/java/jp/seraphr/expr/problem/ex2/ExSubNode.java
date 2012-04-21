package jp.seraphr.expr.problem.ex2;

import jp.seraphr.expr.problem.base.SubNode;
import jp.seraphr.expr.problem.ex.ExVisitor;

public abstract class ExSubNode<V extends ExVisitor<V, N>, N extends ExNode<V, N>> extends SubNode<V, N> implements ExNode<V, N> {
    public ExSubNode(N aLeft, N aRight) {
        super(aLeft, aRight);
    }

    @Override
    public boolean eq(N aNode) {
        if (!aNode.getClass().equals(this.getClass()))
            return false;

        boolean tLeft = aNode.getLeft().eq(this.getLeft());
        boolean tRight = aNode.getRight().eq(this.getRight());

        return tLeft && tRight;
    }

}
