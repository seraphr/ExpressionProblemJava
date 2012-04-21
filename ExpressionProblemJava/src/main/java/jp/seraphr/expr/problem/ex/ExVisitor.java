package jp.seraphr.expr.problem.ex;

import jp.seraphr.expr.problem.base.BaseNode;
import jp.seraphr.expr.problem.base.BaseVisitor;

public interface ExVisitor<V extends ExVisitor<V, N>, N extends BaseNode<V, N>> extends BaseVisitor<V, N> {
    public void visit(MulNode<V, N> aNode);
}
