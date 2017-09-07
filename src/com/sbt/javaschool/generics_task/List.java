package com.sbt.javaschool.generics_task;

import java.util.Collection;

public interface List <E> extends Iterable <E> {
    void add(E e);
    void add(int index, E element);
    E get(int index);
    E remove(int index);
    boolean addAll(Collection<? extends E> c);
    boolean copy(Collection<? super E> c);
}
