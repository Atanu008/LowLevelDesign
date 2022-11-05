package messagequeue.pubsub.model;

import lombok.SneakyThrows;

public class SleepingSubscriber implements ISubscriber{
    private final String id;
    private final int sleepTimeInMillis;

    public SleepingSubscriber(String id, int sleepTimeInMillis) {
        this.id = id;
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    @SneakyThrows //Interrupted Excception throws
    public void consume(Message message) {
        System.out.println("Subscriber: " + id + " started consuming: " + message.getMessage());
        Thread.sleep(sleepTimeInMillis); // Consume takes time  :)
        System.out.println("Subscriber: " + id + " done consuming: " + message.getMessage());
    }
}
