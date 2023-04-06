import java.util.concurrent.CountDownLatch;

public class MultithreadingIntro4 {

    static class Counter {
        public int a;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter x = new Counter();
        Counter y = new Counter();

        CountDownLatch latch = new CountDownLatch(2);

        int cpu = Runtime.getRuntime().availableProcessors();
        System.out.println(cpu);

        Runnable r1 = () -> {
            for (int i = 0; i < 10000000; i++) {
                x.a++;
            }
            latch.countDown();
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 10000000; i++) {
                y.a--;
            }
            latch.countDown();
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        latch.await();
        System.out.println(x.a + y.a);

    }

}
