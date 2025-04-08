package e8.insertionSort;

import e7.bank.DemoBankAccount;
import e8.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InsertionSort {

    private static final Logger LOG = LoggerFactory.getLogger(InsertionSort.class);

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in zufälliger Reihenfolge.
     * 
     * @param size die Anzahl der Zahlen
     * 
     */
    static int[] getShuffledNumbers(int size) {
        List<Integer> numbers = IntStream.range(1, size + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in aufsteigender Reihenfolge.
     * 
     * @param size die Anzahl der Zahlen
     */
    static int[] getAscendingNumbers(int size) {
        return IntStream.range(1, size + 1).toArray();
    }

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in absteigender Reihenfolge.
     * 
     * @param size die Anzahl der Zahlen
     */
    static int[] getDescendingNumbers(int size) {
        return IntStream.range(1, size + 1).map(i -> size - i + 1).toArray();
    }

    /**
     * Sortiert mit GUI-Darstellung ein Array mit den Zahlen mit insetionSort
     *
     * @param numbers Array mit Zahlen
     * @return int Number of comparisons
     */
    static int insertionSortWithGraphic(int[] numbers) {
        int counter = 0;
        int element;
        int j;
        for (int i = 1; i < numbers.length; i++) {
            element = numbers[i];
            j = i;
            while((j > 0) && (numbers[j-1] > element)) {
                numbers[j] = numbers[j-1];
                j--;
                counter++;
                SortingAnimation.instance().showArray(numbers, 10,j);
            }
            numbers[j] = element;
        }
        return counter;
    }

    /**
     * Sortiert ohne GUI-Darstellung ein Array mit den Zahlen mit insetionSort
     *
     * @param numbers Array mit Zahlen
     * @return int[] sorted Array
     */
    static int[] insertionSortWithoutGraphic(int[] numbers) {
        int element;
        int j;
        for (int i = 1; i < numbers.length; i++) {
            element = numbers[i];
            j = i;
            while((j > 0) && (numbers[j-1] > element)) {
                numbers[j] = numbers[j-1];
                j--;
            }
            numbers[j] = element;
        }
        return numbers;
    }

    static boolean isSorted(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i-1] > numbers[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Beispiel: Zahlen von 1 bis 50 in zufälliger Reihenfolge
        int[] numbers1 = getShuffledNumbers(50);
        int comparisons = insertionSortWithGraphic(numbers1);

        int[] numbers2 = getShuffledNumbers(100);
        final long start = System.nanoTime();
        int[] sorted = insertionSortWithoutGraphic(numbers2);
        final long end = System.nanoTime();

        LOG.info("Array: " + Arrays.toString(sorted));
        LOG.info("Sorted: " + isSorted(sorted));
        LOG.info("Comparisons: " + comparisons);
        LOG.info("TimeToSort: " + (end - start)/1000000f + "ms");
    }
}
