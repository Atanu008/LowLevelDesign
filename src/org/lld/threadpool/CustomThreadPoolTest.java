package org.lld.threadpool;

public class CustomThreadPoolTest {

    public static void main(String[] args) throws Exception{
        CustomThreadPool threadPool = new CustomThreadPool(4);

        for(int i = 0; i < 10; i++){
            int taskNo = i;
            threadPool.execute(() -> {
                String message = Thread.currentThread().getName() + " : Task "+ taskNo;
                System.out.println(message);
            });
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
