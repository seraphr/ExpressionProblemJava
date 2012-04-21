/**
 *
 */
package jp.seraphr.expr.problem.base;

import java.util.Stack;

/**
 *
 */
public abstract class CalcVisitor<V extends BaseVisitor<V, N>, N extends BaseNode<V, N>> implements BaseVisitor<V, N> {
    protected Stack<Integer> mCalcStack = new Stack<Integer>();

    @Override
    public void visit(AddNode<V, N> aNode) {
        aNode.getRight().accept(getThis());
        aNode.getLeft().accept(getThis());

        mCalcStack.push(mCalcStack.pop() + mCalcStack.pop());
    }

    @Override
    public void visit(SubNode<V, N> aNode) {
        aNode.getRight().accept(getThis());
        aNode.getLeft().accept(getThis());

        mCalcStack.push(mCalcStack.pop() - mCalcStack.pop());
    }

    @Override
    public void visit(NumberNode<V, N> aNode) {
        mCalcStack.push(aNode.getValue());
    }

    public int calc(N aNode) {
        aNode.accept(getThis());

        return mCalcStack.pop();
    }
}
