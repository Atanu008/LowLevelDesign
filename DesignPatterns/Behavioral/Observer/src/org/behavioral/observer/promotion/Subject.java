package org.behavioral.observer.promotion;

public interface Subject {

    void subscribe(EventType eventType, Listner listner);
    void unsubscribe(EventType eventType, Listner listner);
    void notifyListners(EventType eventType);

}
