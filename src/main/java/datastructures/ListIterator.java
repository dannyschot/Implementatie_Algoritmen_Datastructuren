package datastructures;

/**
 * Een generieke iterator welke gekoppeld is aan een instantie van een Doubly Linked List.
 * Hiermee kan de gebruiker door de linked list itereren en eventueel elk individueel element in de lijst manipuleren
 * @param <T>
 */
public class ListIterator<T> {
    private Link<T> current;
    private Link<T> previous;
    private DoublyLinkedList<T> currentDoublyLinkedList;

    /**
     * Constructor welke een geïnstantieerde doubly linked list accepteerd als argument en ervoor zorgt dat de iterator bij de eerste Link begint
     * @param list
     */
    public ListIterator(DoublyLinkedList<T> list) {
        currentDoublyLinkedList = list;
        reset();
    }

    /**
     * Gaat naar de volgende Link
     */
    public void nextLink() {
        previous = current; // De nieuwe previous is waar de current nu naar verwijst
        current = current.next; // De nieuwe current is de volgende Link waar de current Link naar verwijst
    }

    /**
     *
     * @return geeft de huidige current Link terug
     */
    public Link<T> getCurrent() {
        return current;
    }

    /**
     *
     * @param data accepteert een waarde opgeslagen als een niet-primitief datatype welke kan worden opgeslagen in een Link
     *             na de huidige current Link.
     */
    public void insertAfter(T data) {
        Link<T> newLink = new Link<>(data); // Een nieuwe Link wordt gecreëerd met de nieuwe data

        if (currentDoublyLinkedList.isEmpty()) { // Eerst wordt gecontroleerd of de lijst leeg is
            currentDoublyLinkedList.insertFirst(newLink); // Als de lijst leeg is, wordt de insertFirst methode van de gekoppelde linked list aangeroepen
            current = newLink; // De huidige current is de nieuw gecreëerde Link
        } else { // Als de lijst niet leeg is
            newLink.next = current.next; // De next Link van de nieuwe Link is de Link waar de current Link naar verwijst
            current.next = newLink; // De current next Link verwijst nu naar de nieuwe Link
            nextLink(); // De verwijzing naar de nieuwe Link wordt nu in orde gemaakt
        }
    }

    /**
     *
     * @param data accepteert een waarde opgeslagen als een niet-primitief datatype welke kan worden opgeslagen in een Link
     *             voor de huidige current Link.
     */
    public void insertBefore(T data) {
        Link<T> newLink = new Link<>(data); // Een nieuwe Link wordt gecreëerd met de nieuwe data

        if (previous == null) { // Als de iterator aan het begin van de lijst staat of de lijst is leeg
            newLink.next = currentDoublyLinkedList.getFirstLink(); // De eerste Link wordt opgevraagd en wordt als next Link opgeslagen voor de nieuwe Link
            currentDoublyLinkedList.insertFirst(newLink); // De nieuwe Link wordt als eerste Link opgeslagen in de linked list
            reset(); // De juiste verwijzingen worden gecreëerd
        } else { // Als de iterator niet aan het begin van de lijst staat
            newLink.next = previous.next; // De next verwijzing van de nieuwe Link is de next verwijzing van de vorige Link
            previous.next = newLink; // De vorige Link krijgt nu een next verwijzing naar de nieuwe Link
            current = newLink; // De huidige nieuwe current is de nieuwe Link
        }
    }

    /**
     * Verwijdert Link waar de current naar verwijst
     * @return Geeft data van verwijderde Link terug
     */
    public T deleteCurrent() {
        T value = current.getData(); // Slaat de data op in een variabele om terug te geven
        if (previous == null) { // Als de iterator aan het begin van de lijst staat
            currentDoublyLinkedList.insertFirst(current.next); // De nieuwe eerste Link is waar de huidige current.next naar verwijst
            reset(); // De verwijzingen worden in orde gemaakt
        } else { // Als de iterator niet aan het begin staat
            previous.next = current.next; // De verwijzing naar de next Link van de vorige Link wordt nu de next verwijzing van de current Link (Hiermee wordt de current verwijderd)
            if (atEnd()) { // Als de iterator aan het einde is gekomen van de lijst worden de verwijzingen weer in orde gemaakt en de iterator weer terug naar het begin verplaatst
                reset();
            } else { // Als dit niet het geval is, dan is de huidige current, de next Link van de huidige current
                current = current.next;
            }
        }
        return value;
    }

    /**
     * Begint weer bij de eerste Link
     */
    public void reset() {
        current = currentDoublyLinkedList.getFirstLink(); // Vraagt de eerste Link op van de gekoppelde linked list
        previous = null;
    }

    /**
     *
     * @return true wanneer de iterator de laatste Link heeft bereikt
     */
    public boolean atEnd() {
        return current.next == null;
    }
}
