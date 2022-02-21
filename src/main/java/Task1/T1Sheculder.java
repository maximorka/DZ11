package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class T1Sheculder {

    static class TimeC implements Runnable {

        private long time;

        public TimeC(long time) {
            this.time = time;
        }

        public List<TimePrinter> listeners = new ArrayList<TimePrinter>();

        public void addListeners(TimePrinter timePrinter) {
            listeners.add(timePrinter);
        }

        public void toListeners(long time) {
            if (listeners.size() > 0) {
                for (TimePrinter listener : listeners) {
                    listener.print(time);
                }
            }
        }

        public void run() {
                time += 1;
                toListeners(time);
                System.out.println("Time work program is "+time+" c");
            }

    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        TimeC timeCalc = new TimeC(0);
        timeCalc.addListeners(t1::printDataTime);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(timeCalc,0L,1, TimeUnit.SECONDS);
    }

    public void printDataTime(long time) {
        if (time % 5 == 0)
            System.out.println("Пройшло 5 сек");
    }
}
