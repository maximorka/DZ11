package Task2;

import java.util.concurrent.*;

class Exec3 {

        public  boolean fizz ( int i){
            if (i % 3 == 0) {
                System.out.println("fizz");
                return true;
            } else {
                return false;
            }
        }

        public  boolean buzz ( int i){
            if (i % 5 == 0) {
                System.out.println("buzz");
                return true;
            } else {
                return false;
            }
        }

        public  boolean fizzbuzz ( int i){
            if (i % 15 == 0) {
                System.out.println("fizzbuzz");
                return true;
            } else {
                return false;
            }
        }

        public void number ( int i){
            System.out.println(Integer.toString(i));
        }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Exec3 exec3 = new Exec3();

        ExecutorService a = Executors.newSingleThreadExecutor();
        ExecutorService b = Executors.newSingleThreadExecutor();
        ExecutorService c = Executors.newSingleThreadExecutor();
        ExecutorService d = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 19; i++) {
            synchronized (exec3) {
                int finalI = i;
                Future future = c.submit(() -> exec3.fizzbuzz(finalI));

                if (future.get().equals(true))
                    continue;

                future = b.submit(() -> exec3.buzz(finalI));
                if (future.get().equals(true))
                    continue;

                future = a.submit(() -> exec3.fizz(finalI));
                if (future.get().equals(true))
                    continue;

                future = d.submit(() -> exec3.number(finalI));

            }
        }
    }
}
