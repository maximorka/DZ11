package Task1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T1 {

    static class TimeCalc extends Thread {

        private long time;

        public TimeCalc(long time) {
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
            while (true) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                time += 1;
                toListeners(time);
                System.out.println("Time work program is "+time+" c");
            }
        }
    }

    public static void main(String[] args) {
        T1 t1 =new T1();
        TimeCalc timeCalc = new TimeCalc(0);
        timeCalc.start();

        timeCalc.addListeners(t1::printDataTime);
    }


    public void printDataTime(long time) {
        if (time % 5 == 0)
            System.out.println("Пройшло 5 сек");
    }
}
