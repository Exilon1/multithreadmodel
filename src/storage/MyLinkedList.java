package storage;

import java.util.Iterator;


/**
 * Created by Alexey on 11.12.2016.
 */
public class MyLinkedList<E> implements Iterable<E> {

    private int size = 0;
    private int iterCount=0;


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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                if(get(iterCount) != null)
                    return true;
                else return false;
            }

            @Override
            public E next() {
                return get(iterCount++);
            }
        };
    }


    private Node<E> first;
    private Node<E> last;

    public int size() {
        return size;
    }

    public void add(E entity) {
        attachLast(entity);
    }

    public boolean remove(E entity) {
        if (entity == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    detach(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (entity.equals(x.item)) {
                    detach(x);
                    return true;
                }
            }
        }
        return false;
    }

    public E get(int i) {
        if(isElementIndex(i))
            throw new IndexOutOfBoundsException();
        return (E) node(i).item;
    }

    private void attachLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private E detach(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

}
