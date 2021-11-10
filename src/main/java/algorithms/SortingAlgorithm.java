package algorithms;

import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithm {

    public void sort(JSONArray array) {
        if (array.get(0).getClass().getSimpleName().equals("Long")) {
            Long[] longArray = convertToLongArray(array);
            insertionSortWithLong(longArray);
        } else if (array.get(0).getClass().getSimpleName().equals("Double")) {
            Double[] doubleArray = convertToDoubleArray(array);
            insertionSortWithDouble(doubleArray);
        }
    }
    
    private Long[] convertToLongArray(JSONArray array) {
        Long[] longArray = new Long[array.size()];

        for(int i = 0; i < array.size(); i++) {
            longArray[i] = (Long) array.get(i);
        }
        return longArray;
    }

    public void insertionSortWithLong(Long[] array) {
        for (int i = 1; i < array.length; i++) {
            Long currentNumber = array[i];
            int j = i - 1;
            while(j >= 0 && currentNumber < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = currentNumber;
        }
        for (Long aLong : array) {
            System.out.println(aLong);
        }
    }

    private Double[] convertToDoubleArray(JSONArray array) {
        Double[] doubleArray = new Double[array.size()];

        for(int i = 0; i < array.size(); i++) {
            doubleArray[i] = (Double) array.get(i);
        }
        return doubleArray;
    }

    public void insertionSortWithDouble(Double[] array) {
        for (int i = 1; i < array.length; i++) {
            Double currentNumber = array[i];
            int j = i - 1;
            while(j >= 0 && currentNumber < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = currentNumber;
        }
        for (Double aDouble : array) {
            System.out.println(aDouble);
        }
    }
}
