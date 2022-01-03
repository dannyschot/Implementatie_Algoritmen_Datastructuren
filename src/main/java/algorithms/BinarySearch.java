package algorithms;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> {
    private List<T> data;


    public BinarySearch(List<T> data) {
        this.data = data;
    }

    public int find(T searchKey) {
        /**
         * Allereerst wordt de ondergrens en de bovengrens bepaald
         */
        int lowerBound = 0;
        int upperBound = data.size() - 1;


        while (lowerBound <= upperBound) { // Zolang de ondergrens kleiner of gelijk aan de bovengrens is
            int mid = (upperBound + lowerBound) / 2; // Wordt het midden bepaald
            if (searchKey.compareTo(data.get(mid)) < 0) { // Als het te zoeken element kleiner is dan het element in het midden
                upperBound = mid - 1; // Dan wordt de upperbound middelste index  - 1
            } else if (searchKey.compareTo(data.get(mid)) > 0) { // Als het te zoeken element groter is dan het element in het midden
                lowerBound = mid + 1; // Dan wordt de lowerbound middelste index + 1
            } else {
                return mid; // Als het midden het te zoeken element is, wordt die teruggegeven
            }
        }
        return data.size();
    }

}