package org.lld.logger;

import org.lld.logger.enums.HandlerType;
import org.lld.logger.enums.LogLevel;

public class LoggerApplication {

    public static void main(String[] args) {

        //Create Logger
        Logger logger = Logger.getInstance();

        //Set Global Log Level
        logger.addGlobalLevel(LogLevel.FINER);

        //ADD File and Console Handler is Severe
        logger.addHandlerTypeToLogLevel(LogLevel.SEVERE, HandlerType.FILE);
        logger.addHandlerTypeToLogLevel(LogLevel.SEVERE, HandlerType.CONSOLE);

        //ADD Database and Console Handler is Info
        logger.addHandlerTypeToLogLevel(LogLevel.INFO, HandlerType.CONSOLE);
        logger.addHandlerTypeToLogLevel(LogLevel.INFO, HandlerType.DATABASE);

        //ADD Database and Console Handler is FINEST.
        logger.addHandlerTypeToLogLevel(LogLevel.FINEST, HandlerType.CONSOLE);
        logger.addHandlerTypeToLogLevel(LogLevel.FINEST, HandlerType.DATABASE);

        logger.log("I am Severe", LogLevel.SEVERE, "LoggerApplication.class");
        logger.log("I am Info", LogLevel.INFO, "LoggerApplication.class");
        logger.log("I am Finest", LogLevel.FINEST, "LoggerApplication.class"); // No print as this is lower than global
        logger.log("I am Finer", LogLevel.FINER, "LoggerApplication.class"); //Default File as No handler configured


    }
}
