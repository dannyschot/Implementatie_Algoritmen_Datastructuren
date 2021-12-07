package datastructures;

public class StackCris<E> implements IStack<E>{
    private int maxSize;
    private E[] stackArray;
    private int top;

    public StackCris(int size) {
        maxSize = size;
        stackArray = (E[]) new Object[size];
        top = -1;
    }

    @Override
    public void push(E data) {
        stackArray[++top] = data; // Need to increment top before data is set, otherwise program will throw out of bounds exception
    }

    @Override
    public E pop() {
        return stackArray[top--];
    }

    @Override
    public E peek() {
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
