import java.util.concurrent.atomic.AtomicLong;

public class MultithreadingIntro5 {

    static class Ready<A> {
        public A a;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicLong ai = new AtomicLong();

        Ready<Integer> ready1 = new Ready<>();
        Ready<Integer> ready2 = new Ready<>();

        Runnable r1 = () -> {
            for (int i = 0; i < 10000000; i++) {
                ai.addAndGet(1);
            }
            ready1.a = 1;
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 10000000; i++) {
                ai.addAndGet(-1);
            }
            ready2.a = 1;
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        int c = 0;
        while ((ready1.a == null) || (ready2.a == null)) {
            c++;
            Thread.sleep(1);
        }
        System.out.printf("slept %d\n", c);

        System.out.println(ai.get());

    }

}
