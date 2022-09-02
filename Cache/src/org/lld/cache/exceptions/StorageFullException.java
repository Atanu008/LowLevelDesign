package org.lld.cache.exceptions;

public class StorageFullException extends Exception {

    String message;

    public StorageFullException(String message) {
        super(message);
    }
}
