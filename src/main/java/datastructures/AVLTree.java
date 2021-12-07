package datastructures;

public class AVLTree<T extends Comparable<T>> {
    Node<T> root = null;
    public int nNodes = 0;

    int height(Node<T> N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

    public Node<T> newNode(T key) {
        Node<T> node = new Node<>(key);
        node.left = null;
        node.right = null;
        node.height = 1;
        node.count = 1;
        return (node);
    }

    private Node<T> rightRotate(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node<T> leftRotate(Node<T> x) {
       Node<T> y = x.right;
       Node<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private int getBalance(Node<T> N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public void insert(T key) {
        nNodes++;
        root = insert(root, key);
    }
    private Node<T> insert(Node<T> node, T key) {
        if (node == null)
            return (newNode(key));

        if (key.compareTo(node.data) == 0) {
            (node.count)++;
            return node;
        }
        if (key.compareTo(node.data) < 0)
            node.left = insert(node.left, key);
        else
            node.right = insert(node.right, key);
        node.height = max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1 && key.compareTo(node.left.data) < 0)
            return rightRotate(node);

        if (balance < -1 && key.compareTo(node.right.data) > 0)
            return leftRotate(node);

        if (balance > 1 && key.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node<T> minValueNode(Node<T> node) {
        Node<T> current = node;
        while (current.left != null)
            current = current.left;

        return current;
    }

    public void deleteNode(T key) {
        root = deleteNode(root, key);
        nNodes--;
    }

    private Node<T> deleteNode(Node<T> root, T key) {
        if (root == null)
            return root;
        if (key.compareTo(root.data) < 0)
            root.left = deleteNode(root.left, key);
        else if (key.compareTo(root.data) > 0)
            root.right = deleteNode(root.right, key);
        else {
            if (root.count > 1) {
                (root.count)--;
                return null;
            }
            if ((root.left == null) || (root.right == null)) {
                Node<T> temp = root.left != null ? root.left : root.right;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node<T> temp = minValueNode(root.right);

                root.data = temp.data;
                root.count = temp.count;
                temp.count = 1;
                root.right = deleteNode(root.right, temp.data);
            }
        }

        if (root == null)
            return root;
        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public boolean getNodeValue(T key) {
        boolean existsInTree = false;

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
}
