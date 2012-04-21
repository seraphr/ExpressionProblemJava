package jp.seraphr.expr.problem.base;

public class BaseMain {
    private static interface Node extends BaseNode<Visitor, Node> {
    }

    private static interface Visitor extends BaseVisitor<Visitor, Node> {
    }

    private static class Add extends AddNode<Visitor, Node> implements Node {
        public Add(Node aLeft, Node aRight) {
            super(aLeft, aRight);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Sub extends SubNode<Visitor, Node> implements Node {
        public Sub(Node aLeft, Node aRight) {
            super(aLeft, aRight);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Number extends NumberNode<Visitor, Node> implements Node {
        public Number(int aValue) {
            super(aValue);
        }

        @Override
        public Node getThis() {
            return this;
        }
    }

    private static class Calculator extends CalcVisitor<Visitor, Node> implements Visitor {
        @Override
        public Visitor getThis() {
            return this;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Node tNode = new Sub(new Number(10), new Add(new Number(3), new Number(2)));

        System.out.println("10 - (3 + 2) = " + new Calculator().calc(tNode));
    }
}
