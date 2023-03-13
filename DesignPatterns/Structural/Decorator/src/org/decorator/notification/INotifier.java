package org.decorator.notification;

//This is Component
public interface INotifier {
    void send(String message);
    String getUserName();
}
