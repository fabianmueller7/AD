package e9.heap;

/**
 * Interface for a heap data structure that manages integers.
 * <p>
 * Implementations can be min-heaps, max-heaps, or other priority-based structures.
 * This interface defines basic heap operations as well as some extended utilities.
 */
public interface IntegerHeap {

    /**
     * Inserts a value into the heap while maintaining the heap property.
     *
     * @param value the integer value to be inserted
     */
    void insert(int value);

    /**
     * Extracts and removes the root element of the heap (max).
     *
     * @return the extracted element
     * @throws NoSuchElementException if the heap is empty
     */
    int extract();

    /**
     * Returns the number of elements currently in the heap.
     *
     * @return the size of the heap
     */
    int size();

    /**
     * Checks whether the heap is empty.
     *
     * @return {@code true} if the heap contains no elements, otherwise {@code false}
     */
    boolean isEmpty();

    /**
     * Checks whether the heap contains the specified value.
     *
     * @param value the value to search for
     * @return {@code true} if the value exists in the heap, otherwise {@code false}
     */
    boolean contains(int value);


    /**
     * Returns the contents of the heap as an array.
     * The order of elements is typically level-order (heap structure order).
     *
     * @return an array containing all elements of the heap
     */
    int[] toArray();

    /**
     * Returns a string representation of the heap.
     *
     * @return a string representation of the heap
     */
    @Override
    String toString();
}
