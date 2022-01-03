package datastructures;

public interface IDeque<E> {
    /**
     * Voegt een item aan de voorkant van de queue toe
     * @param data
     */
    void enqueFront(E data);

    /**
     * Voegt een item aan de achterkant van de queue toe
     * @param data
     */
    void enqueRear(E data);

    /**
     * Verwijdert items aan de voorkant van de queue
     */
    void dequeFront();

    /**
     * Verwijdert items aan de achterkant van de queue
     */
    void dequeRear();

    /**
     * Vraagt item op aan de voorkant van de queue
     * @return eerste item in queue
     */
    E peekFront();

    /**
     * Vraagt item op aan de voorkant van de queue
     * @return laatste item in queue
     */
    E peekRear();

    /**
     * Controleert of de lijst leeg is
     * @return true wanneer lijst leeg is, false wanneer niet leeg
     */
    boolean isEmpty();

    /**
     * Controleert of de lijst vol is
     * @return true wanneer lijst vol is, false wanneer niet vol
     */
    boolean isFull();

    /**
     *
     * @return geeft de diepte van de graph terug
     */
    int size();
}
