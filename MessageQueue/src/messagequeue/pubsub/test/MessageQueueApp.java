package messagequeue.pubsub.test;

import messagequeue.pubsub.model.Message;
import messagequeue.pubsub.model.SleepingSubscriber;
import messagequeue.pubsub.model.Topic;
import messagequeue.pubsub.queue.Queue;

public class MessageQueueApp {

    public static void main(String[] args) throws InterruptedException {

        final Queue queue = new Queue();
        final Topic topicA = queue.createTopic("TopicA");
        final Topic topicB = queue.createTopic("TopicB");

        final SleepingSubscriber sleepingSubscriber1 = new SleepingSubscriber("Subscriber1", 10000);
        final SleepingSubscriber sleepingSubscriber2 = new SleepingSubscriber("Subscriber2", 10000);

        queue.subscribe(sleepingSubscriber1, topicA);
        queue.subscribe(sleepingSubscriber2, topicA);

        final SleepingSubscriber sleepingSubscriber3 = new SleepingSubscriber("Subscriber3", 10000);
        queue.subscribe(sleepingSubscriber3, topicB);

        queue.publish(topicA, new Message("M1"));
        queue.publish(topicA, new Message("M2"));

        queue.publish(topicB, new Message("M3"));

        Thread.sleep(15000);

        queue.publish(topicB, new Message("M4"));
        queue.publish(topicA, new Message("M5"));

        queue.resetOffset(topicA, sleepingSubscriber1, 0);
    }
}
