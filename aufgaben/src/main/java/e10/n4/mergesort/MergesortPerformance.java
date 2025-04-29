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
package e10.n4.mergesort;

import e10.array.init.RandomInitTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * Performance Vergleich der Mergesort Implementationen.
 */
public final class MergesortPerformance {

    private static final Logger LOG = LoggerFactory.getLogger(MergesortPerformance.class);

    /**
     * Privater Konstruktor.
     */
    private MergesortPerformance() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {

        try (final ForkJoinPool pool = new ForkJoinPool()) {
            for (int size  = 3; size <= 300_000_000; size = size*100) {

                LOG.info("   --------------- Number of elements: {} ---------------", size);
            final int[] arrayOriginal = new int[size];

            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
            pool.invoke(initTask);
            int[] array = Arrays.copyOf(arrayOriginal, size);
            final MergesortTask sortTask = new MergesortTask(array);
            long startConc = System.currentTimeMillis();
            pool.invoke(sortTask);
            long endConc = System.currentTimeMillis();
            LOG.info("Conc. Mergesort : {} msec.", endConc - startConc);

            //Messung Mergesort sequenziell
            array = Arrays.copyOf(arrayOriginal, size);
            long startRec = System.currentTimeMillis();
            MergesortRecursive.mergeSort(array);
            long endRec = System.currentTimeMillis();
            LOG.info("Seqzuenziell.   : {} msec.", endRec - startRec);

            //Messung parallele Verarbeitung
            array = Arrays.copyOf(arrayOriginal, size); // erstelle Array
            long paraStartTime = System.currentTimeMillis();
            Arrays.parallelSort(array); // starte sortieren
            long paraEndTime = System.currentTimeMillis();
            LOG.info("ParallelSort    : {} msec.", paraEndTime - paraStartTime);
            }
        } finally {
            // Executor shutdown
        }
    }
}
