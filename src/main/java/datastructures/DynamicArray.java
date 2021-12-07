package datastructures;

import java.util.AbstractList;

public class DynamicArray<E> extends AbstractList<E> { // TODO:: In alle classes magic numbers weghalen
    private E[] array;
    private int capacity;
    private int current;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        array = (E[]) new Object[10];
        capacity = 1;
        current = 0;
    }

    @Override
    public int size() {
        return current;
    }

    @SuppressWarnings("unchecked")
    public boolean add(E data) {
        if (current == capacity) {
            E[] temp = (E[]) new Object[2 * capacity];

            if (capacity >= 0) {
                System.arraycopy(array, 0, temp, 0, capacity);
            }
            capacity *= 2;
            array = temp;
        }
        array[current] = data;
        current++;
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(int index, E element) {
        if (current == capacity) {
            E[] temp = (E[]) new Object[2 * capacity]; // TODO:: Methode van maken
        }

        if (current - index >= 0) {
            System.arraycopy(array, index, array, index + 1, current - index);
        }

        array[index] = element;
        current++;
    }

    @Override
    public E get(int index) {
        E element = null;
        if (indexOutOfRange(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index < current) {
            element = array[index];
        }
        return element;
    }

    public void delete() {
        array[current - 1] = null;
        current--;
        if(needsToBeShrunken()) shrink();
    }

    private boolean needsToBeShrunken() {
        return current <= capacity * 0.25;

    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        E[] temp = (E[]) new Object[capacity / 2];

        if (capacity / 2 >= 0) {
            System.arraycopy(array, 0, temp, 0, capacity / 2);
        }
        array = temp;
        capacity = capacity / 2;
    }

    private boolean indexOutOfRange(int index) {
        return index > capacity;
    }

    public void showElements() {
        for (E e : array) {
            System.out.println(e);
        }
    }
}
