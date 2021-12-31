package datastructures;

public class GraphCris<T> {
    private Vertex vertexList[];
    private long adjMat[][];
    private int nVerts;
    private StackCris<Integer> stack;
    DynamicArray<Object> bfsResult;

    public GraphCris(int size) {
        vertexList = new Vertex[size];
        adjMat = new long[size][size];
        nVerts = 0;
        stack = new StackCris<>(size);
        bfsResult = new DynamicArray<>();

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                adjMat[j][k] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(long start, long end) {
        adjMat[(int) start][(int) end] = 1;
        adjMat[(int) end][(int) start] = 1;
    }

    public void displayVertex(int v) {
        bfsResult.add(vertexList[v].label);
        System.out.println(vertexList[v].label);
    }

    public void depthFirstSearch() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);

        while( !stack.isEmpty()) {
            int vertex = getAdjUnvisitedVertex( stack.peek());
            if (vertex == -1) {
                stack.pop();
            } else {
                vertexList[vertex].wasVisited = true;
                displayVertex(vertex);
                stack.push(vertex);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = true;
        }
    }

    private int getAdjUnvisitedVertex(Integer vertex) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[vertex][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }

    public DynamicArray<Object> getBfsResults() {
        return bfsResult;
    }

    public int getBfsResultsSize() {
        return bfsResult.size();
    }

}
