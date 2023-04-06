public class MultithreadingIntro2 {

    static class Ready<A> {
        public A a;
    }

    static class Box {
        private int x;

        final private Object sync = new Object();

        public void inc() {
            //
            //
            synchronized (sync) {
                x++;
            }
            //
            //
        }

        public /*synchronized*/ void dec() {
            //
            //
            synchronized (sync) {
                x--;
            }
            //
            //
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Ready<Integer> ready1 = new Ready<>();
        Ready<Integer> ready2 = new Ready<>();

        int cpu = Runtime.getRuntime().availableProcessors();
        System.out.println(cpu);

        Box counter = new Box();

        Runnable r1 = () -> {
            for (int i = 0; i < 10000000; i++) {
                counter.inc();
            }
            ready1.a = 1;
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 10000000; i++) {
                counter.dec();
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

        System.out.println(counter.x);

    }

}
