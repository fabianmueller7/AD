package e8.selectionSort;

import e8.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectionSort {

    private static final Logger LOG = LoggerFactory.getLogger(SelectionSort.class);

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
    static int selectionSortWithGraphic(int[] numbers) {
        int counter = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < numbers.length; j++) {
                counter++;
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
                SortingAnimation.instance().showArray(numbers, 20, j);
            }

            // Tausche i mit minIndex, falls nötig
            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
        }

        return counter;
    }

    /**
     * Sortiert ohne GUI-Darstellung ein Array mit den Zahlen mit insetionSort
     *
     * @param numbers Array mit Zahlen
     * @return int[] sorted Array
     */
    static int[] selectionSortWithoutGraphic(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }

            // Tausche i mit minIndex, falls nötig
            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
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
        int comparisons = selectionSortWithGraphic(numbers1);

        int[] numbers2 = getShuffledNumbers(100);
        final long start = System.nanoTime();
        int[] sorted = selectionSortWithoutGraphic(numbers2);
        final long end = System.nanoTime();

        LOG.info("Array: " + Arrays.toString(sorted));
        LOG.info("Sorted: " + isSorted(sorted));
        LOG.info("Comparisons: " + comparisons);
        LOG.info("TimeToSort: " + (end - start)/1000000f + "ms");
    }
}
