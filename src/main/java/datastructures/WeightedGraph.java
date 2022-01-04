package datastructures;

public class WeightedGraph<T> {
    private final int INFINITY = 1_000_000;
    private Vertex<T> vertexList[];
    private long adjMat[][];
    private int nVerts;
    private int nTree;
    private DistanceParent shortestPath[];
    private int currentVertex;
    private long startToCurrent;

    public WeightedGraph(int size) {
        vertexList = new Vertex[size];
        adjMat = new long[size][size];
        nVerts = 0;
        nTree = 0;
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                adjMat[j][k] = INFINITY;
            }
        }
        shortestPath = new DistanceParent[size];
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(long start, long end, long weight) {
        adjMat[(int) start][(int) end] = weight;
    }

    public void dijkstrasShortestPath() {
        int startTree = 0;
        vertexList[startTree].isInTree = true;
        nTree = 1;

        for (int j = 0; j < nVerts; j++) {
            long tempDistance = adjMat[startTree][j];
            shortestPath[j] = new DistanceParent(startTree, tempDistance);
        }

        while (nTree < nVerts) {
            int indexMin = getMin();
            long minDistance = shortestPath[indexMin].distance;

            if (minDistance == INFINITY) {
                System.out.println("there are unreachable vertices");
                break;
            } else {
                currentVertex = indexMin;
                startToCurrent = shortestPath[indexMin].distance;
            }
            vertexList[currentVertex].isInTree = true;
            nTree++;
            adjust_shortestPath();
        }

        displayPaths();

        nTree = 0;
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].isInTree = false;
        }
    }

    private int getMin() {
        long minDistance = INFINITY;
        int indexMin = 0;
        for (int j = 1; j < nVerts; j++) {
            if (!vertexList[j].isInTree && shortestPath[j].distance < minDistance) {
                minDistance = shortestPath[j].distance;
                indexMin = j;
            }
        }
        return indexMin;
    }

    private void adjust_shortestPath() {
        int column = 1;
        while (column < nVerts) {
            if (vertexList[column].isInTree) {
                column++;
                continue;
            }
            long currentToFringe = adjMat[currentVertex][column];
            long startToFringe = startToCurrent + currentToFringe;
            long shortestPathDistance = shortestPath[column].distance;

            if (startToFringe < shortestPathDistance) {
                shortestPath[column].parentVert = currentVertex;
                shortestPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    /**
     * Voobeeld van output is: B = 99 (A), C = 50 (A)/.
     * Dit betekent dat het kortste pad naar B, via A is, tegen een prijs van 99.
     * Kortste pad naar C, via A, tegen een prijs van 50.
     */
    private void displayPaths() {
        for (int j = 0; j < nVerts; j++) {
            System.out.println(vertexList[j].label + "=");
            if (shortestPath[j].distance == INFINITY) {
                System.out.println("infinity");
            } else {
                System.out.println(shortestPath[j].distance);
            }
            char parent = (char) vertexList[shortestPath[j].parentVert].label;
            System.out.println("(" + parent + ") ");
        }
        System.out.println("");
    }

}
