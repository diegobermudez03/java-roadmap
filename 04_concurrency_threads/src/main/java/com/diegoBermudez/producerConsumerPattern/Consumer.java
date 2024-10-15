package com.diegoBermudez.producerConsumerPattern;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer implements Runnable{

    private ConcurrentLinkedQueue<Aprocesar> queue;

    public Consumer(ConcurrentLinkedQueue<Aprocesar> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Aprocesar p = queue.poll();
                System.out.println(p.toString());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
