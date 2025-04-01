package e7.bank;

import e5.bank.DemoBankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompareTransfers {

    private static final Logger LOG = LoggerFactory.getLogger(e7.bank.DemoBankAccount.class);

    public static void main(String[] args) throws InterruptedException {
        CompareTransfers tester = new CompareTransfers();

        int amount1 = 100000;
        LOG.info( "Amount: " + amount1  + "; Atmoic " + tester.runtestAtomic(5,amount1,5) + "ms; Syn " + tester.runtestSyn(5,amount1,5) +" ms");

    }

    public long runtestSyn(final int passes, final int amount, final int accounts) throws InterruptedException {
        e5.bank.DemoBankAccount synDemo = new e5.bank.DemoBankAccount();

        long result = 0;
        for (int i = 0; i < passes; i++) {
            final long starttime = System.nanoTime();
            synDemo.testSynchronized(amount, accounts);
            final long endtime = System.nanoTime();
            result += (endtime - starttime)/1000000L;
        }
        return (int) (result / passes);
    }

    public long runtestAtomic(final int passes, final int amount, final int accounts) {
        e7.bank.DemoBankAccount atomicDemo = new e7.bank.DemoBankAccount();

        long result = 0;
        for (int i = 0; i < passes; i++) {
            final long starttime = System.nanoTime();
            atomicDemo.testAtomic(amount, accounts);
            final long endtime = System.nanoTime();
            result += (endtime - starttime)/1000000L;
        }
        return (int) (result / passes);
    }
}
