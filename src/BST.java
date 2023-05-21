import java.util.List;
import java.util.ArrayList;         // importing main utils

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {    // Node class represents a node in BST
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V value) {     // Inserts a key-value pair into the binary search tree
        root = put(root, key, value);
    }

    public Node put(Node node, K key, V val) { // Recursive helper method to insert a key-value pair into the binary search tree
        if (node == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }
        return node;
    }

    public V get(K key) {           // Retrieves the value associated with a given key in the binary search tree
        Node node = get(root, key);
        return node != null ? node.val : null;
    }

    private Node get(Node node, K key) {     // Recursive helper method to search for a key in the binary search tree
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    public void delete(K key) {     // Deletes a key-value pair from the binary search tree
        root = delete(root, key);
    }

    public Node delete(Node node, K key) {        // Recursive helper method to delete a key-value pair from the binary search tree
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node minRightNode = findMin(node.right);
                node.key = minRightNode.key;
                node.val = minRightNode.val;
                node.right = delete(node.right, minRightNode.key);
            }
        }
        return node;
    }

    public Node findMin(Node node) {     // Finds the minimum key in the binary search tree rooted at the given node
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Iterable<K> iterator() {     // Returns an iterator for the binary search tree that iterates through the keys in ascending order
        List<K> keys = new ArrayList<>();
        inorderTraversal(root, keys);
        return keys;
    }


    // Performs an inorder traversal of the binary search tree and adds the keys to the list
    private void inorderTraversal(Node node, List<K> keys) {
        if (node == null)
            return;
        inorderTraversal(node.left, keys);
        keys.add(node.key);
        inorderTraversal(node.right, keys);
    }

    public int size() {      // Returns the size (number of nodes) of the binary search tree
        return size(root);
    }

    private int size(Node node) {    // Recursive helper method to calculate the size of the binary search tree
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }
}