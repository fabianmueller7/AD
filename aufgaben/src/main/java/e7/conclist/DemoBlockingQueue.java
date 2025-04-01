package e7.conclist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.*;

public class DemoBlockingQueue {

    private static final Logger LOG = LoggerFactory.getLogger(e7.conclist.DemoConcurrentList.class);

    /**
     * Privater Konstruktor.
     */
    private DemoBlockingQueue() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     * @throws ExecutionException bei Excecution-Fehler.
     */
    public static void main(final String args[]) throws InterruptedException, ExecutionException {

        final Random random = new Random();
        final LinkedBlockingDeque<Integer> list = new LinkedBlockingDeque<Integer>();
        final List<Future<Long>> futures = new ArrayList<>();


        try (final ExecutorService executor = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 3; i++) {
                futures.add(executor.submit(new Producer(list, random.nextInt(1_000))));
            }
            Iterator<Future<Long>> iterator = futures.iterator();
            long totProd = 0;
            while (iterator.hasNext()) {
                long sum = iterator.next().get();
                totProd += sum;
                LOG.info("prod sum = " + sum);
            }
            LOG.info("prod tot = " + totProd);
            long totCons = executor.submit(new Consumer(list)).get();
            LOG.info("cons tot = " + totCons);
        } finally {
            // Executor shutdown
        }
    }
}
