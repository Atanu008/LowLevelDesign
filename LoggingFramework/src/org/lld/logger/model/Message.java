package org.lld.logger.model;

import org.lld.logger.enums.LogLevel;

import java.time.LocalDateTime;

public class Message {

    private LogLevel logLevel;
    private LocalDateTime epoch;
    private String message;
    private String namespace;

    public Message(LogLevel logLevel, LocalDateTime epoch, String message, String namespace) {
        this.logLevel = logLevel;
        this.epoch = epoch;
        this.message = message;
        this.namespace = namespace;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public LocalDateTime getEpoch() {
        return epoch;
    }

    public void setEpoch(LocalDateTime epoch) {
        this.epoch = epoch;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
