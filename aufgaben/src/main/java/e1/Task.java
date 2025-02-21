package e1;

public class Task {
    private int TASK1COUNTER = 0;
    private int TASK2COUNTER = 0;
    private int TASK3COUNTER = 0;

    public static void main(final String[] args) {

        for (int i = 0; i < 10; i++) {

            Task task = new Task();
            long startTime = System.currentTimeMillis();
            task.task(i);
            long endTime = System.currentTimeMillis();
            task.printCounters(i, endTime-startTime);

        }
    }

    public void task(final int n) {
        task1(); task1(); task1(); task1();
        for (int i = 0; i < n; i++) {
            task2(); task2(); task2();
            for (int j = 0; j < n; j++) {
                task3(); task3();
            }
        }
    }

    public void printCounters(final int start, final long duration) {
        System.out.println("Base: " + start + "; Task1: " + TASK1COUNTER + "; Task2: " + TASK2COUNTER + "; Task3: " + TASK3COUNTER + "; Duration: " + duration);
    }

    private void task1() {
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TASK1COUNTER++;
    }

    private void task2() {
        try{
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TASK2COUNTER++;
    }

    private void task3() {
        try{
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TASK3COUNTER++;
    }
}
