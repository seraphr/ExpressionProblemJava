package jp.seraphr.expr.problem.ex2;

import jp.seraphr.expr.problem.base.BaseNode;
import jp.seraphr.expr.problem.ex.ExVisitor;

public interface ExNode<V extends ExVisitor<V, N>, N extends ExNode<V, N>> extends BaseNode<V, N> {
    public boolean eq(N aNode);
}
