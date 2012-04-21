/**
 *
 */
package jp.seraphr.expr.problem.ex;

import jp.seraphr.expr.problem.base.CalcVisitor;
import jp.seraphr.expr.problem.base.BaseNode;

/**
 *
 */
public abstract class ExCalcVisitor<V extends ExVisitor<V, N>, N extends BaseNode<V, N>> extends CalcVisitor<V, N> implements ExVisitor<V, N> {
    @Override
    public void visit(MulNode<V, N> aNode) {
        aNode.getRight().accept(getThis());
        aNode.getLeft().accept(getThis());

        mCalcStack.push(mCalcStack.pop() * mCalcStack.pop());
    }
}
