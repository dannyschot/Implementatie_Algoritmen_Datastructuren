package algorithms;

import java.util.Collections;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {
    public void merge(List<T> firstHalf, List<T> secondHalf, List<T> array) {
        int currentIndexFirst = 0;
        int currentIndexSecond = 0;
        int currentIndexArray = 0;

        while(currentIndexFirst < firstHalf.size() && currentIndexSecond < secondHalf.size()) {
            /**
             * Als het huidige element van de linkerhelft kleiner is dan het huidige element van de rechterhelft
             */
            if(firstHalf.get(currentIndexFirst).compareTo(secondHalf.get(currentIndexSecond)) < 0) {
                array.set(currentIndexArray, (T) firstHalf.get(currentIndexFirst));
                currentIndexArray++;
                currentIndexFirst++;
            } else {
                array.set(currentIndexArray, (T) secondHalf.get(currentIndexSecond));
                currentIndexArray++;
                currentIndexSecond++;
            }
        }
        while(currentIndexFirst < firstHalf.size()) {
            array.set(currentIndexArray, firstHalf.get(currentIndexFirst));
            currentIndexArray++;
            currentIndexFirst++;
        }
        while(currentIndexSecond < secondHalf.size()) {
            array.set(currentIndexArray, secondHalf.get(currentIndexSecond));
            currentIndexArray++;
            currentIndexSecond++;
        }
    }

    public void mergeDescending(List<T> firstHalf, List<T> secondHalf, List<T> array) {
        int currentIndexFirst = 0;
        int currentIndexSecond = 0;
        int currentIndexArray = 0;

        while(currentIndexFirst < firstHalf.size() && currentIndexSecond < secondHalf.size()) {
            /**
             * Als het huidige element van de linkerhelft kleiner is dan het huidige element van de rechterhelft
             */
            if(firstHalf.get(currentIndexFirst).compareTo(secondHalf.get(currentIndexSecond)) > 0) {
                array.set(currentIndexArray, (T) firstHalf.get(currentIndexFirst));
                currentIndexArray++;
                currentIndexFirst++;
            } else {
                array.set(currentIndexArray, (T) secondHalf.get(currentIndexSecond));
                currentIndexArray++;
                currentIndexSecond++;
            }
        }
        while(currentIndexFirst < firstHalf.size()) {
            array.set(currentIndexArray, firstHalf.get(currentIndexFirst));
            currentIndexArray++;
            currentIndexFirst++;
        }
        while(currentIndexSecond < secondHalf.size()) {
            array.set(currentIndexArray, secondHalf.get(currentIndexSecond));
            currentIndexArray++;
            currentIndexSecond++;
        }
    }

    public void sortWithSortingLib(List<T> array) {
        Collections.sort(array);
    }

}
