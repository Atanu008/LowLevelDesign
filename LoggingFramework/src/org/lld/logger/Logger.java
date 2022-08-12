package org.lld.logger;

import lombok.NonNull;
import org.lld.logger.config.LoggerConfiguration;
import org.lld.logger.enums.HandlerType;
import org.lld.logger.enums.LogLevel;
import org.lld.logger.model.Message;
import org.lld.logger.strategy.Handler;
import org.lld.logger.strategy.HandlerContext;

import java.time.LocalDateTime;
import java.util.Set;

public class Logger {

    private static Logger logger;
    private LoggerConfiguration loggerConfiguration;

    private Logger(){
        loggerConfiguration = LoggerConfiguration.getInstance();

    }

    public static Logger getInstance(){

        if(logger == null){
            synchronized (Logger.class){
                if(logger == null){
                    logger = new Logger();
                }
            }
        }

        return logger;
    }

    public void log(@NonNull final String message, @NonNull final LogLevel level, @NonNull final String namespace){

        LogLevel messageLogLevel = level;
        LogLevel globalLogLevel = loggerConfiguration.getGlobalLogLevel();

        // check whether need to log or not
        //Proceed if message Log Level is higher
        if(messageLogLevel.getLogLevelNumber() >= globalLogLevel.getLogLevelNumber()){

            Set<HandlerType> handlerTypes = loggerConfiguration.getHandlerTypesByLogLevel(messageLogLevel);

            for(HandlerType handlerType : handlerTypes){
                Handler handler = HandlerContext.getRegisteredHandler(handlerType);
                Message logMessage = new Message(messageLogLevel, LocalDateTime.now(), message, namespace);
                handler.publish(logMessage);
            }
        }

    }
    //Add Global Level
    public void addGlobalLevel(LogLevel globalLogLevel){
        loggerConfiguration.setGlobalLogLevel(globalLogLevel);
    }
    //Add Handler
    public void addHandlerTypeToLogLevel(LogLevel logLevel, HandlerType handlerType){
        loggerConfiguration.addHandlerTypeToLogLevel(logLevel, handlerType);
    }
}
