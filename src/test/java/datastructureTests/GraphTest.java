package datastructureTests;

import datastructures.GraphCris;
import datastructures.Vertex;
import datastructures.WeightedGraph;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class GraphTest {
    JSONObject jsonObject;
    JSONParser parser;
    Instant startTime;

    @Before
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/graph.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }


    @Test
    public void shouldInsertDataSetIntoUnweightedGraph() throws ParseException {
        JSONArray jsonArray = (JSONArray) jsonObject.get("lijnlijst");
        long[][] array = new long[jsonArray.size()][2];
        GraphCris<String> graph = new GraphCris<>(jsonArray.size());
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        for (int i=0; i < jsonArray.size(); i++) {
            JSONArray jsonArray2 = (JSONArray) jsonArray.get(i);
            array[i][0] = (long) jsonArray2.get(0);
            array[i][1] = (long) jsonArray2.get(1);
        }


        startTime = Instant.now();
        for (long[] intArray : array) {
            graph.addEdge(intArray[0], intArray[1]);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijnlijst insertion takes: " + duration + " ms");


        Vertex vertexList[] = new Vertex[jsonArray.size()];
        vertexList[0] = new Vertex('A');
        vertexList[1] = new Vertex('B');
        vertexList[2] = new Vertex('C');
        vertexList[3] = new Vertex('E');
        vertexList[4] = new Vertex('D');
        vertexList[5] = new Vertex('F');
        vertexList[6] = new Vertex('G');

        graph.depthFirstSearch();

        Assert.assertEquals(vertexList[0].label, graph.getBfsResults().get(0));
        Assert.assertEquals(vertexList[1].label, graph.getBfsResults().get(1));
        Assert.assertEquals(vertexList[2].label, graph.getBfsResults().get(2));
        Assert.assertEquals(vertexList[3].label, graph.getBfsResults().get(3));
        Assert.assertEquals(vertexList[4].label, graph.getBfsResults().get(4));
        Assert.assertEquals(vertexList[5].label, graph.getBfsResults().get(5));
        Assert.assertEquals(vertexList[6].label, graph.getBfsResults().get(6));
    }

    @Test
    public void shouldTraverseBFS() throws ParseException {
        GraphCris<String> graph = new GraphCris<>(5);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');


        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 4);
        graph.addEdge(4, 3);


        Vertex vertexList[] = new Vertex[5];
        vertexList[0] = new Vertex('A');
        vertexList[1] = new Vertex('B');
        vertexList[2] = new Vertex('C');
        vertexList[3] = new Vertex('E');
        vertexList[4] = new Vertex('D');

        graph.depthFirstSearch();

        Assert.assertEquals(vertexList[0].label, graph.getBfsResults().get(0));
        Assert.assertEquals(vertexList[1].label, graph.getBfsResults().get(1));
        Assert.assertEquals(vertexList[2].label, graph.getBfsResults().get(2));
        Assert.assertEquals(vertexList[3].label, graph.getBfsResults().get(3));
        Assert.assertEquals(vertexList[4].label, graph.getBfsResults().get(4));
    }

    @Test
    public void shouldInsertIntoWeightedGraph() throws ParseException {
        JSONArray jsonArray = (JSONArray) jsonObject.get("lijnlijst_gewogen");
        long[][] array = new long[jsonArray.size()][3];
        WeightedGraph<String> graph = new WeightedGraph<>(jsonArray.size());
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        for (int i=0; i < jsonArray.size(); i++) {
            JSONArray jsonArray2 = (JSONArray) jsonArray.get(i);
            array[i][0] = (long) jsonArray2.get(0);
            array[i][1] = (long) jsonArray2.get(1);
            array[i][2] = (long) jsonArray2.get(2);
        }

        startTime = Instant.now();
        for (long[] intArray : array) {
            graph.addEdge(intArray[0], intArray[1], (int) intArray[2]);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijnlijst_gewogen takes: " + duration + " ms");

        Vertex vertexList[] = new Vertex[jsonArray.size()];
        vertexList[0] = new Vertex('A');
        vertexList[1] = new Vertex('B');
        vertexList[2] = new Vertex('C');
        vertexList[3] = new Vertex('E');
        vertexList[4] = new Vertex('D');
        vertexList[5] = new Vertex('F');
        vertexList[6] = new Vertex('G');

    }
    @Test
    public void shouldInsertMatrixIntoUnweightedGraph() throws ParseException {
        JSONArray jsonArray = (JSONArray) jsonObject.get("verbindingsmatrix");
        long[][] array = new long[jsonArray.size()][7];
        GraphCris<String> graph = new GraphCris<>(jsonArray.size());
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        for (int i=0; i < jsonArray.size(); i++) {
            JSONArray jsonArray2 = (JSONArray) jsonArray.get(i);
            array[i][0] = (long) jsonArray2.get(0);
            array[i][1] = (long) jsonArray2.get(1);
            array[i][2] = (long) jsonArray2.get(2);
            array[i][3] = (long) jsonArray2.get(3);
            array[i][4] = (long) jsonArray2.get(4);
            array[i][5] = (long) jsonArray2.get(5);
            array[i][6] = (long) jsonArray2.get(6);
        }

        startTime = Instant.now();
        for (int j = 0; j < array.length; j++) {
            for(int i = 0; i < array[j].length; i++) {
                if (isEdge(array[j][i])) {
                    graph.addEdge(j, i);
                }
            }
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("verbindingsmatrix takes: " + duration + " ms");

    }

    @Test
    public void shouldInsertWeightedMatrixIntoUnweightedGraph() throws ParseException {
        JSONArray jsonArray = (JSONArray) jsonObject.get("verbindingsmatrix_gewogen");
        long[][] array = new long[jsonArray.size()][5];
        WeightedGraph<String> graph = new WeightedGraph<>(jsonArray.size());
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');


        for (int i=0; i < jsonArray.size(); i++) {
            JSONArray jsonArray2 = (JSONArray) jsonArray.get(i);
            array[i][0] = (long) jsonArray2.get(0);
            array[i][1] = (long) jsonArray2.get(1);
            array[i][2] = (long) jsonArray2.get(2);
            array[i][3] = (long) jsonArray2.get(3);
            array[i][4] = (long) jsonArray2.get(4);
        }

        startTime = Instant.now();
        for (int j = 0; j < array.length; j++) {
            for(int i = 0; i < array[j].length; i++) {
                if (isEdge(array[j][i])) {
                    graph.addEdge(j, i, (int) array[j][i]);
                }
            }
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("verbindingsmatrix_gewogen takes: " + duration + " ms");
    }

    @Test
    public void shouldInsertVerbindingsLijstIntoUnweightedGraph() throws ParseException {
        JSONArray jsonArray = (JSONArray) jsonObject.get("verbindingslijst");
        ArrayList<ArrayList<Long>> array = new ArrayList<>();
        GraphCris<Integer> graph = new GraphCris<>(jsonArray.size());
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        for (int i = 0; i < jsonArray.size(); i++) {
                array.add((ArrayList<Long>) jsonArray.get(i));
        }


        startTime = Instant.now();
        for (int j = 0; j < array.size(); j++) {
            for(int i = 0; i < array.get(j).size(); i++) {
                graph.addEdge(j, array.get(j).get(i));
            }
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("verbindingslijst takes: " + duration + " ms");

        graph.depthFirstSearch();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void shouldInsertVerbindingsLijstGewogenIntoUnweightedGraph() throws ParseException {
        JSONArray jsonArray = (JSONArray) jsonObject.get("verbindingslijst_gewogen");
        ArrayList<ArrayList<ArrayList<Long>>> array = new ArrayList<>();
        WeightedGraph<Long> graph = new WeightedGraph<>(jsonArray.size());
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        for (Object o : jsonArray) {
            array.add((ArrayList<ArrayList<Long>>) o);
        }

        startTime = Instant.now();
        for (int j = 0; j < array.size(); j++) {
            for (int i = 0; i < array.get(j).size(); i++) {
                graph.addEdge(j, array.get(j).get(i).get(0), array.get(j).get(i).get(1));
            }
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("verbindingslijst takes: " + duration + " ms");
    }

    private boolean isEdge(long bit) {
        return bit > 0;
    }
}
