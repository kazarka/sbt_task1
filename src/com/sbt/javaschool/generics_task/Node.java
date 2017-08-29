package com.sbt.javaschool.generics_task;


public class Node <E> {
    private E node;
    private Node prev;
    private Node next;

    public Node(E node, Node prev, Node next) {
        this.node = node;
        this.prev = prev;
        this.next = next;
    }

    public E getNode() {
        return node;
    }

    public void setNode(E node) {
        this.node = node;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
