package storage;

import java.util.LinkedList;

/**
 * Created by Alexey on 11.12.2016.
 */
public class MyLinkedList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> first;
    private Node<E> last;

    public int size() {
        return 0;
    }

    public void add(E entity) {
        linkLast(entity);
    }

    public void remove(E entity) {

    }

    public E get(int i) {
        return null;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }

}
