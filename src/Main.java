public class Main {

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();


        bst.put(3, "Value 3"); // Insert key-value pair (3, "Value 3")
        bst.put(7, "Value 7"); // Insert key-value pair (7, "Value 7")
        bst.put(2, "Value 2"); // Insert key-value pair (2, "Value 2")
        bst.put(9, "Value 9"); // Insert key-value pair (9, "Value 9")
        bst.put(4, "Value 4"); // Insert key-value pair (4, "Value 4")
        bst.put(8, "Value 8"); // Insert key-value pair (8, "Value 8")
        bst.put(1, "Value 1"); // Insert key-value pair (1, "Value 1")

        System.out.println("Value of key 3: " + bst.get(3)); // Retrieve value for key 3 and print

        bst.delete(7); // Delete key 5 from the tree


        System.out.println("Size of BST: " + bst.size()); // Print the size of the tree

        System.out.println("Keys in ascending order:"); // Print the keys in ascending order
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }
        System.out.println();

        // Testing for defence !
        System.out.println("Height of BST: " + bst.getHeight());
    }
}
