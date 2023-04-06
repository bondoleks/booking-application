public class MultithreadingIntro3 {

    static class Counter {
        public int a;
    }

    static class Ready<A> {
        public A a;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter x = new Counter();
        Counter y = new Counter();
        Ready<Integer> ready1 = new Ready<>();
        Ready<Integer> ready2 = new Ready<>();

        int cpu = Runtime.getRuntime().availableProcessors();
        System.out.println(cpu);

        Runnable r1 = () -> {
            for (int i = 0; i < 10000000; i++) {
                x.a++;
            }
            ready1.a = 1;
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 10000000; i++) {
                y.a--;
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

        System.out.println(x.a + y.a);

    }

}
