package datastructures;

/**
 * Generieke Deque klasse. Commentaar per methode is te vinden in de interface IDeque
 * @param <E>
 */
public class Deque<E> implements IDeque<E> {
    private int maxSize;
    private E[] queueArray;
    private int front;
    private int rear;
    int nItems;

    /**
     * Constructor welke een Object lijst aanmaakt met een gegeven grootte. De front en de rear worden bepaald.
     * @param size initiële grootte
     */
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
        if (isFull()) { // Als de Deque vol is, dan wordt er niets toegevoegd.
            System.out.println("Dequeue is full!");
            return;
        }

        if (front == -1) { // Als de queue initieel leeg is
            front = 0;
            rear = 0;
        } else if (front == 0) { // Als de front op de eerste positie van de queue is
            front = maxSize - 1;
        } else {
            front = front - 1; // Als front elders in queue, verlaag positie met 1
        }
        queueArray[front] = data; // Vervolgens wordt de data op de juiste front positie geplaatst
        nItems++;
    }

    @Override
    public void enqueRear(E data) {
        if (isFull()) { // Als de Deque vol is, dan wordt er niets toegevoegd.
            System.out.println("Dequeue is full!");
            return;
        }

        if (front == -1) { // Als de queue initieel leeg is
            front = 0;
            rear = 0;
        } else if (rear == maxSize - 1) { // Als de rear op de laatste positie van de queue is
            rear = 0;
        } else {
            rear = rear + 1; // Verhoog rear positie met 1
        }
        queueArray[rear] = data; // Vervolgens wordt de data op de juiste front positie geplaatst
        nItems++;
    }

    @Override
    public void dequeFront() {
        if (isEmpty()) { // Als de Deque leeg is, kan er niets worden verwijderd
            System.out.println("Dequeue is empty");
            return;
        }
        if (front == rear) { // Als er maar 1 enkel element in de queue zit
            front = -1;
            rear = -1;
        } else { // Terug naar de initiële positie
            if (front == maxSize - 1) {
                front = 0;
            } else {
                front = front + 1; // Verhoog front positie met 1 om de huidige front waarde te verwijderen
            }
        }
        nItems--;
    }

    @Override
    public void dequeRear() {
        if (isEmpty()) { // Als de Deque leeg is, kan er niets worden verwijderd
            System.out.println("Dequeue is empty");
            return;
        }
        if (front == rear) { // ALs er 1 enkel element in de queue zit
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
