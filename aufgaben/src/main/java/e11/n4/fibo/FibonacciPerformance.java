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
package e11.n4.fibo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;

/**
 * Performance Vergleich der Fibonacci Implementationen.
 */
public final class FibonacciPerformance {

    private static final Logger LOG = LoggerFactory.getLogger(e11.n4.fibo.FibonacciPerformance.class);

    /**
     * Privater Konstruktor.
     */
    private FibonacciPerformance() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int n = 42;
        long result =0;

        LOG.info("fibo({}) start...", n);

        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final FibonacciTask task = new FibonacciTask(n);
        long startParallel = System.currentTimeMillis();
        //result = task.invoke(); //Common pool
        forkJoinPool.invoke(task); //Forkjoinpool
        long endParallel = System.currentTimeMillis();
        LOG.info("Parallel rekursiv = {}", result);
        LOG.info("Parallel rekursiv : {} msec.", endParallel - startParallel);

        long startIterative = System.currentTimeMillis();
        result = FibonacciCalc.fiboIterative(n);
        long endIterative = System.currentTimeMillis();
        LOG.info("Iterativ = {}", result);
        LOG.info("Iterativ : {} msec.", endIterative - startIterative);

        long startRecursive = System.currentTimeMillis();
        result = FibonacciCalc.fiboRecursive(n);
        long endRecursive = System.currentTimeMillis();
        LOG.info("Einfach rekursiv = {}", result);
        LOG.info("Einfach rekursiv : {} msec.", endRecursive - startRecursive);
    }
}
