package jp.seraphr.expr.problem.base;

public abstract class Container<V extends BaseVisitor<V, N>, N extends BaseNode<V, N>> {
    public abstract N newValue(int aValue);
    public abstract N newAdd(N aLeft, N aRight);
    public abstract N newSub(N aLeft, N aRight);


    interface A<T extends A<T, S>, S extends X<T, S>>{}
    interface X<T extends A<T, S>, S extends X<T, S>>{}
    class AA<T extends AA<T, S>, S extends X<T,S>> implements A<T, S>{}

    interface B<T extends B<T, S>, S extends Y<T, S>> extends A<T, S>{}
    interface Y<T extends B<T, S>, S extends Y<T, S>> extends X<T, S>{}
    class BB<T extends BB<T, S>, S extends Y<T, S>> extends AA<T, S> implements B<T, S>{}
}
