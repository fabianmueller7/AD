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
package e7.conclist;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Produzent, der eine maximale Anzahl Werte produziert und diese in eine Queue
 * speichert.
 */
public final class Producer implements Callable<Long> {

    private final List<Integer> list;
    private final BlockingDeque<Integer> queue;
    private final int maxRange;

    /**
     * Erzeugt einen Produzent, der eine bestimmte Anzahl Integer-Werte
     * produziert.
     *
     * @param list Queue zum Speichern der Integer-Werte.
     * @param max Anzahl Integer-Werte.
     */
    public Producer(final List<Integer> list, final int max) {
        this.list = list;
        this.maxRange = max;
        this.queue = null;
    }

    /**
     * Erzeugt einen Produzent, der eine bestimmte Anzahl Integer-Werte
     * produziert.
     *
     * @param queue Queue zum Speichern der Integer-Werte.
     * @param max Anzahl Integer-Werte.
     */
    public Producer(final LinkedBlockingDeque<Integer> queue, final int max) {
        this.queue = queue;
        this.maxRange = max;
        this.list = null;
    }

    /**
     * Liefert die Summe aller zusammengezählter Integer Werte.
     *
     * @return Summe.
     * @throws Exception falls Ausnahmen passieren.
     */
    @Override
    public Long call() throws Exception {
        if(queue == null) { //list
            long sum = 0;
            for (int i = 0; i < maxRange; i++) {
                sum += i;
                list.add(i);
            }
            return sum;
        } else {
            long sum = 0;
            for (int i = 0; i < maxRange; i++) {
                sum += i;
                queue.addLast(i);
            }
            return sum;
        }

    }
}
