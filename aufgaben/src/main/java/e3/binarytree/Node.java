package e3.binarytree;

public class Node {

    private Data data;
    private Node left;
    private Node right;

    public Node() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public Node(Data data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Data getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        this.right = node;
    }
    public void setLeft(Node node) {
        this.left = node;
    }

    public boolean isbigger(Node node) {
        return this.getData().getValue() > node.getData().getValue();
    }

    public void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeft());
        System.out.print(node.getData().getValue() + " ");
        printInOrder(node.getRight());
    }

    public void printTree(Node node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }

        printTree(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.getData().getValue());
        printTree(node.getLeft(), prefix + (isLeft ? "    " : "│   "), true);
    }

    public Node searchByKey(Node node,final int key) {
        if(node == null) {
            return null;
        }
        if(node.getData().getValue() == key) {
            return node;
        }
        Node left = searchByKey(node.getLeft(), key);
        Node right = searchByKey(node.getRight(), key);
        if(left != null) {
            return left;
        } else return right;
    }
}
