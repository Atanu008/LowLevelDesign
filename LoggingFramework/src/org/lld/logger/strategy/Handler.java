package org.lld.logger.strategy;

import org.lld.logger.model.Message;

public interface Handler {

    void publish(Message message);
}
