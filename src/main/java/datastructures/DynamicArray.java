package datastructures;

import java.util.AbstractList;

/**
 * Generieke dynamische rij waarin niet-primitieve datatypen kunnen worden opgeslagen en opgehaald.
 * @param <E>
 */
public class DynamicArray<E> extends AbstractList<E> {
    private E[] array;
    private int capacity;
    private int current;

    /**
     * Constructor waarmee een initiële capaciteit en grootte wordt geinstantieerd van een generieke Object array
     */
    @SuppressWarnings("unchecked")
    public DynamicArray() {
        array = (E[]) new Object[1];
        capacity = 1;
        current = 0;
    }


    /**
     * Voeg element toe aan de Object array. Op het moment dat de huidige index gelijk is aan de maximale capaciteit, dan wordt er een
     * nieuwe tijdelijke Object array aangemaakt die 2x zo groot is. Vervolgens worden de waardes gekopieerd van de oude array naar de tijdelijke.
     * De laatste kopieerslag is de tijdelijke array verplaatsen naar de globale obect array.
     * Dan wordt het element op de juiste index geplaatst en de current verhoogd
     * @param data element
     */
    @SuppressWarnings("unchecked")
    public void addElement(E data) {
        if (current == capacity) {
            E[] temp = (E[]) new Object[2 * capacity];

            if (capacity >= 0) {
                System.arraycopy(array, 0, temp, 0, capacity);
            }
            capacity *= 2;
            array = temp;
        }
        array[current] = data;
        current++;
    }

    /**
     *
     * @param index gewenste positie in de rij waar het element kan worden opgeslagen. Eerst wordt de oude rij geupdated waarbij de elementen worden
     * gekopieerd vanaf de opgegeven index. Vervolgens wordt op de vrije positie het element opgeslagen.
     * @param element het data element welke opgeslagen dient te worden
     */
    public void addElement(int index, E element) {
        try {
            if (current - index >= 0) {
                System.arraycopy(array, index, array, index + 1, current - index);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("U heeft een index meegegeven die buiten de capaciteit van de array ligt");
        }
        array[index] = element;
        current++;
    }

    /**
     *
     * @param index De index van het element dat terug dient te worden gegeven
     * @return Het element dat op de index is opgeslagen
     */
    @Override
    public E get(int index) {
        E element = null;
        if (indexOutOfRange(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index < current) {
            element = array[index];
        }
        return element;
    }

    /**
     * Verwijdert een element uit de rij. Vervolgens wordt gecontroleerd of de rij dient te krimpen.
     */
    public void delete() {
        array[current - 1] = null;
        current--;
        if(needsToBeShrunken()) shrink();
    }

    /**
     *
     * @return huidige index waar een element op zal worden geplaatst
     */
    @Override
    public int size() {
        return current;
    }

    /**
     *
     * @return Huidige maximale capaciteit van de rij
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Controleert of de rij tot een kwart gevuld is. Zo ja? Dan dient deze te krimpen.
     * @return
     */
    private boolean needsToBeShrunken() {
        return current <= capacity * 0.25;

    }

    /**
     * Krimpt de rij wanneer deze maar tot een kwart is gevuld. De eerste elementen worden gekopieerd in een nieuwe rij die 2x zo klein is
     */
    @SuppressWarnings("unchecked")
    private void shrink() {
        E[] temp = (E[]) new Object[capacity / 2];

        if (capacity / 2 >= 0) {
            System.arraycopy(array, 0, temp, 0, capacity / 2);
        }
        array = temp;
        capacity = capacity / 2;
    }

    /**
     *
     * @param index index waar een element op wordt geslagen
     * @return Geeft terug of de huidige index binnen de capaciteitslimiet valt
     */
    private boolean indexOutOfRange(int index) {
        return index > capacity;
    }

}
