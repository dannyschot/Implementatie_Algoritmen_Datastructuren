package datastructures;

/**
 * Een generieke doubly linked list klasse welke gebruikt maakt van Links om data op te slaan.
 * Middels een ListIterator kan er geïtereerd worden door de lijst.
 * @param <E>
 */
public class DoublyLinkedList<E>  {
    private Link<E> first;
    private Link<E> last;
    private int size;

    /**
     * Constructor waarbij een eerste (lege) link en een laatste (lege) link worden gecreëerd
     */
    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    /**
     * Indien de eerste link null is, is de lijst leeg.
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     *
     * @return Geeft een ListIterator object terug waarmee door de lijst kan worden geïtereerd
     */
    public ListIterator<E> getIterator() {
        return new ListIterator<>(this);
    }

    /**
     * Insertie vooraan in de lijst.
     * @param link Link Object welke data bevat.
     * Link op eerste positie wordt toegevoegd. Daarnaast wordt de size opgehoogd.
     */
    public void insertFirst(Link<E> link) {
        first = link;
        size++;
    }


    /**
     * Eerste link wordt verwijderd
     */
    public void deleteFirst() {
        if (first.next == null) { // Als er enkel een item in de lijst zit, dan is last null
            last = null;
        } else {
            first.next.previous = null; // Als de lijst meerdere items bevat, dan wordt de oude next op null gezet
        }
        first = first.next;
        size--;
    }

    /**
     *
     * @return de grootte van de linked list (aantal elementen)
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @return data welke in de eerste Link bewaard wordt
     */
    public E getFirstElement() {
        return first.getData();
    }

    /**
     *
     * @return data welke in de laatste Link bewaard wordt
     */
    public E getLastElement() {
        return last.getData();
    }

    /**
     *
     * @return de eerste Link in de lijst
     */
    public Link<E> getFirstLink() {
        return this.first;
    }

    /**
     *
     * @return de laatste Link in de lijst
     */
    public Link<E> getLastLink() {
        return this.last;
    }
}
