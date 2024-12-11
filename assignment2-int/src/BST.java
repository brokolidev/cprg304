// Build a binary search tree class
// Liver, Onion, Pickle, Lettuce, Beet, Zucchini, Potato, Salt, Milk, Apple, Ham, Carrot, Jam

// Build a binary search tree class
public class BST {
    // Define the Node class
    class Node {
        // Define the attributes of the Node class
        String data;
        Node left;
        Node right;

        // Define the constructor of the Node class
        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Define the root of the binary search tree
    Node root;

    // Define the constructor of the BST class
    BST() {
        root = null;
    }

    // Define the insert method
    void insert(String data) {
        root = insertRec(root, data);
    }

    // Define the insertRec method
    Node insertRec(Node root, String data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Define the inorder method
    void inorder() {
        inorderRec(root);
    }

    // Define the inorderRec method
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Define the main method
    public static void main(String[] args) {
        // Create a new binary search tree
        BST bst = new BST();

        // Insert the data into the binary search tree
        bst.insert("Liver");
        bst.insert("Onion");
        bst.insert("Pickle");
        bst.insert("Lettuce");
        bst.insert("Beet");
        bst.insert("Zucchini");
        bst.insert("Potato");
        bst.insert("Salt");
        bst.insert("Milk");
        bst.insert("Apple");
        bst.insert("Ham");
        bst.insert("Carrot");
        bst.insert("Jam");

        // Print the inorder traversal of the binary search tree
        bst.inorder();
    }
}
