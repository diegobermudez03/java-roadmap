package com.diegoBermudez.lockAwaitSignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CPU {
    private ReentrantLock turningOnLock = new ReentrantLock();
    private Condition turningOnCond = turningOnLock.newCondition();
    private boolean gpuReady = false;
    private boolean cpuReady = false;

    public void turningOn() throws InterruptedException {
            turningOnLock.lock();
            System.out.println("-------We'll start the process of turning on");
            Thread.sleep(2000);
            System.out.println("-------The motherboard was turned on");
            Thread.sleep(2000);
            System.out.println("-------Now the ram was turned on");
            System.out.println("---------TIME TO START UP THE PROCESSES");
            turningOnLock.unlock();
            for(int i = 0; i < 10; i++){
                ( new Thread(){
                    @Override
                    public void run(){
                        startProcess(Thread.currentThread());
                    }
                }).start();
                Thread.sleep(100);
            }
            turningOnLock.lock();
            System.out.println("-------Lets turn on the GPU, thats a separate complex process");
            if(!gpuReady) turningOnCond.await();
            System.out.println("-------It seems the GPU is now on, now I can continue");
            System.out.println("-------Begninning with processes");
            cpuReady = true;
            turningOnCond.signalAll();
            turningOnLock.unlock();
    }

    public void startProcess(Thread t){
        turningOnLock.lock();
        System.out.println("         from process begginning work");
        try {
            turningOnCond.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("          process completed, remaining " + turningOnLock.getQueueLength());
        turningOnCond.signalAll();
        turningOnLock.unlock();

    }

    public void gpuOn() throws InterruptedException {

            System.out.println("+++++++lets prepare to turn on the GPU");
            System.out.println("+++++++beginning preparations");
            Thread.sleep(4000);
            System.out.println("+++++++preparations ended, now I need the cpu to interact");
            turningOnLock.lock();
            System.out.println("+++++++Lets do some work from the GPU");
            Thread.sleep(4000);
            System.out.println("+++++++Work ended from the GPU, continue CPU");
            gpuReady = true;
            turningOnCond.signal();
            turningOnLock.unlock();

    }
}
