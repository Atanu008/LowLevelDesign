package org.lld.logger.config;

import org.lld.logger.enums.HandlerType;
import org.lld.logger.enums.LogLevel;
import org.lld.logger.strategy.Handler;

import java.util.*;

public class LoggerConfiguration {

    // The sole instance of the class. Note its marked volatile
    private static volatile LoggerConfiguration loggerConfiguration;

    private LogLevel globalLogLevel;
    private Map<LogLevel, Set<HandlerType>> logLevelHandlerTypeMap; //Set to have no duplicate handler, as we have unique

    private LoggerConfiguration(){
        logLevelHandlerTypeMap = new HashMap<>();
    }

    public static LoggerConfiguration getInstance(){

       if(loggerConfiguration == null){
           synchronized (LoggerConfiguration.class){
               if(loggerConfiguration == null){
                   loggerConfiguration = new LoggerConfiguration();
               }
           }
       }

       return loggerConfiguration;
    }

    public void addHandlerTypeToLogLevel(LogLevel logLevel, HandlerType handlerType){
        logLevelHandlerTypeMap.putIfAbsent(logLevel, new HashSet<>());
        logLevelHandlerTypeMap.get(logLevel).add(handlerType);
    }

    public Set<HandlerType> getHandlerTypesByLogLevel(LogLevel logLevel){
        Set<HandlerType> handlers = logLevelHandlerTypeMap.get(logLevel);
        //If Handlers present add, default File and return
        if(handlers == null){
            addHandlerTypeToLogLevel(logLevel, HandlerType.FILE);
        }

        return logLevelHandlerTypeMap.get(logLevel);
    }

    public LogLevel getGlobalLogLevel() {
        return globalLogLevel;
    }

    public void setGlobalLogLevel(LogLevel globalLogLevel) {
        this.globalLogLevel = globalLogLevel;
    }
}
