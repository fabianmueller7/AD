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
package e7.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 100 grosse Primzahlen finden.
 */
public final class PrimeCheck {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheck.class);

    private static final AtomicInteger count = new AtomicInteger(1);
    private static final int nThreads = Runtime.getRuntime().availableProcessors();

    /**
     * Privater Konstruktor.
     */
    private PrimeCheck() {}

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try (final ExecutorService executor = Executors.newFixedThreadPool(PrimeCheck.nThreads)) {
            for (int i = 0; i < nThreads; i++) { // Starting n number of Threads
                    executor.execute(() -> {
                        while (count.get() <= 1000) { // Checking if done inside the thread, else they would just continue
                            BigInteger number = new BigInteger(1024, new Random());
                            if (number.isProbablePrime(Integer.MAX_VALUE)) {
                                LOG.info("{} : {}...", count, number.toString().substring(0, 20));
                                count.incrementAndGet();
                            }
                        }
                    });
            }
            executor.shutdown();
        }
        long end = System.currentTimeMillis();
        LOG.info("Total time: {} ms", end - start);

    }
}
