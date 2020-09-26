package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {
    private CountDownLatch cdl;
    private int sizeOfFile = 500;
    private int speedOfDownload = 20;

    public Uploader(CountDownLatch countDownLatch) {
        this.cdl = countDownLatch;
        start();
    }

    @Override
    public void run() {
        System.out.println("Началась загрузка файла на сервер");
        try {
            System.out.print("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);
            System.out.print("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);
            System.out.print("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);
            System.out.print("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);
            System.out.print("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);
            System.out.print("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);
            System.out.print("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);
            System.out.print("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);
            System.out.print("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);
            System.out.println("|||||||");
            sleep(sizeOfFile / speedOfDownload*50);

            System.out.println("Загрузка завершена!");
            sleep(2000);

        } catch (InterruptedException ignored) {
        }
        cdl.countDown();
    }
}