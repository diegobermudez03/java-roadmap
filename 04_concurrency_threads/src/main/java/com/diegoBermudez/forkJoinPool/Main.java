package com.diegoBermudez.forkJoinPool;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        //this is a really, REALLY BASIC EXAMPLE, BUT IT SHOWS THE POWER OF THE FORK JOIN POOL
        //IT BASICALLY WORKS AS A TREE STRUCTURE, WITH THE RECURSION SO THAT AT THE END WE GET A SINGLE
        //RESULT FROM ALL THE TREE BRANCHES, THERE'S ALSO A RECURSEIVEACTION INSTEAD OF TASK, THIS DOESN'T JOIN()
        //WHICH MEANS, ONLY PRODUCES ACTIONS IN A TREE STRUCTURE, BUT DOESN'T DO THE RECURSION TO GET THE RESULT VALUE

        //THE POWER OF THIS POOL IS THAT IT TAKES TASKS, THAT THEY DIVIDE THEMSELF IN OTHER SUBTASKS, SO IT MANAGES A DEQUEUE
        //FOR EACH TASKS FOR ITS SUBTASKS, AND ALSO HAS WORKLOAD BALANCE BETWEEN THREADS, IS REALLY POWERFUL AN AWESOME
        ForkJoinPool myPool = new ForkJoinPool(10);
        //ForkJoinPool myPool = ForkJoinPool.commonPool();
        MyRecursiveTask task = new MyRecursiveTask();
        double result = myPool.invoke(task);
        System.out.println("I just made the call");
        System.out.println("Result is " + result);

    }
}
