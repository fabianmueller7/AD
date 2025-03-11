package e4.performanceComparison.stack;

/**
 * The {@code Stack} interface defines the fundamental operations of a stack data structure.
 * <p>
 * A stack operates on the Last-In-First-Out (LIFO) principle, meaning the most recently
 * added element is the first one to be removed. This interface provides methods
 * for adding (`push`), removing (`pop`), checking the number of elements (`size`),
 * and verifying whether the stack is empty (`isEmpty`).
 * </p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>
 * Stack stack = new ArrayStack(); // Assuming an implementation exists
 * stack.push("Item 1");
 * stack.push("Item 2");
 * System.out.println(stack.pop()); // Outputs: "Item 2"
 * </pre>
 *
 * @author Mueller Fabian
 * @version 1.0
 */
public interface StackInterface {

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param o the object to be added to the stack
     */
    public boolean push(String o);

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public Object pop();

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size();

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack contains no elements, {@code false} otherwise
     */
    public boolean isEmpty();
}

