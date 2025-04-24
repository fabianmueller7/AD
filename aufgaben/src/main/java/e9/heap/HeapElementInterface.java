package e9.heap;

/**
 * Represents a node (element) in a heap data structure.
 * <p>
 * This interface defines the structure of a heap element, including its value
 * and relationships to its parent and children.
 * It can be used for tree-based heaps such as binary heaps.
 */
public interface HeapElement {

    /**
     * Returns the integer value stored in this heap element.
     *
     * @return the value of this element
     */
    int getValue();

    /**
     * Returns the parent of this heap element.
     *
     * @return the parent element, or {@code null} if this is the root
     */
    HeapElement getParent();

    /**
     * Returns the left child of this heap element.
     *
     * @return the left child, or {@code null} if no left child exists
     */
    HeapElement getLeftChild();

    /**
     * Returns the right child of this heap element.
     *
     * @return the right child, or {@code null} if no right child exists
     */
    HeapElement getRightChild();

    /**
     * Returns data of the element as string.
     *
     * @return String of the elment.
     */
    String toString();


    boolean isLeaf();

    boolean isHeap();

    boolean equals(Object o);

    /**
     * Returns data of the element as string.
     *
     * @return String of the elment.
     */
    String toString();
}
