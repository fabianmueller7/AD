package e9.heap;

public class MyApp {

    public static void main(String[] args) {
        FixedSizeHeap heap = new FixedSizeHeap(10);
        heap.insert(10);
        heap.insert(30);
        heap.insert(6);
        heap.insert(3);
        heap.insert(15);
        heap.insert(20);
        heap.insert(5);

        System.out.println(heap.toString());
        System.out.println("size: " + heap.size());
        System.out.println();

        for(int i = 0; i < heap.size(); i++) {
            System.out.println(heap.extract());
        }

    }
}
