package datastructures;

public class DistanceParent {
    public long distance;
    public int parentVert;

    public DistanceParent(int parentVert, long distance) {
        this.parentVert = parentVert;
        this.distance = distance;
    }
}
