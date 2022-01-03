package datastructures;

/**
 * Een generieke Stack klasse
 * @param <E>
 */
public class StackCris<E> implements IStack<E>{
    private int maxSize;
    private E[] stackArray;
    private int top;

    /**
     * Constructur waarmee een nieuwe Object lijst wordt gecreëerd met een initiële size
     * @param size initiële grootte van de Stack
     */
    public StackCris(int size) {
        maxSize = size;
        stackArray = (E[]) new Object[size];
        top = -1; // Er is nog geen top
    }

    /**
     * Data wordt bovenop de Stack geplaatst
     * @param data data welke bewaard wordt in de Stack
     */
    @Override
    public void push(E data) {
        stackArray[++top] = data; // Eerst wordt de top verhoogd, voordat de data daarin wordt bewaard i.v.m. NullPointerException
    }

    /**
     * Verwijderd top element van de Stack
     * @return data welke verwijderd wordt uit Stack
     */
    @Override
    public E pop() {
        return stackArray[top--]; // Wordt wordt met 1 verlaagd
    }

    /**
     * Geeft top element terug zonder deze te verwijderen van de Stack
     * @return Top element van de Stack
     */
    @Override
    public E peek() {
        return stackArray[top];
    }

    /**
     * Controleert of de Stack leeg is
     * @return true of false wanneer deze respectievelijk leeg is of niet leeg is
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Controleert of de Stack vol is
     * @return true of false wanneer deze respectievelijk vol is of niet vol is
     */
    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     *
     * @return grootte van de Stack
     */
    @Override
    public int size() {
        return top + 1;
    }
}
