package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadixSort<T extends Comparable<T>> {

    public void sort(Long[] data) {
        final int RADIX = 10;
        List<Long>[] bucket = new ArrayList[RADIX];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Long>();
        }

        boolean maxLength = false;
        int tmp = -1;
        int placement = 1;

        while (!maxLength) {
            maxLength = true;
            for (Long i : data) {
                tmp = (int) (i / placement);
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Long i : bucket[b]) {
                    data[a++] = i;
                }
                bucket[b].clear();
            }
            placement *= RADIX;
        }
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }
}
