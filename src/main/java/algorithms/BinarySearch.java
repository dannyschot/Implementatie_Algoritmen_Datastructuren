package algorithms;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> {
    private List<T> data;


    public BinarySearch(List<T> data) {
        this.data = data;
    }

    public int find(T searchKey) {
        int lowerBound = 0;
        int upperBound = data.size() - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (data.get(curIn) == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return data.size();
            } else {
                if (data.get(curIn).compareTo(searchKey) < 0) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }
}
