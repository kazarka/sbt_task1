package com.sbt.javaschool.generics_task;


public class Node <E> {
    private E value;
    private Node prev;
    private Node next;

    public Node(E value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
