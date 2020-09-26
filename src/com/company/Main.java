package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        CountDownLatch cdl = new CountDownLatch(1);
        CountDownLatch cdLatch = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3,true);
        new Uploader(cdl);

        for (int i = 1; i <=10; i++) {
            new Downloaders("Файл " + i, semaphore, cdl,cdLatch);

        }
        try {
            cdLatch.await();
            System.out.println("Файл из сервера удалится через 5 секунд!");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
