package datastructures;

/**
 * De AVLTree datastructuur. Deze boomstructuur kan omgaan met duplicate Node values.
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> {
    Node<T> root = null;
    public int nNodes = 0;
    private String errorMessage;

    /**
     * Utility functie om de hoogte van de boom op te vragen
     * @param N De node waarvandaan de hoogte opgevraagd dient te worden
     * @return hoogte vanaf node (subtree)
     */
    int height(Node<T> N) {
        if (N == null)
            return 0;
        return N.height;
    }

    /**
     * Utility functie om de hoogste waarde tussen twee ints te bepalen
     * @param a eerste getal
     * @param b tweede getal
     * @return hoogste van de twee
     */
    int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Helper functie voor het alloceren van een nieuwe node met null linker- en rechternodes
     * @param key
     * @return
     */
    public Node<T> newNode(T key) {
        Node<T> node = new Node<>(key);
        node.left = null;
        node.right = null;
        node.height = 1;
        node.count = 1;
        return (node);
    }

    /**
     * Utility functie voor het rechts roteren van een subtree
     * @param subTreeRoot de root node van de te roteren subtree
     * @return De nieuwe root node
     */
    private Node<T> rightRotate(Node<T> subTreeRoot) {
        Node<T> leftChild = subTreeRoot.left; // Linkerkind van root wordt opgeslagen
        Node<T> rightChildOfLeftChild = leftChild.right; // Rechterkind van het linkerkind van de root wordt opgeslagen

        // Rotatie
        leftChild.right = subTreeRoot; // Het nieuwe rechterkind van het linkerkind wordt de huidige root van de subtree
        subTreeRoot.left = rightChildOfLeftChild; // Het nieuwe linkerkind van de root van de subtree is het rechterkind van het linkerkind van de root


        // Nieuwe hoogtes worden ingesteld
        subTreeRoot.height = max(height(subTreeRoot.left), height(subTreeRoot.right)) + 1; // De nieuwe hoogte van de root is de hoogste subtree + 1
        leftChild.height = max(height(leftChild.left), height(leftChild.right)) + 1; // De nieuwe hoogte van het linkerkind is de hoogste linkersubtree + 1

        return leftChild;
    }

    /**
     * Utility functie voor het links roteren van een subtree
     * @param subTreeRoot de root node van de te roteren subtree
     * @return De nieuwe root node
     */
    private Node<T> leftRotate(Node<T> subTreeRoot) {
       Node<T> rightChild = subTreeRoot.right; // Rechterkind van root wordt opgeslagen
       Node<T> leftChildOfRightChild = rightChild.left; // Linkerkind van het rechterkind van de root wordt opgeslagen

        // Rotatie
        rightChild.left = subTreeRoot; // Het nieuwe linkerkind van het rechterkind wordt de huidige root van de subtree
        subTreeRoot.right = leftChildOfRightChild; // Het nieuwe rechterkind van de root van de subtree is het linkerkind van het rechterkind van de root

        // Nieuwe hoogtes worden ingesteld
        subTreeRoot.height = max(height(subTreeRoot.left), height(subTreeRoot.right)) + 1; // De nieuwe hoogte van de root is de hoogste subtree + 1
        rightChild.height = max(height(rightChild.left), height(rightChild.right)) + 1; // De nieuwe hoogte van het linkerkind is de hoogste linkersubtree + 1

        return rightChild;
    }

    /**
     * Geeft de balance factor (BF) van de gegeven node terug
     * @param N Node waarvan de BF opgevraagd wordt
     * @return BF
     */
    private int getBalance(Node<T> N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    /**
     * Insertie van node in de AVL tree
     * @param key data element welke opgeslagen wordt in de node
     */
    public void insert(T key) {
        root = insert(root, key);
        nNodes++; // Aantal nodes wordt opgehoogd
    }

    private Node<T> insert(Node<T> node, T key) {
        // Normale binaire zoekboom insertie vangt aan
        if (node == null)
            return (newNode(key)); // Basisgeval van recursie

        try {
            if (key.compareTo(node.data) == 0) { // Als de waarde van de nodes hetzelfde zijn. Verhoog count en return
                (node.count)++;
                return node;
            }

        if (key.compareTo(node.data) < 0) // Als de waarde kleiner is, traverseer recursief de boom
            node.left = insert(node.left, key); // Gaat door tot basisgeval is bereikt, slaat dan vervolgens de node op als linkerkind
        else
            node.right = insert(node.right, key); // Als waarde groter is
        node.height = max(height(node.left), height(node.right)) + 1; // Zet de nieuwe hoogte van de subtree

        int balance = getBalance(node); // De BF wordt nu opgehaald van de ingevoerde node

        // Aanvang checks op rotatie. Als de boom niet gebalanceerd is, kunnen de volgende vier gevallen opgetreden zijn

        // Links links (rechts roteren)
        if (balance > 1 && key.compareTo(node.left.data) < 0)
            return rightRotate(node);

        // Rechts rechts (links roteren)
        if (balance < -1 && key.compareTo(node.right.data) > 0)
            return leftRotate(node);

        // Links rechts (links-rechts roteren)
        if (balance > 1 && key.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Rechts links (rechts-links roteren)
        if (balance < -1 && key.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        } catch(Exception e) {
            this.errorMessage = "Null data cannot be compared against non-null elements";
        }
        return node;
    }

    /**
     * Gegeven een niet-lege binaire zoekboom, geeft deze functie de kleinste waarde in de boom terug
     * @param node Node met waarde erin opgeslagen
     * @return Kleinste waarde
     */
    private Node<T> minValueNode(Node<T> node) {
        Node<T> current = node;
        while (current.left != null)
            current = current.left;

        return current;
    }

    /**
     * Verwijderen van een node uit de boom
     * @param key Te verwijderen node
     */
    public void deleteNode(T key) {
        root = deleteNode(root, key);
        nNodes--;
    }

    /**
     * Logica voor het verwijderen van een node
     * @param root root dient mee te worden gegeven om de subtree te bepalen
     * @param data Gegeven node die dient te worden verwijderd
     * @return Verwijderde node
     */
    private Node<T> deleteNode(Node<T> root, T data) {

        // Standaard deletie in binaire zoekboom
        if (root == null) // Basisgeval recursie
            return null;

        // Als de waarde van de node die verwijdert dient te worden, kleiner is dan de waarde van de root node
        // Dan bevindt deze zich in de linker subtree
        if (data.compareTo(root.data) < 0)
            root.left = deleteNode(root.left, data); // Recursief door linker subtree tot het basisgeval is bereikt
        else if (data.compareTo(root.data) > 0)
            root.right = deleteNode(root.right, data); // Recursief door rechter subtree tot het basisgeval is bereikt
        else { // Als de waarde hetzelfde is als die van de root node, dan is dit de node die verwijdert dient te worden
            if (root.count > 1) { // Als de waarde vaker dan een keer voorkomt wordt de count verlaagd met 1 en de functie returns
                (root.count)--;
                return null;
            } // Als dit niet het geval is, wordt een node daadwerkelijk verwijdert
            if ((root.left == null) || (root.right == null)) { // Node met 1 enkel of geen kind
                Node<T> temp = root.left != null ? root.left : root.right; // Een tijdelijke node wordt opgeslagen. Indien linkerkind niet null is, dan is het het linkerkind, anders het rechterkind
                if (temp == null) { // Indien geen kinderen
                    root = null;
                } else
                    root = temp; // Bij 1 kind
            } else {
                Node<T> temp = minValueNode(root.right); // Twee kinderen: neem dan de inorder successor (kleinste in de rechter subtree)

                // Kopieer de data van de kleinste node en update de count
                root.data = temp.data;
                root.count = temp.count;
                temp.count = 1;
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // Voorkomen nullPointerException
        if (root == null) {
            return null;
        }

        // Updaten van de hoogte van de huidige node (subtree)
        root.height = max(height(root.left), height(root.right)) + 1;

        // Controleren of de huidige balans incorrect is
        // Balans opvragen van node
        int balance = getBalance(root);

        // Als de boom niet gebalanceerd is, kunnen de volgende vier gevallen opgetreden zijn

        // Links links (rechts roteren)
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Links rechts (links-rechts roteren)
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Rechts rechts (links roteren)
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Rechts links (rechts-links roteren)
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    /**
     * geeft terug of de waarde in de boom zit
     * @param key waarde
     * @return true wanneer waarde bestaat
     */
    public boolean getNodeValue(T key) {
        boolean existsInTree;

        Node<T> current = root;
        while (current != null) {
            if (current.data == key) {
                break;
            }
            current = current.data.compareTo(key) < 0 ? current.right : current.left;
        }

        existsInTree = current != null;
        return existsInTree;
    }

    public void preOrder(Node<T> root) {
        if (root != null) {
            System.out.println(root.data + " " + root.count);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private Node<T> getRoot() {
        return root;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
