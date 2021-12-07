package datastructures;

public class PriorityQueueCris<E extends Comparable<? super E>> implements IPriorityQueue<E> {
    private int maxSize;
    private E[] queueArray;
    private int nItems;

    @SuppressWarnings("unchecked")
    public PriorityQueueCris(int size) {
        maxSize = size;
        queueArray = (E[]) new Comparable[size];
        nItems = 0;
    }

    @Override
    public void enqueue(E data) {
        int j;

        if (nItems == 0) {
            queueArray[nItems++] = data;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (queueArray[j].compareTo(data) < 0) {
                    queueArray[j + 1] = queueArray[j];
                } else {
                    break;
                }
            }
            queueArray[j + 1] = data;
            nItems++;
        }
    }

    @Override
    public E dequeue() {
        return queueArray[--nItems];
    }

    @Override
    public E peekMin() {
        return queueArray[nItems - 1];
    }

    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }

    @Override
    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }
}
