package jmh;


import datastructures.GraphCris;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
//        org.openjdk.jmh.Main.main(args);

        GraphCris<String> stringGraph = new GraphCris<>(8);

        stringGraph.addVertex('A');
        stringGraph.addVertex('B');
        stringGraph.addVertex('C');
        stringGraph.addVertex('D');
        stringGraph.addVertex('E');


        stringGraph.addEdge(0, 1);
        stringGraph.addEdge(1, 2);
        stringGraph.addEdge(0, 4);
        stringGraph.addEdge(4, 3);

        System.out.println("DFS visits vertices: ");
        stringGraph.depthFirstSearch();
        System.out.println();

    }
}
