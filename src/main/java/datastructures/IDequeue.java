package datastructures;

public interface IDequeue<E> {
    void enqueFront(E data);
    void enqueRear(E data);
    void dequeFront();
    void dequeRear();
    E peekFront();
    E peekRear();
    boolean isEmpty();
    boolean isFull();
    int size();
}
