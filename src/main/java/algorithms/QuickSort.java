package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> {
    List<T> unsortedList;

    /**
     * Bevat telkens de nog ongesorteerde lijst en een aanroep naar de recursieve sorteermethode
     * @param data ongesorteerde lijst
     */
    public void sort(List<T> data) {
        unsortedList = data;
        recursiveSort(0, data.size() - 1);
    }

    public void sortDescending(List<T> data) {
        unsortedList = data;
        recursiveSortDescending(0, data.size() - 1);
    }

    /**
     * Voorbeeldlijst: [2] [1] [8] [5] [9]
     * @param left linkerpointer
     * @param right rechterpoiner
     */
    private void recursiveSort(int left, int right) {
        try {
            if (right - left <= 0) { // Als de lijst een grootte van 1 of kleiner heeft, dan is die al gesorteerde (basis geval)
                return;
            } else { // Als de lijst een grootte van 2 of meer heeft
                T pivot = unsortedList.get(right); // Wordt de pivot bepaald. In dit geval [9]
                int partition = partition(left, right, pivot); // (0, 4, 9)
                recursiveSort(left, partition - 1); // Doe dit recursief voor het linkerdeel van de (sub)lijst
                recursiveSort(partition + 1, right); // Doe dit recursief voor het rechterdeel van de (sub)lijst
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    private void recursiveSortDescending(int left, int right) {
        try {
            if (right - left <= 0) { // Als de lijst een grootte van 1 of kleiner heeft, dan is die al gesorteerde (basis geval)
                return;
            } else { // Als de lijst een grootte van 2 of meer heeft
                T pivot = unsortedList.get(right); // Wordt de pivot bepaald. In dit geval [9]
                int partition = partitionDescending(left, right, pivot); // (0, 4, 9)
                recursiveSortDescending(left, partition - 1); // Doe dit recursief voor het linkerdeel van de (sub)lijst
                recursiveSortDescending(partition + 1, right); // Doe dit recursief voor het rechterdeel van de (sub)lijst
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    private int partition(int left, int right, T pivot) {
        int leftPartition = left - 1;
        int rightPartition = right;

        while (true) {
            while (unsortedList.get(++leftPartition).compareTo(pivot) < 0) { // verplaats pointer naar rechts zolang items kleiner zijn dan pivot
            }
            while (rightPartition > 0 && unsortedList.get(--rightPartition).compareTo(pivot) > 0) { // verplaatst pointer naar links zolang items groter zijn dan pivot
            }
            if (leftPartition >= rightPartition) { // Als de pointers elkaar 'raken', dan is de partitie gedaan en termineert de loop
                break;
            } else { // Pointer nog niet gepasseerd, dan worden de elementen gewisseld
                swap(leftPartition, rightPartition);
            }
        }
        swap(leftPartition, right); // De pivot wordt weer hersteld
        return leftPartition; // Pivot locatie wordt teruggegeven
    }

    private int partitionDescending(int left, int right, T pivot) {
        int leftPartition = left - 1;
        int rightPartition = right;

        while (true) {
            while (unsortedList.get(++leftPartition).compareTo(pivot) > 0) { // verplaats pointer naar rechts zolang items kleiner zijn dan pivot
            }
            while (rightPartition > 0 && unsortedList.get(--rightPartition).compareTo(pivot) < 0) { // verplaatst pointer naar links zolang items groter zijn dan pivot
            }
            if (leftPartition >= rightPartition) { // Als de pointers elkaar 'raken', dan is de partitie gedaan en termineert de loop
                break;
            } else { // Pointer nog niet gepasseerd, dan worden de elementen gewisseld
                swap(leftPartition, rightPartition);
            }
        }
        swap(leftPartition, right); // De pivot wordt weer hersteld
        return leftPartition; // Pivot locatie wordt teruggegeven
    }

    private void swap(int one, int two) {
        if (one == two) return;

        T temp = unsortedList.get(one);
        unsortedList.set(one, unsortedList.get(two));
        unsortedList.set(two, temp);
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }

    public void sortWithSortingLibDescending(ArrayList<T> array) {
        Collections.sort(array, Collections.reverseOrder());
    }

    public void display() {
        for(T element : unsortedList) {
            System.out.println(element);
        }
    }
}
