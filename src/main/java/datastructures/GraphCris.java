package datastructures;

public class GraphCris<T> {
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackCris<Integer> stack;

    public GraphCris(int size) {
        vertexList = new Vertex[size];
        adjMat = new int[size][size];
        nVerts = 0;
        stack = new StackCris<>(size);

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                adjMat[j][k] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].data);
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
}
