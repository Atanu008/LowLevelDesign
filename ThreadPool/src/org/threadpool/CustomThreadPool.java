package org.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

//https://jenkov.com/tutorials/java-concurrency/thread-pools.html
//https://www.youtube.com/watch?v=ZcKt5FYd3bU&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=12
public class CustomThreadPool {

    private BlockingQueue<Runnable> taskQueue;
    private List<WorkerThread> workerThreads;
    private List<WorkerThreadRunnable> workerThreadRunnables;
    private AtomicBoolean isThreadShutDownInitiated;

    public CustomThreadPool(int threadPoolSize){
        workerThreads = new ArrayList<>(threadPoolSize);
        workerThreadRunnables = new ArrayList<>(threadPoolSize);
        taskQueue = new LinkedBlockingDeque<>();//Will Maintain the Order . ArrayBlocking Queue can be ised also
        isThreadShutDownInitiated = new AtomicBoolean(false);

        //Create Worker Threads
        for(int i = 0; i < threadPoolSize; i++){
            WorkerThread worker = new WorkerThread(taskQueue);
            WorkerThreadRunnable workerRunnable = new WorkerThreadRunnable(taskQueue);
            workerThreads.add(worker);
            workerThreadRunnables.add(workerRunnable);
            //worker.start(); Either use This WorkerThread Or WorkerThreadRunnable
            new Thread(workerRunnable).start();
        }
    }

    public  synchronized void execute(Runnable task) throws InterruptedException {
        if(!isThreadShutDownInitiated.get()){
            taskQueue.offer(task);
        }
        else{
            throw new InterruptedException("Thread Pool shutdown is initiated, unable to execute task");
        }
    }

    public synchronized void stop() {
        isThreadShutDownInitiated = new AtomicBoolean(true);
        for(WorkerThread worker: workerThreads){
            worker.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {

        while(!taskQueue.isEmpty()){
            try {
                Thread.sleep(1); //Wait so that worker can finish the currently executing Tasks
            } catch (InterruptedException e) {

            }
        }
    }
}
