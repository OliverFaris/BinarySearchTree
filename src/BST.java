import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        boolean isFound = false;
        if(!searchHelper(root, val))
            return false;
        return true;
    }
    public boolean searchHelper(BSTNode node, int val) {
        if (node == null)
            return false;
        else if (node.getVal() == val) {
            return true;
        }
        else if (node != null && val < node.getVal())
            return searchHelper(node.getLeft(), val);
        return searchHelper(node.getRight(), val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        inorderHelper(arr, root);
        return arr;
    }

    public void inorderHelper(ArrayList<BSTNode> arr, BSTNode node) {
        if (node == null)
            return;
        inorderHelper(arr, node.getLeft());
        arr.add(node);
        inorderHelper(arr, node.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        preorderHelper(arr, root);
        return arr;
    }
    public void preorderHelper(ArrayList<BSTNode> arr, BSTNode node) {
        if (node == null)
            return;
        arr.add(node);
        preorderHelper(arr, node.getLeft());
        preorderHelper(arr, node.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        postorderHelper(arr, root);
        return arr;
    }
    public void postorderHelper(ArrayList<BSTNode> arr, BSTNode node) {
        if (node == null)
            return;
        postorderHelper(arr, node.getLeft());
        postorderHelper(arr, node.getRight());
        arr.add(node);
    }


    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insertHelper(val, root);
    }
    public void insertHelper(int val, BSTNode node) {
        if (node.getVal() == val) {
            return;
        }
        else if (val < node.getVal()) {
            if (node.getLeft() == null)
                node.setLeft(new BSTNode(val));
            else
                insertHelper(val, node.getLeft());
        }
        else if (val > node.getVal()) {
            if (node.getRight() == null)
                node.setRight(new BSTNode(val));
            else
                insertHelper(val, node.getRight());
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}