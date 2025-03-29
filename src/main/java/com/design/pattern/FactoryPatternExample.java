package com.design.pattern;

enum LoggerType {
    CONSOLE, FILE, DATABASE
}

// Product interface
interface Logger {
    void log(String message);
}

// Concrete product classes
class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("ConsoleLogger: " + message);
    }
}
class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("FileLogger: " + message);
    }
}
class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("DatabaseLogger: " + message);
    }
}

// Factory class
class LoggerFactory {
    public static Logger getLogger(LoggerType type) {
        return switch (type) {
            case CONSOLE -> new ConsoleLogger();
            case FILE -> new FileLogger();
            case DATABASE -> new DatabaseLogger();
            default -> throw new IllegalArgumentException("Unknown logger type");
        };
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LoggerType.CONSOLE);
        logger.log("This is a console log message.");

        logger = LoggerFactory.getLogger(LoggerType.FILE);
        logger.log("This is a file log message.");

        logger = LoggerFactory.getLogger(LoggerType.DATABASE);
        logger.log("This is a database log message.");
    }
}
