import java.util.Optional;

public class Main {

    static class Box<A> {
        public A a;
    }


    public static void main(String[] args) throws InterruptedException {

        Box<Long> box = new Box<Long>();

        //             heap
        Runnable r1 = () -> {
            long sum = 0;
            for (int i = 0; i < 1000000000; i++) {
                sum += i;
            }
            box.a = sum;
        };


        Thread t = new Thread(r1);
        t.start();


        int c = 0;
        while (box.a == null) {
            c++;
            Thread.sleep(1);
        }
        System.out.println(c);



        System.out.println(box.a);

    }

}
