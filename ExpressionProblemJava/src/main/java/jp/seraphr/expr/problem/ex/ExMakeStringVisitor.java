/**
 *
 */
package jp.seraphr.expr.problem.ex;

import java.util.Stack;

import jp.seraphr.expr.problem.base.AddNode;
import jp.seraphr.expr.problem.base.BaseNode;
import jp.seraphr.expr.problem.base.NumberNode;
import jp.seraphr.expr.problem.base.SubNode;

/**
 *
 */
public abstract class ExMakeStringVisitor<V extends ExVisitor<V, N>, N extends BaseNode<V, N>> implements ExVisitor<V, N> {
    protected Stack<String> mStack = new Stack<String>();

    @Override
    public void visit(AddNode<V, N> aNode) {
        aNode.getRight().accept(getThis());
        aNode.getLeft().accept(getThis());

        String tResult = String.format("(%s + %s)", mStack.pop(), mStack.pop());
        mStack.push(tResult);
    }

    @Override
    public void visit(SubNode<V, N> aNode) {
        aNode.getRight().accept(getThis());
        aNode.getLeft().accept(getThis());

        String tResult = String.format("(%s - %s)", mStack.pop(), mStack.pop());
        mStack.push(tResult);
    }

    @Override
    public void visit(NumberNode<V, N> aNode) {
        mStack.push(aNode.getValue() + "");
    }

    @Override
    public void visit(MulNode<V, N> aNode) {
        aNode.getRight().accept(getThis());
        aNode.getLeft().accept(getThis());

        String tResult = String.format("%s * %s", mStack.pop(), mStack.pop());
        mStack.push(tResult);
    }

    public String calc(N aNode){
        aNode.accept(getThis());

        return mStack.pop();
    }
}
