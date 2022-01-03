package algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class TimSort<T extends Comparable<T>> {
    static int MIN_MERGE = 32; // Gekozen voor een run van 32

    /**
     *
     * @param n MIN_MERGE
     * @return De helft van de MIN_MERGE warde
     */
    public static int minRunLength(int n)
    {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1); // Controleert per bit of het 1 of 0 is. Als 1 van beiden 1 is, dan is r 1
            n >>= 1; // n is n met de laatste bit verwijdert
        }
        return n + r;
    }

    /**
     *
     * @param arr Array welke gesorteerd dient te worden
     * @param left Begin
     * @param right Eind
     */
    public void insertionSort(T[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j].compareTo(temp) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    @SuppressWarnings("unchecked")
    public void merge(T[] arr, int left, int middle, int right) {
        /**
         * Originele array wordt in twee helften gebroken
         */
        int len1 = middle - left + 1;
        int len2 = right - middle;
        T[] leftSubArray = (T[]) new Comparable[len1];
        T[] rightSubArray = (T[]) new Comparable[len2];
        System.arraycopy(arr, left, leftSubArray, 0, len1);
        for (int x = 0; x < len2; x++)
        {
            rightSubArray[x] = arr[middle + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < len1 && j < len2)
        {
            if (leftSubArray[i].compareTo(rightSubArray[j]) <= 0)
            {
                arr[k] = leftSubArray[i];
                i++;
            }
            else {
                arr[k] = rightSubArray[j];
                j++;
            }
            k++;
        }

        /**
         * Na het vergelijken worden de twee subarrays samengevoegd tot een grotere subarray
         */
        while (i < len1)
        {
            arr[k] = leftSubArray[i];
            k++;
            i++;
        }

        while (j < len2)
        {
            arr[k] = rightSubArray[j];
            k++;
            j++;
        }
    }

    public void timSort(T[] arr, int n) {
        try {
            int minRun = minRunLength(MIN_MERGE);
            for (int i = 0; i < n; i += minRun) {
                insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1))); // Roept insertion sort aan tot i (+= 16) de size van de array heeft bereikt
            }
            for (int size = minRun; size < n; size = 2 * size) { // Loopt tot size (16) de grootte van de lijst heeft bereikt
                for (int left = 0; left < n; left += 2 * size) { // Loopt tot left de grootte van de lijst heeft bereikt
                    int mid = left + size - 1;
                    int right = Math.min((left + 2 * size - 1), (n - 1));
                    if (mid < right)
                        merge(arr, left, mid, right);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }
}
