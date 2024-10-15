package com.diegoBermudez.producerConsumerPattern;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Producer implements  Runnable{

    private ConcurrentLinkedQueue<Aprocesar> queue;

    public Producer(ConcurrentLinkedQueue<Aprocesar> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Producing from " + Thread.currentThread().getName());
            Aprocesar aux = new Aprocesar(Aprocesar.counter, ("" + System.currentTimeMillis()));
            Aprocesar.counter++;
            try {
                queue.add(aux);
                Thread.sleep(900);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
