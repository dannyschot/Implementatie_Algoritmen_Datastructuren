package datastructureTests;

import datastructures.AVLTree;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class AVLSearchTreeTest {
    JSONHandler jsonHandler;
    JSONObject jsonObject;
    Dataset dataset;
    AVLTree<Integer> avlTree;

    @Before
    public void setup() throws IOException, ParseException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        jsonHandler = new JSONHandler();
        dataset = new Dataset();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        avlTree = new AVLTree<>();
    }

    @Test
    public void shouldInsertDataSetDoubleIntoAVLTree(){
        AVLTree<Double> avlSearchTreeDouble = new AVLTree<>();
        ArrayList<Double> listWithFloat = dataset.getFloat8001();
        int sizeOfJsonArray = listWithFloat.size();
        Instant startTime;
        long delta;

        startTime = Instant.now();
        for (Double element : listWithFloat) {
            avlSearchTreeDouble.insert(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Double into AVL Tree: " + delta + "ms");
        int sizeOfAVLTree = avlSearchTreeDouble.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetLongIntoAVLTree() {
        AVLTree<Long> avlSearchTreeLong = new AVLTree<>();
        ArrayList<Long> listWithFloat = dataset.getLijstHerhaald1000();
        int sizeOfJsonArray = listWithFloat.size();
        Instant startTime;
        long delta;

        startTime = Instant.now();
        for (Long element : listWithFloat) {
            avlSearchTreeLong.insert(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Long into AVL Tree: " + delta + "ms");
        int sizeOfAVLTree = avlSearchTreeLong.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetStringIntoAVLTree() {
        AVLTree<String> avlSearchTreeString = new AVLTree<>();
        ArrayList<String> listWithFloat = dataset.getLijstMetStrings();
        int sizeOfJsonArray = listWithFloat.size();
        Instant startTime;
        long delta;

        startTime = Instant.now();
        for (String element : listWithFloat) {
            avlSearchTreeString.insert(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting String into AVL Tree: " + delta + "ms");
        int sizeOfAVLTree = avlSearchTreeString.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldDeleteNode(){
        avlTree.insert(10);
        avlTree.insert(100);
        avlTree.insert(300);
        avlTree.deleteNode(300);

        int expected = 2;
        int actual = avlTree.nNodes;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCorrectNodeValue() {
        avlTree.insert(10);
        avlTree.insert(100);
        avlTree.insert(300);
        avlTree.deleteNode(300);

        boolean expected = true;
        boolean actual = avlTree.getNodeValue(100);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nodeValueShouldNotBeFoundAfterDeletion() {
        avlTree.insert(10);
        avlTree.insert(100);
        avlTree.insert(300);
        avlTree.deleteNode(300);

        boolean expected = false;
        boolean actual = avlTree.getNodeValue(300);

        Assert.assertEquals(expected, actual);
    }
}
