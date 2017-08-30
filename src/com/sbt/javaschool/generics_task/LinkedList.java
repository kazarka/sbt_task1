package com.sbt.javaschool.generics_task;

import javax.xml.bind.Element;
import java.util.Collection;
import java.util.Iterator;

public class LinkedList <E> implements List <E> {

    private Node<E> head;
    private Node<E> tail;

    /**
     * Adds element to the head
     * @param e value of adding element
     */
    public void addToHead(E e) {
        head = new Node<>(e, null, head);

        if (head.getNext() == null)
            tail = head;
        else
            head.getNext().setPrev(head);
    }

    /**
     * Adds element to the tail
     * @param e value of adding element
     */
    @Override
    public void add(E e) {
        tail = new Node<>(e, tail, null);

        if (tail.getPrev() == null)
            head = tail;
        else
            tail.getPrev().setNext(tail);

    }

    /**
     * Adds element to the specified index.
     * @param index index to insert
     * @param element value of adding element
     */
    @Override
    public void add(int index, E element) {
        Node curNode = head;

        for (int i = 0; i < index; ++i) {
            if (curNode == null)
                throw new IndexOutOfBoundsException();
            curNode = curNode.getNext();
        }

        if (curNode == head)
            addToHead(element);
        else if (curNode == null)
            add(element);
        else {
            curNode.setPrev(new Node<>(element, curNode.getPrev(), curNode));
            curNode.getPrev().getPrev().setNext(curNode.getPrev());
        }
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            Node<E> curNode = head;

            @Override
            public boolean hasNext() {
                return curNode != null;
            }

            @Override
            public E next() {
                E element = curNode.getValue();
                curNode = curNode.getNext();
                return element;
            }

        };
        
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean copy(Collection<? super E> c) {
        return false;
    }
}
