package com.villagevista.villagevista.services.logservice;

import java.io.IOException;
import java.util.logging.*;

import com.villagevista.villagevista.services.config.Configuration;

public class LogService {

    private static Logger applicationLogger;

    public static Logger getApplicationLogger() {

        if (applicationLogger == null) {
            applicationLogger = Logger.getLogger(Configuration.GLOBAL_LOGGER_NAME);

            // Creazione e configurazione del gestore di file (FileHandler)
            try {
                FileHandler fileHandler = new FileHandler(Configuration.GLOBAL_LOGGER_FILE, true);
                SimpleFormatter formatterTxt = new SimpleFormatter();
                fileHandler.setFormatter(formatterTxt);
                applicationLogger.addHandler(fileHandler);
                applicationLogger.setLevel(Configuration.GLOBAL_LOGGER_LEVEL);
                applicationLogger.setUseParentHandlers(false);
            } catch (IOException e) {
                applicationLogger.log(Level.SEVERE, "Error occured in Logger creation", e);
                throw new RuntimeException(e);
            }

            applicationLogger.log(Level.CONFIG, "Logger: {0} created.", applicationLogger.getName());
        }
        return applicationLogger;
    }


}