package jp.seraphr.expr.problem.ex2;

import jp.seraphr.expr.problem.ex.ExCalcVisitor;
import jp.seraphr.expr.problem.ex.ExMakeStringVisitor;
import jp.seraphr.expr.problem.ex.ExVisitor;


public class Ex2Main {
    private static interface Node extends ExNode<Visitor, Node> {
    }

    private static interface Visitor extends ExVisitor<Visitor, Node> {
    }

    private static class Add extends ExAddNode<Visitor, Node> implements Node {
        public Add(Node aLeft, Node aRight) {
            super(aLeft, aRight);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Sub extends ExSubNode<Visitor, Node> implements Node {
        public Sub(Node aLeft, Node aRight) {
            super(aLeft, aRight);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Mul extends ExMulNode<Visitor, Node> implements Node {
        public Mul(Node aLeft, Node aRight) {
            super(aLeft, aRight);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Number extends ExNumberNode<Visitor, Node> implements Node {
        public Number(int aValue) {
            super(aValue);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Calculator extends ExCalcVisitor<Visitor, Node> implements Visitor {
        @Override
        public Visitor getThis() {
            return this;
        }
    }

    private static class MakeString extends ExMakeStringVisitor<Visitor, Node> implements Visitor {
        @Override
        public Visitor getThis() {
            return this;
        }
    }

    private static class CountEq extends CountEqVisitor<Visitor, Node> implements Visitor{
        public CountEq(Node aNode) {
            super(aNode);
        }

        @Override
        public Visitor getThis() {
            return this;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Node tNode = new Add(new Mul(new Add(new Number(1), new Number(2)), new Number(2)), new Mul(new Sub(new Number(10), new Number(1)), new Add(new Number(1), new Number(2))));
        Node tLongNode = new Mul(tNode, tNode);
        Node tOne = new Number(1);
        Node tTwo = new Number(2);
        Node tTen = new Number(10);

        System.out.println(new MakeString().calc(tNode) + " = " + new Calculator().calc(tNode));
        System.out.println(new MakeString().calc(tLongNode) + " = " + new Calculator().calc(tLongNode));

        find(tNode, tOne);
        find(tNode, tTwo);
        find(tNode, tTen);
        find(tLongNode, tNode);
    }

    private static void find(Node aSearched, Node aCond){
        System.out.println("find " + count(aSearched, aCond) + " : " + toString(aCond) + " in " + toString(aSearched));
    }

    private static String toString(Node aNode){
        return new MakeString().calc(aNode);
    }

    private static int count(Node aSearched, Node aCond){
        return new CountEq(aCond).calc(aSearched);
    }
}
