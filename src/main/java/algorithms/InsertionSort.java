package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> {
    private String errorMessage;

    public void sort(List<T> data) {
        int in, out;
        try {
            for (out = 1; out < data.size(); out++) { // Out is de scheidslijn
                if (!data.get(out - 1).getClass().getName().equals(data.get(out).getClass().getName())) {
                    System.out.println("NOT OF EQUAL TYPE");
                    return;
                }
                T temp = data.get(out); // Element dat vergeleken wordt, wordt opgeslagen
                in = out; // Het begint vanaf het te vergelijken element
                while (in > 0 && data.get(in - 1).compareTo(temp) >= 0) { // Doorgaan tot een item kleiner is, als element kleiner is dan:
                    data.set(in, data.get(in - 1)); // Swap het item links van het te vergelijken element
                    --in; // Schuif een positie naar links zodat dit door kan gaan tot het eerste element is vergeleken
                }
                data.set(in, temp); // Insertie van opgeslagen element
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                this.errorMessage = "Dataset contains null values. Cannot sort null values.";
                System.out.println(this.errorMessage);
            }
        }
    }

    public void sortDescending(List<T> data) {
        int in, out;
        try {
            for (out = 1; out < data.size(); out++) { // Out is de scheidslijn
                T temp = data.get(out); // Element dat vergeleken wordt, wordt opgeslagen
                in = out; // Het begint vanaf het te vergelijken element
                while (in > 0 && data.get(in - 1).compareTo(temp) <= 0) { // Doorgaan tot een item groter is, als element groter is dan:
                    data.set(in, data.get(in - 1)); // Swap het item links van het te vergelijken element
                    --in; // Schuif een positie naar links zodat dit door kan gaan tot het eerste element is vergeleken
                }
                data.set(in, temp); // Insertie van opgeslagen element
            }
        } catch (Exception e) {
            System.out.println("Dataset contains null values. Cannot sort null values.");
        }
    }

    /**
     * Enkel om de nieuwe gesorteerde lijst te vergelijken met de lijst die gesorteerd is met de sort methode van Java.
     * @param array De array die gesorteerd dient te worden
     */
    @SuppressWarnings("unchecked")
    public void sortWithSortingLib(ArrayList array) {
        Collections.sort(array);
    }

    /**
     * Enkel om de nieuwe gesorteerde lijst te vergelijken met de lijst die gesorteerd is met de sort methode van Java.
     * @param array De array die gesorteerd dient te worden
     */
    @SuppressWarnings("unchecked")
    public void sortWithSortingLibDescending(ArrayList array) {
        Collections.sort(array, Collections.reverseOrder());
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
