package messagequeue.pubsub.model;

public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}
