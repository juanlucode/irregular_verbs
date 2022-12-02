package io.github.iverbs.core.logfile;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFile {
    private static LogFile instance;

    private final Logger logger;
    private final FileHandler fileLog;


    private LogFile() {
        logger = Logger.getGlobal();
        logger.setLevel(Level.SEVERE);
        try {
            fileLog = new FileHandler("./irregular_verbs_core.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileLog.setFormatter(new SimpleFormatter());
        logger.addHandler(fileLog);

    }

    public static LogFile getInstance() {
        if ( instance == null){
            instance = new LogFile();
        }

        return  instance;
    }

    public void put(String _message){
        logger.severe(_message);
    }
}
