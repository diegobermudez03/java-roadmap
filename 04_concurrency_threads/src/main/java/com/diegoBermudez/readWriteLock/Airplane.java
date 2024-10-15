package com.diegoBermudez.readWriteLock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Airplane {

    private ReentrantReadWriteLock mylock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readingLock = mylock.readLock();
    private ReentrantReadWriteLock.WriteLock writingLock = mylock.writeLock();
    private List<Integer> seats = new LinkedList<>();

    public void addSeat(int number){
        writingLock.lock();
        System.out.println("adding seat number " + number);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        seats.add(number);
        System.out.println("Seat added properly");
        writingLock.unlock();
    }

    public void readTotalSeats(){
        readingLock.lock();
        System.out.println("Lets check all the seats from thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("TOTAL SEATS IS " + seats.size());
        readingLock.unlock();
    }
}
