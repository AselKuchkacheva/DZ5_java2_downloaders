package com.company;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    private Semaphore semaphore;
    private CountDownLatch cdl;
    private int speedDownload = 100;
    private CountDownLatch cdLatch;

    public Downloaders(String name, Semaphore semaphore, CountDownLatch countDownLatch,
                       CountDownLatch countDownLatch1) {
        super(name);
        this.cdLatch = countDownLatch1;
        this.semaphore = semaphore;
        this.cdl = countDownLatch;
        start();
    }

    @Override
    public synchronized void run() {
        try {
            cdl.await();
            semaphore.acquire();
            System.out.println(getName() + " скачивается из сервера.");
            sleep(500 / speedDownload*1000);
            System.out.println(getName() + " успешно скачался из сервера");
            cdLatch.countDown();
            semaphore.release();
        } catch (InterruptedException ignored) {
        }
    }
}