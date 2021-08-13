package ru.netology;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int count = 0;
        List<MyCallable> callableList = new ArrayList<>();

        callableList.add(new MyCallable(1));
        callableList.add(new MyCallable(2));
        callableList.add(new MyCallable(3));
        callableList.add(new MyCallable(4));

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("Invoking all");

        final List<Future<Integer>> tasksAll = threadPool.invokeAll(callableList);

        for (Future<Integer> task : tasksAll) {
            count += task.get();
        }

        System.out.println("Отправлено сообщений: " + count);

        System.out.println("Invoking any");

        int result = threadPool.invokeAny(callableList);

        System.out.println("Отправлено сообщений: " + result);

        threadPool.shutdown();
    }
}