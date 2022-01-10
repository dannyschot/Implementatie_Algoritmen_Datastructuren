package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadixSort<T extends Comparable<T>> {
    private String errorMessage;

    @SuppressWarnings("unchecked")
    public void sortLong(ArrayList<Long> data) {
        try {
            final int RADIX = 10;
            List<Long>[] bucket = new ArrayList[RADIX]; // Declaratie en instantiatie van Bucket[]

            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new ArrayList<>(); // Bucket wordt gevuld met subarrays
            }

            // Sorteren begint
            boolean maxLength = false;
            int tmp;
            int placement = 1;

            while (!maxLength) {
                maxLength = true;
                // Split input tussen lijsten
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
                        data.set(a++, i);
                    }
                    bucket[b].clear();
                }
                placement *= RADIX;
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                this.errorMessage = "Dataset contains null values. Cannot sort null values.";
                System.out.println(this.errorMessage);
            } else if (e instanceof ClassCastException) {
                this.errorMessage = "Contains elements which are not of equal type";
                System.out.println(this.errorMessage);
            }
        }
    }

    public void sortWithSortingLib(ArrayList<T> array) {
        Collections.sort(array);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void sortDouble(ArrayList<Double> data) {
        try {
            final int RADIX = 10;
            ArrayList[] bucket = new ArrayList[RADIX]; // Declaratie en instantiatie van Bucket[]

            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new ArrayList<>(); // Bucket wordt gevuld met subarrays
            }

            // Sorteren begint
            boolean maxLength = false;
            int tmp;
            int placement = 1;

            while (!maxLength) {
                maxLength = true;
                // Split input tussen lijsten
                for (Double i : data) {
                    tmp = (int) (i / placement);
                    bucket[tmp % RADIX].add(i);
                    if (maxLength && tmp > 0) {
                        maxLength = false;
                    }
                }

                int a = 0;
                for (int b = 0; b < RADIX; b++) {
                    for (Object i : bucket[b]) {
                        data.set(a++, (Double) i);
                    }
                    bucket[b].clear();
                }
                placement *= RADIX;
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                this.errorMessage = "Dataset contains null values. Cannot sort null values.";
                System.out.println(this.errorMessage);
            } else if (e instanceof ClassCastException) {
                this.errorMessage = "Contains elements which are not of equal type";
                System.out.println(this.errorMessage);
            }
        }
    }
}
