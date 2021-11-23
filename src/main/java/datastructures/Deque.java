package datastructures;

public class Deque<E> implements IDequeue<E>{
    private int maxSize;
    private E[] queueArray;
    private int front;
    private int rear;
    int nItems;

    @SuppressWarnings("unchecked")
    public Deque(int size) {
        maxSize = size;
        queueArray = (E[]) new Object[size];
        front = -1;
        rear = 0;
        nItems = 0;
    }

    @Override
    public void enqueFront(E data) {
        if (isFull()) {
            System.out.println("Dequeue is full!");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = maxSize - 1;
        } else {
            front = front - 1;
        }
        queueArray[front] = data;
        nItems++;
    }

    @Override
    public void enqueRear(E data) {
        if (isFull()) {
            System.out.println("Dequeue is full!");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == maxSize - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }
        queueArray[rear] = data;
        nItems++;
    }

    @Override
    public void dequeFront() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            if (front == maxSize - 1) {
                front = 0;
            } else {
                front = front + 1;
            }
        }
        nItems--;
    }

    @Override
    public void dequeRear() {
        if (isEmpty()) {
            System.out.println("Dequeue is empty");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = maxSize - 1;
        } else {
            rear = rear - 1;
        }
        nItems--;
    }

    @Override
    public E peekFront() {
        if (isEmpty()) {
            System.out.println("Nothing to show. Dequeue is empty");
            return null;
        }
        return queueArray[front];
    }

    @Override
    public E peekRear() {
        if(isEmpty() || rear < 0)
        {
            System.out.println("Nothing to show. Dequeue is empty");
            return null;
        }
        return queueArray[rear];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return ((front == 0 && rear == maxSize - 1) || front == rear + 1);
    }

    @Override
    public int size() {
        return nItems;
    }
}
