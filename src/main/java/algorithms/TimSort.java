package algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class TimSort<T extends Comparable<T>> {
    static int MIN_MERGE = 32;

    InsertionSort<T> insertionSort = new InsertionSort<>();

    public static int minRunLength(int n)
    {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public void insertionSort(T[] arr, int left,
                                     int right)
    {
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
    public void merge(T[] arr, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        T[] left = (T[]) new Comparable[len1];
        T[] right = (T[]) new Comparable[len2];
        System.arraycopy(arr, l, left, 0, len1);
        for (int x = 0; x < len2; x++)
        {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2)
        {
            if (left[i].compareTo(right[j]) <= 0)
            {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public void timSort(T[] arr, int n) {
        int minRun = minRunLength(MIN_MERGE);

        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size) {

            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                        (n - 1));

                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }
}
