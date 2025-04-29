package e9.heap;

import java.util.NoSuchElementException;

public class FixedSizeHeap implements IntegerHeap {

    private int[] heap;

    public FixedSizeHeap(int size) {
        this.heap = new int[size];
        for (int i = 0; i < size; i++) {
            heap[i] = Integer.MIN_VALUE;
        }
    }

    @Override
    public void insert(int value) {
        int position = 0;
        for(int i = 0; i < heap.length; i++) {
            if (heap[i] == Integer.MIN_VALUE) {
                heap[i] = value;
                position = i;
                break;
            }
        }

        int parentPos = (position - 1) / 2;

        while (parentPos >= 0 && heap[parentPos] < value) { //Do as long as a parent exists
            this.swap(position, parentPos);
            position = parentPos;
            parentPos = (position - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public int extract() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int root = heap[0];
        int lastIndex = size() - 1;
        heap[0] = heap[lastIndex];
        heap[lastIndex] = Integer.MIN_VALUE;

        int position = 0;
        while (true) {
            int left = position * 2 + 1;
            int right = position * 2 + 2;
            int largest = position;

            // Check left child
            if (left < heap.length && heap[left] != Integer.MIN_VALUE && heap[left] > heap[largest]) {
                largest = left;
            }

            // Check right child
            if (right < heap.length && heap[right] != Integer.MIN_VALUE && heap[right] > heap[largest]) {
                largest = right;
            }

            // If no swap needed, heap property is restored
            if (largest == position) {
                break;
            }

            swap(position, largest);
            position = largest;
        }

        return root;
    }

    @Override
    public int size() {
        int count = 0;
        for(int i = 0; i < heap.length; i++) {
            if(heap[i] != Integer.MIN_VALUE) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        if(this.heap.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(int value) {
        for(int i = heap.length - 1; i >= 0; i--) {
            if(heap[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[] toArray() {
        return this.heap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int levels = (int) (Math.log(size) / Math.log(2)) + 1;

        int index = 0;
        for (int level = 0; level < levels; level++) {
            int elementsInLevel = (int) Math.pow(2, level);
            int padding = (int) Math.pow(2, levels - level) - 1;

            sb.append(" ".repeat(padding * 2)); // spacing before line

            for (int i = 0; i < elementsInLevel && index < heap.length && heap[index] != Integer.MIN_VALUE; i++) {
                sb.append(String.format("%2d", heap[index++]));
                sb.append(" ".repeat(padding * 4));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
