package org.lld.logger.strategy;

import org.lld.logger.model.Message;

public class FileHandler implements Handler{
    @Override
    public void publish(Message message) {
        System.out.println("Write in File "+ message.getEpoch()
                + ": { "+message.getLogLevel().getLogLevel() + " }:"
                + ": { " + message.getNamespace() + " }:"
                + " " + message.getMessage());
    }
}
