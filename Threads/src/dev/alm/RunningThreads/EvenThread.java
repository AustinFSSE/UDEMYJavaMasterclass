package dev.alm.RunningThreads;

public class EvenThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("EvenThread " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("EvenThread interrupted!");
                    break;
                }
            }
        }
    }
}
