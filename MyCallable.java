package ru.netology;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private int messageCount = 0;

    public MyCallable(int messageCount) {

        this.messageCount = messageCount;
    }

    @Override
    public Integer call() throws Exception {
        int showCount = 0;
        for (int i = 0; i < messageCount; i++) {
            Thread.sleep(1000);
            System.out.printf("Запущен поток № %s\n", Thread.currentThread().getId());
            showCount++;
        }
        return showCount;
    }
}