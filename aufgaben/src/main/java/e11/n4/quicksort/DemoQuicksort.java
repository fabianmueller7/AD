/*
 * Copyright 2025 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package e11.n4.quicksort;

import e11.array.init.RandomInitTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LoggerFactory.getLogger(DemoQuicksort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 300_000_000;
        final int[] arrayOriginal = new int[size];
        try (final ForkJoinPool pool = new ForkJoinPool()) {

            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100_000_000);
            pool.invoke(initTask);
            int[] arrayTask = Arrays.copyOf(arrayOriginal, size);
            final QuicksortTask sortTask = new QuicksortTask(arrayTask);
            long taskStart = System.currentTimeMillis();
            pool.invoke(sortTask);
            long taskEnd = System.currentTimeMillis();
            LOG.info("Parallel Quicksort.  : {} ms. ; Sorted: {} ", taskEnd - taskStart, QuicksortRecursive.isSorted(arrayTask));

            int[] arrayRec = Arrays.copyOf(arrayOriginal, size);
            long recStart = System.currentTimeMillis();
            QuicksortRecursive.quicksort(arrayRec);
            long recEnd = System.currentTimeMillis();
            LOG.info("QuicksortRec.  : {} ms. ; Sorted: {} ", recEnd - recStart, QuicksortRecursive.isSorted(arrayRec));
            int[] arraySort = Arrays.copyOf(arrayOriginal, size);


            long arraySortStart = System.currentTimeMillis();
            Arrays.sort(arraySort);
            long arraySortEnd = System.currentTimeMillis();
            LOG.info("Arrays.sort    : {} ms.", arraySortEnd - arraySortStart);
        } finally {
            // Executor shutdown
        }
    }
}
