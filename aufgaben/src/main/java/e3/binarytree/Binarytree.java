package e3.binarytree;

import java.util.ArrayList;

public class Binarytree {

    private Node root;

    public Binarytree() {
        root = null;
    }

    public static void main(String[] args) {
        //Setup
        Binarytree bt = new Binarytree();
        int[] nodes = {7,5,8,2,6,1,12,11,14,15};

        for (int j : nodes) {
            Data data = new Data(j);
            Node node = new Node(data);
            bt.add(node);
        }

        bt.printInorder();
        bt.printTree();

        System.out.println("Result " + bt.search(14).getData().getValue());
    }

    public Node getRoot() {
        return root;
    }

    public void add(final Node node) {
        if (root == null) {
            root = node;
        }
        else {
            Node parent = root;
            Node current = root;

            while (current != null) {
                parent = current;
                if(current.isbigger(node)){
                    current = current.getRight();
                } else {
                    current = current.getLeft();
                }
            }

            if (parent.isbigger(node)) {
                parent.setRight(node);
            } else {
                parent.setLeft(node);
            }
        }
    }

    public void printTree() {
        System.out.println();
        root.printTree(root, "", false);
    }

    public void printInorder() {
        root.printInOrder(root);
    }

    public Node search(final int key) {
        return root.searchByKey(root, key);
    }
}
