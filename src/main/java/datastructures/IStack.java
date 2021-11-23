package datastructures;

public interface IStack<E> {

    /**
     * Pushes element on top of the stack
     * @param data
     */
    void push(E data);

    /**
     * Returns the top element of the stack and decrements size
     * @return
     */
    E pop();

    /**
     * Peek at top of the stack (returns last element but does not decrement size)
     * @return
     */
    E peek();

    /**
     * Checks if stack is empty
     * @return
     */
    boolean isEmpty();

    /**
     * Checks if stack is full
     * @return
     */
    boolean isFull();

    /**
     * Returns the size of the stack
     * @return
     */
    int size();
}
