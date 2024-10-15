package com.diegoBermudez.producerConsumerPattern;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
        //this is a vague example, but really vague, only to show how it manages the queue, and the producer
        //and the consumer, but it's really bad example, since in this case there's no control of limiting the
        //producers depending on the consumers performance, so the queue will grow up until infinity
        ConcurrentLinkedQueue<Aprocesar> queue = new ConcurrentLinkedQueue<>();
        List<Thread> producers = new LinkedList<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        for(int i = 1; i < Runtime.getRuntime().availableProcessors(); i++){
            producers.add(new Thread(producer));
        }
        Thread consumerThread = new Thread(consumer);
        for(Thread t: producers) t.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        consumerThread.start();

    }
}
