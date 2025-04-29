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
package e10.array;

import e10.array.init.RandomInitTask;
import e10.array.sort.SortTask;
import e10.array.sort.check.SortCheckTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * Codebeispiel für die Verwendung von verschiedenen Recursive-Klassen mit einem
 * Fork-Join-Pool.
 */
public final class DemoArraySort {

    private static final Logger LOG = LoggerFactory.getLogger(DemoArraySort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoArraySort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 42;
        final int[] array = new int[size];
        try (final ForkJoinPool pool = new ForkJoinPool()) {
            final RandomInitTask initTask = new RandomInitTask(array, 100);
            pool.invoke(initTask);
            LOG.info("Random init.   : {}", Arrays.toString(array));
            final SortTask sortTask = new SortTask(array);
            pool.invoke(sortTask);
            LOG.info("Merge Sort     : {}", Arrays.toString(array));
            final SortCheckTask check = new SortCheckTask(array);
            boolean ok = pool.invoke(check);
            LOG.info("Sort Check OK? : {}", ok);
        } finally {
            // Executor shutdown
        }
    }
}
