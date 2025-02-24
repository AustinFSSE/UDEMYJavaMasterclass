package dev.alm.ThreadChallenge;

import dev.alm.RunningThreads.EvenThread;
import dev.alm.RunningThreads.OddRunnable;


public class Main {
    public static void main(String[] args) {

        EvenThread customThread = new EvenThread();

        Runnable runnable = () -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("OddRunnable " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("OddRunnable interrupted!");
                    break;
                }
            }
        };
//        Thread oddThread = new Thread(new OddRunnable());
        Thread oddThread = new Thread(runnable);


        customThread.start();
        oddThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        oddThread.interrupt();
    }
}
