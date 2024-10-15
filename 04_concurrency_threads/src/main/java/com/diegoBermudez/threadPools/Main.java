package com.diegoBermudez.threadPools;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //FIXED THREAD POOL: USES A QUEUE, AND THE NUMBER OF THREADS WILL ALWAYS BE THE SAME

        //CACHED THREAD POOL: THERE'S NO QUEUE, IF ALL THREADS ARE OCCUPIED, IT CREATES ONE MORE, IF AFTER 60 SECONDS
        //A THREAD HASN'T BE USED, THEN IS KILLED

        //SCHEDULED THREAD POOL: IT USES A QUEUE, BUT IS A DIFFERENT QUUEUE WHICH PRIORITY IS BASED ON THE TIME
        //WE PASSED TASKS TO BE DONE EVERY N TIME
        List<Task> tasks = new LinkedList<>();
        for(int i = 0; i < 100; i++) tasks.add(new Task(i+1));
        int nCpu = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(nCpu-1);
        //ExecutorService service = Executors.newCachedThreadPool();
        for(Task t: tasks){
            service.execute(t);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("number of threads alive: " + Thread.activeCount());
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //scheduled thread pool
        ScheduledExecutorService schPool = Executors.newScheduledThreadPool(nCpu-1);
        Task t1 = new Task(101){
            @Override
            public void run(){
                System.out.println("HI hi HI hI, I'm 101");
            }
        };
        Task t2 = new Task(102){
            @Override
            public void run(){
                System.out.println("      */*//*/*/*/*/*/*/*/");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Task t3 = new Task(103){
            @Override
            public void run(){
                System.out.println(" 5555555555555555555");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        schPool.schedule(t1, 15, TimeUnit.SECONDS);//ONLY EXECUTES ONE TIME
        schPool.scheduleAtFixedRate(t2, 3, 5 , TimeUnit.SECONDS); //THE PERIOD STARTS RIGHT AFTER THE CURRENT TASK STARTS
        schPool.scheduleWithFixedDelay(t3, 3, 5, TimeUnit.SECONDS); //THE DELAY STARTS AFTER THE CURRENT TASK ENDS

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        schPool.shutdownNow();


        //SINGLE THREADED EXECUTOR
        System.out.println("***************************************");
        ExecutorService single =  Executors.newSingleThreadExecutor();
        single.execute(t1);
        single.execute(t2);
        single.execute(t3);

        single.shutdown();

    }
}
