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
     * Returns node by index
     * @param index nodes index
     * @return node of list
     */
    private Node<E> getNode(int index) {
        Node<E> curNode = head;

        for (int i = 0; i < index; ++i) {
            if (curNode == null)
                throw new IndexOutOfBoundsException();
            curNode = curNode.getNext();
        }

        return curNode;
    }

    /**
     * Adds element to the specified index.
     * @param index index to insert
     * @param element value of adding element
     */
    @Override
    public void add(int index, E element) {
        Node<E> curNode = getNode(index);

        if (curNode == head)
            addToHead(element);
        else if (curNode == null)
            add(element);
        else {
            curNode.setPrev(new Node<>(element, curNode.getPrev(), curNode));
            curNode.getPrev().getPrev().setNext(curNode.getPrev());
        }
    }

    /**
     * Get value from list by index
     * @param index values index
     * @return value from list
     */
    @Override
    public E get(int index) {
        return getNode(index).getValue();
    }

    /**
     * Removes element from head of the list
     * @return value of removed element
     */
    private E removeFromHead() {
        E element = head.getValue();

        head = head.getNext();

        if (head == null)
            tail = null;
        else
            head.setPrev(null);

        return element;
    }

    /**
     * Removes element from tail of the list
     * @return value of removed element
     */
    private E removeFromTail() {
        E element = tail.getValue();

        tail = tail.getPrev();

        if (tail == null)
            head = null;
        else
            tail.setNext(null);

        return element;
    }

    /**
     * Removes element by index
     * @param index index of element to remove
     * @return value of removed element
     */
    @Override
    public E remove(int index) {
        Node<E> curNode = getNode(index);

        if (curNode == head)
            return removeFromHead();
        else if (curNode == tail)
            return removeFromTail();
        else {
            E element = curNode.getValue();

            curNode.getPrev().setNext(curNode.getNext());
            curNode.getNext().setPrev(curNode.getPrev());
            curNode = curNode.getNext();

            return element;
        }
    }

    /**
     * Returns iterator for list
     * @return iterator
     */
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

    /**
     * Return size of linked list
     * @return  size of list
     */
    public int size() {
        int count = 0;

        for (E e : this)
            ++count;

        return count;
    }

    /**
     * Adds all elements from collection to the linked list
     * @param c collection to be added into list
     * @return true, if all elements was added.
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        int oldSize = this.size();

        for (E aC : c)
            add(aC);

        return this.size() != oldSize;
    }

    /**
     * Copies all elements from linked list to the collection
     * @param c collection to be copied into
     * @return true, if all elements was added.
     */
    @Override
    public boolean copy(Collection<? super E> c) {
        int oldSize = c.size();

        for (E element: this)
            c.add(element);

        return c.size() != oldSize;
    }
}
