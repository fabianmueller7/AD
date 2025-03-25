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
package e6.n22.executor.plain;

import e6.n21.buffer.sema.BoundedBuffer;
import e6.n21.buffer.sema.Consumer;
import e6.n21.buffer.sema.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Demonstration eines Threads Pools für n Producer und m Consumer mit
 * BoundedBuffer.
 */
public final class DemoPlainThreadPool {

    private static final Logger LOG = LoggerFactory.getLogger(DemoPlainThreadPool.class);

    /**
     * Privater Konstruktor.
     */
    private DemoPlainThreadPool() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     */
    public static void main(final String args[]) throws InterruptedException {
        final Random random = new Random();
        final PlainThreadPool threadPool = new PlainThreadPool(10, 5);
        final int nPros = 3;
        final Producer[] producers = new Producer[nPros];
        final int mCons = 2;
        final Consumer[] consumers = new Consumer[mCons];
        final BoundedBuffer<Integer> queue = new BoundedBuffer<>(50);
        for (int i = 0; i < nPros; i++) {
            producers[i] = new Producer(queue, random.nextInt(10000));
            threadPool.execute(producers[i]);
        }
        for (int i = 0; i < mCons; i++) {
            consumers[i] = new Consumer(queue);
            threadPool.execute(consumers[i]);
        }
        TimeUnit.MILLISECONDS.sleep(100);
        long sumPros = 0;
        for (int i = 0; i < nPros; i++) {
            LOG.info("Prod " + (char) (i + 65) + " = " + producers[i].getSum());
            sumPros += producers[i].getSum();
        }
        long sumCons = 0;
        for (int i = 0; i < mCons; i++) {
            LOG.info("Cons " + (char) (i + 65) + " = " + consumers[i].getSum());
            sumCons += consumers[i].getSum();
        }
        LOG.info(sumPros + " = " + sumCons);
    }
}
