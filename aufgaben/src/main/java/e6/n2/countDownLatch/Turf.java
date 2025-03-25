package e6.n2.countDownLatch;

import e6.n2.countDownLatch.RaceHorse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class Turf {

    private static final Logger LOG = LoggerFactory.getLogger(e6.n2.latch.Turf.class);
    private static final int HORSES = 5;

    /**
     * Privater Konstruktor.
     */
    private Turf() {
    }

    /**
     * Main-Demo.
     * @param args not used.
     */
    public static void main(final String[] args) throws InterruptedException {
        final CountDownLatch starterBox = new CountDownLatch(1);
        for (int i = 1; i <= HORSES; i++) {
            Thread.startVirtualThread(new RaceHorse(starterBox, "Horse " + i));
        }
        LOG.info("Start...");
        starterBox.countDown();
    }
}
