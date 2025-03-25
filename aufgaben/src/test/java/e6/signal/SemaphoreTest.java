package e6.signal;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SemaphoreTest {
    public SemaphoreTest() {
    }

    @Test
    @Disabled("bis Semaphore implementiert wird...")
    public void testSemaphoreLowLimit() throws Exception {
        int permits = 4;
        int limit = 3;
        String message = "limit < permits";
        assertThatThrownBy(() -> {
            Semaphore sema = new Semaphore(permits, limit);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith(message);
    }

    @Test
    @Disabled("bis Semaphore implementiert wird...")
    public void testReleaseOverflowLimit() throws Exception {
        int permits = 3;
        int limit = 3;
        String message = "overflow limit";
        assertThatThrownBy(() -> {
            Semaphore sema = new Semaphore(permits, limit);
            sema.release();
        }).isInstanceOf(ArithmeticException.class).hasMessageStartingWith(message);
    }

    @Test
    @Disabled("bis Semaphore implementiert wird...")
    public void testReleaseIntOverflowLimit() throws Exception {
        int permits = 0;
        int limit = 3;
        int releaseInt = 4;
        String message = "overflow limit";
        assertThatThrownBy(() -> {
            Semaphore sema = new Semaphore(permits, limit);
            sema.release(releaseInt);
        }).isInstanceOf(ArithmeticException.class).hasMessageStartingWith(message);
    }

    @Test
    @Disabled("bis Semaphore implementiert wird...")
    public void testAcquireIntOverflowPermits() throws Exception {
        int permits = 3;
        int limit = 3;
        int acquireInt = 4;
        String message = "overflow permits";
        assertThatThrownBy(() -> {
            Semaphore sema = new Semaphore(permits, limit);
            sema.acquire(acquireInt);
        }).isInstanceOf(ArithmeticException.class).hasMessageStartingWith(message);
    }

    @Test
    @Disabled("bis Semaphore implementiert wird...")
    public void testAcquireIntNegPermits() throws Exception {
        int permits = 3;
        int limit = 3;
        int acquireInt = -1;
        String message = "permits < 0";
        assertThatThrownBy(() -> {
            Semaphore sema = new Semaphore(permits, limit);
            sema.acquire(acquireInt);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith(message);
    }

    @Test
    @Disabled("bis Semaphore implementiert wird...")
    public void testReleaseIntNegPermits() throws Exception {
        int permits = 3;
        int limit = 3;
        int releaseInt = -1;
        String message = "permits < 0";
        assertThatThrownBy(() -> {
            Semaphore sema = new Semaphore(permits, limit);
            sema.release(releaseInt);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith(message);
    }
}