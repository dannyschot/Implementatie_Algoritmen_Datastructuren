package datastructureTests;

import datastructures.AVLTree;
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

public class AVLSearchTreeTest {
    JSONObject jsonObject;
    JSONParser parser;
    AVLTree<Integer> avlTree;

    @Before
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        avlTree = new AVLTree<>();
    }

    @Test
    public void shouldInsertDataSetDoubleIntoAVLTree(){
        AVLTree<Double> avlSearchTreeDouble = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_float_8001");
        int sizeOfJsonArray = listWithFloat.size();

        for (Object element : listWithFloat) {
            avlSearchTreeDouble.insert((Double) element);
        }
        int sizeOfAVLTree = avlSearchTreeDouble.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetLongIntoAVLTree() {
        AVLTree<Long> avlSearchTreeLong = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_herhaald_1000");

        int sizeOfJsonArray = listWithFloat.size();
        Instant startTime;
        long delta;

        startTime = Instant.now();
        for (Object element : listWithFloat) {
            avlSearchTreeLong.insert((Long) element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Long into AVL Tree: " + delta + "ms");
        int sizeOfAVLTree = avlSearchTreeLong.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetStringIntoAVLTree() {
        AVLTree<String> avlSearchTreeString = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_met_strings");

        int sizeOfJsonArray = listWithFloat.size();
        Instant startTime;
        long delta;

        startTime = Instant.now();
        for (Object element : listWithFloat) {
            avlSearchTreeString.insert((String) element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting String into AVL Tree: " + delta + "ms");
        int sizeOfAVLTree = avlSearchTreeString.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertLijstWillekeurig4() {
        AVLTree<Double> avlSearchTree = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_willekeurig_4");

        int sizeOfJsonArray = listWithFloat.size();
        for (Object element : listWithFloat) {
            avlSearchTree.insert((Double) element);
        }

        int sizeOfAVLTree = avlSearchTree.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertEigenLijst() {
        AVLTree<Long> avlSearchTree = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("eigen_lijst");

        for (Object element : listWithFloat) {
            avlSearchTree.insert((Long) element);
        }

        String expected = "Null data cannot be compared against non-null elements";
        String actual = avlSearchTree.getErrorMessage();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertDataSetLijstAflopend2() {
        AVLTree<Long> avlSearchTreeLong = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_aflopend_2");

        int sizeOfJsonArray = listWithFloat.size();
        for (Object element : listWithFloat) {
            avlSearchTreeLong.insert((Long) element);
        }
        int sizeOfAVLTree = avlSearchTreeLong.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetLijstOplopend2() {
        AVLTree<Long> avlSearchTreeLong = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_oplopend_2");

        int sizeOfJsonArray = listWithFloat.size();
        for (Object element : listWithFloat) {
            avlSearchTreeLong.insert((Long) element);
        }
        int sizeOfAVLTree = avlSearchTreeLong.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetLijstGesorteerdAflopend3() {
        AVLTree<Long> avlSearchTreeLong = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");

        int sizeOfJsonArray = listWithFloat.size();
        for (Object element : listWithFloat) {
            avlSearchTreeLong.insert((Long) element);
        }
        int sizeOfAVLTree = avlSearchTreeLong.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetLijstGesorteerdOplopend3() {
        AVLTree<Long> avlSearchTreeLong = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");

        int sizeOfJsonArray = listWithFloat.size();
        for (Object element : listWithFloat) {
            avlSearchTreeLong.insert((Long) element);
        }
        int sizeOfAVLTree = avlSearchTreeLong.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetLijstLeeg0() {
        AVLTree<Long> avlSearchTreeLong = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_leeg_0");

        int sizeOfJsonArray = listWithFloat.size();
        for (Object element : listWithFloat) {
            avlSearchTreeLong.insert((Long) element);
        }
        int sizeOfAVLTree = avlSearchTreeLong.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetLijstNull1() {
        AVLTree<Long> avlSearchTreeLong = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_null_1");

        int sizeOfJsonArray = listWithFloat.size();
        for (Object element : listWithFloat) {
            avlSearchTreeLong.insert((Long) element);
        }
        int sizeOfAVLTree = avlSearchTreeLong.nNodes;

        Assert.assertEquals(sizeOfJsonArray, sizeOfAVLTree);
    }

    @Test
    public void shouldInsertDataSetLijstNull3() {
        AVLTree<Long> avlSearchTree = new AVLTree<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_null_3");

        for (Object element : listWithFloat) {
            avlSearchTree.insert((Long) element);
        }
        String expected = "Null data cannot be compared against non-null elements";
        String actual = avlSearchTree.getErrorMessage();

        Assert.assertEquals(expected, actual);
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

        Assert.assertEquals(false, actual);
    }

    @Test
    public void shouldRotateLeft() {

    }

    @Test
    public void shouldRotateRight() {

    }
}
