package datastructures;

public interface IPriorityQueue<E> {
    /**
     * Voegt element toe aan queue
     * @param data in te voeren data
     */
    void enqueue(E data);

    /**
     * verwijdert element uit de queue
     * @return Verwijderd element
     */
    E dequeue();

    /**
     * Geeft kleinste waarde terug
     * @return kleinste waarde
     */
    E peekMin();

    /**
     * Controleert of de lijst leeg is
     * @return True wanneer leeg, false wanneer vol
     */
    boolean isEmpty();

    /**
     * Controleert of de lijst vol is
     * @return true wanneer vol, false wanneer leeg
     */
    boolean isFull();
}
