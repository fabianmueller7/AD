package e9.quicksort;

import e8.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quicksort {

    private static final Logger LOG = LoggerFactory.getLogger(Quicksort.class);

    private static int SWAP_COUNTER;

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
    public static void quickSortWithGraphic(int[] numbers) {
        quickSortDisplayed(numbers, 0, numbers.length - 1);
    }

    private static void quickSortDisplayed(int[] numbers, int start, int end) {
        if (start < end) {
            int p = partitionDisplayed(numbers,start,end);
            quickSortDisplayed(numbers,start,p);
            quickSortDisplayed(numbers,p+1,end);
        }
    }

    private static int partitionDisplayed(int[] numbers, int start, int end) {
        final int pivot = numbers[start];
        int i = start-1;
        int j = end+1;

        while(true) {

            do { // Do-while um keine Endlosschleifen zu haben, falls Pivot maximum wäre
                j--;
            } while (numbers[j] > pivot);
            do {
                i++;
            }while (numbers[i] < pivot);

            if ( i >= j) {
                return j;
            }

            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            SortingAnimation.instance().showArray(numbers, 100, j,i);
        }
    }

    /**
     * Sortiert ohne GUI-Darstellung ein Array mit den Zahlen mit insetionSort
     *
     * @param numbers Array mit Zahlen
     * @return int[] sorted Array
     */
    static int[] quickSortWithoutGraphic(int[] numbers) {
        SWAP_COUNTER = 0;

        quickSortMesured(numbers,0,numbers.length-1);

        return numbers;
    }

    private static void quickSortMesured(int[] numbers, int start, int end) {
        if (start < end) {
            int p = partitionMesured(numbers,start,end);
            quickSortMesured(numbers,start,p);
            quickSortMesured(numbers,p+1,end);
        }
    }

    private static int partitionMesured(int[] numbers, int start, int end) {
        final int pivot = numbers[start];
        int i = start-1;
        int j = end+1;

        while(true) {

            do {
                j--;
            } while (numbers[j] > pivot);
            do {
                i++;
            }while (numbers[i] < pivot);

            if ( i >= j) {
                return j;
            }

            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            SWAP_COUNTER++;
        }
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
        // Display example of quicksort
        int[] numbers1 = getShuffledNumbers(50);
        quickSortWithGraphic(numbers1);


        //Test average time to sort 1'000'000 objects.
        long sumTime = 0;
        final int rotations = 10;
        final int numbersToSort = 1_000_000;
        for(int i = 0; i < rotations; i++) {
            int[] numbers = getShuffledNumbers(numbersToSort);
            final long start = System.nanoTime();
            quickSortWithoutGraphic(numbers);
            final long end = System.nanoTime();
            sumTime+= end - start;
        }

        LOG.info("Comparisons: " + SWAP_COUNTER);
        LOG.info("AVG TimeToSort " + numbersToSort + " numbers : " + (sumTime/rotations)/1000000f + "ms");


        //What happens if the array is already sorted.
        int[] numbers2 = getShuffledNumbers(10_000);
        int[] sorted = quickSortWithoutGraphic(numbers2);
        final long start = System.nanoTime();
        quickSortWithoutGraphic(sorted);
        final long end = System.nanoTime();
        LOG.info("Sorting an array with " + 10_000 + " numbers, which is already sorted : " + (end-start)/1000000f+ "ms");





    }
}
