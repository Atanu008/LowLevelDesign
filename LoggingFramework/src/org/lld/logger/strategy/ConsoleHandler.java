package org.lld.logger.strategy;

import org.lld.logger.model.Message;

public class ConsoleHandler implements Handler{
    @Override
    public void publish(Message message) {
        System.out.println("Write in Console "+ message.getEpoch()
                + ": { "+message.getLogLevel().getLogLevel() + " }:"
                + ": { " + message.getNamespace() + " }:"
                + " " + message.getMessage());
    }
}
