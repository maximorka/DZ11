package Task1;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class T1 {

    static class TimeCalc extends Thread {

        private long time;
        private T1 t1;

        public TimeCalc(long time, T1 t1) {
            this.time = time;
            this.t1 = t1;
        }
        public List<TimeListener> listeners = new ArrayList<TimeListener>();

        public void addListeners(TimeListener timeListener) {
            listeners.add(timeListener);
        }

        public void toListeners() {
            if (listeners.size() > 0) {
                for (TimeListener listener : listeners) {
                    listener.doSmth();
                }
            }
        }

        @SneakyThrows
        public void run() {
            while (true) {
                t1.printTime(time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                time += 1;
                toListeners();
            }
        }
    }

    public static class OnlyPrint extends Thread {

        private T1 t1;

        public OnlyPrint( T1 t1) {
            this.t1 = t1;
        }

        @SneakyThrows
        public void run() {
            while (true) {
                t1.printEvery5sec();
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();

        TimeCalc timeCalc = new TimeCalc(0,t1);
        timeCalc.start();

        OnlyPrint onlyPrint = new OnlyPrint(t1);
        onlyPrint.start();

    }

    public synchronized void printTime(long time) {
        System.out.println("Time work program is " + time + " c");

        if (time % 5 == 0)
            notify();
    }

    public synchronized void printEvery5sec() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Пройшло 5 сек");
    }


}
