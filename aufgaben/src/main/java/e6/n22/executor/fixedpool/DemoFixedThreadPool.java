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
package e6.n22.executor.fixedpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demo eines FixedThreadPool Executors.
 */
public final class DemoFixedThreadPool {

    private static final Logger LOG = LoggerFactory.getLogger(DemoFixedThreadPool.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFixedThreadPool() {
    }

    /**
     * Main-Demo.
     * @param args not used.
     */
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        final int nThreads = 1;
        try (final ExecutorService executor = Executors.newFixedThreadPool(nThreads)) {
            for (int nTask = 1; nTask <= 4; nTask++) {
                final char ch = (char) (64 + nTask);
                final char chStop = 'X';
                executor.execute(() -> {
                    LOG.info("starts {}", ch);
                    for (int i = 0; i < 200; i++) {
                        System.out.print(ch);
                        if (ch == chStop && i == 100) {
                            //Thread.currentThread().stop(); // nur zur Demonstration!
                        }
                    }
                    System.out.println("");
                    LOG.info("finished {}", ch);
                });
            }
        } finally {
            LOG.info("shutdown");
        }
    }
}
