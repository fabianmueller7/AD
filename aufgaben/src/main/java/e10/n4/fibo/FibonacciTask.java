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
package e10.n4.fibo;

import e10.n4.mergesort.MergesortRecursive;
import e10.n4.mergesort.MergesortTask;
import e10.n4.quicksort.QuicksortRecursive;
import e10.n4.quicksort.QuicksortTask;

import java.util.concurrent.RecursiveTask;

/**
 * Codevorlage für ein klassisches Beispiel zur Berechnung von Fibonacci Zahlen.
 */
@SuppressWarnings("serial")
public final class FibonacciTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 25;
    /**
     * Gegebene Zahl für die gesuchte Fibonacci Zahl.
     */
    private final int n;


    /**
     * Erzeugt einen Fibonacci Task.
     *
     * @param n für die Fibonacci Berechnung.
     */
    public FibonacciTask(final int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        long result = 0;
        if(n <= THRESHOLD) {
            return FibonacciCalc.fiboRecursive(n);
        } else {
            final FibonacciTask taskLeft = new FibonacciTask(n-1);
            final FibonacciTask taskRight = new FibonacciTask(n -2);
            taskLeft.fork();
            result += taskRight.invoke() + taskLeft.join();
        }
        return result;
    }
}
