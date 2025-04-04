/*
 * Copyright 2025 Hochschule Luzern - Informatik.
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
package e5.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Demonstration der Bankgeschäfte - Aufgabe 2 - N1_EX_ThreadsSynch.
 */
public final class DemoBankAccount {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBankAccount.class);

    /**
     * Privater Konstruktor.
     */
    public DemoBankAccount() {
    }

    /**
     * Wartet bis alle Threads abgearbeitet sind.
     *
     * @param threads Array mit Threads.
     * @throws InterruptedException Interupted.
     */
    private static void waitForCompletion(final Thread[] threads) throws InterruptedException {
        for (final Thread thread : threads) {
            thread.join();
        }
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn Warten unterbrochen wird.
     */

    public static void main(String[] args) throws InterruptedException {
        DemoBankAccount demo = new DemoBankAccount();
        demo.testSynchronized(1000,5);
    }

    public void testSynchronized(final int amount, final int accounts) throws InterruptedException {
        final ArrayList<BankAccount> source = new ArrayList<>();
        final ArrayList<BankAccount> target = new ArrayList<>();
        for (int i = 0; i < accounts; i++) {
            source.add(new BankAccount(amount));
            target.add(new BankAccount());
        }

        /*
        LOG.info("Bank accounts before transfers");
        for (int i = 0; i < accounts; i++) {
            LOG.info("source({}) = {}; target({}) = {};", i, source.get(i).getBalance(), i, target.get(i).getBalance());
        } */

        final Thread[] threads = new Thread[accounts * 2];


        for (int i = 0; i < accounts; i++) {
            threads[i] = new Thread(new AccountTask(source.get(i), target.get(i), amount));
            threads[i + accounts] = new Thread(new AccountTask(target.get(i), source.get(i), amount));
        }

        for (final Thread thread : threads) {
            thread.start();
        }

        waitForCompletion(threads);

        /*
        LOG.info("Bank accounts after transfers");
        for (int i = 0; i < accounts; i++) {
            LOG.info("source({}) = {}; target({}) = {};", i, source.get(i).getBalance(), i, target.get(i).getBalance());
        }
         */
    }
}
