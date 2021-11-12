package datastructures;

import exceptions.DynamicArrayException;

public class DynamicArray<E> {
    private int[] array;
    private int capacity;
    private int current;

    public DynamicArray() {
        array = new int[1];
        capacity = 1;
        current = 0;
    }

    public void add(int data) {
        if (current == capacity) {
            int[] temp = new int[2 * capacity];

            if (capacity >= 0) {
                System.arraycopy(array, 0, temp, 0, capacity);
            }
            capacity *= 2;
            array = temp;
        }
        array[current] = data;
        current++;
    }

    public void add(int data, int index) throws DynamicArrayException {
        if (indexOutOfRange(index)) {
            throw new DynamicArrayException();
        } else if (index == capacity) {
            add(data);
        }
        array[index] = data;
    }

    public int retreive(int index) {
        int element = 0;
        if (indexOutOfRange(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index < current) {
            element = array[index];
        }
        return element;
    }

    public void delete() {
        array[current - 1] = 0;
        current--;
        checkIfArrayNeedsToBeShrunken();
    }

    private void checkIfArrayNeedsToBeShrunken() {
        if (current <= capacity * 0.25) {
            int[] temp = new int[capacity / 2];

            if (capacity / 2 >= 0) {
                System.arraycopy(array, 0, temp, 0, capacity / 2);
            }
            array = temp;
            capacity = capacity / 2;
        }
    }

    public boolean indexOutOfRange(int index) {
        return index > capacity;
    }

    public int getSize() {
        return current;
    }

    public void showElements() {
        // print enkel de elementen die erin zitten
    }
}
