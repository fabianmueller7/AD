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
package e7.bank;

import e7.prime.PrimeCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstration der Bankgeschäfte - Aufgabe 4 - N3_EX_WeiterführendeKonzepte.
 */
public final class DemoBankAccount {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBankAccount.class);

    /**
     * Privater Konstruktor.
     */
    private DemoBankAccount() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn Warten unterbrochen wird.
     */
    public static void main(String[] args) throws InterruptedException {
        final ArrayList<BankAccount> source = new ArrayList<>();
        final ArrayList<BankAccount> target = new ArrayList<>();
        final int amount = 100_000;
        final int number = 5;
        final int nThreads = number*2;
        for (int i = 0; i < number; i++) {
            source.add(new BankAccount(amount));
            target.add(new BankAccount());
        }

        //Create tasks
        final ArrayList <AccountTask> tasks = new ArrayList<>();
        for(int i = 0; i < source.size(); i++) {
            tasks.add(new AccountTask(source.get(i), target.get(i), amount));
        }
        for(int i = 0; i < source.size(); i++) {
            tasks.add(new AccountTask(target.get(i), source.get(i), amount));
        }


        // Account Tasks starten...
        try (final ExecutorService executor = Executors.newFixedThreadPool(nThreads)) {
            for (int i = 0; i < nThreads; i++) { // Starting n number of Threads
                final int index = i;
                executor.execute(() -> tasks.get(index).run());
            }
            executor.shutdown();
        }
        LOG.info("Bank accounts after transfers");
        for (int i = 0; i < number; i++) {
            LOG.info("source({}) = {}; target({}) = {};", i, source.get(i).getBalance(), i, target.get(i).getBalance());
        }
    }
}
