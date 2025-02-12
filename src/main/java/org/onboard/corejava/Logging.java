package org.onboard.corejava;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {

    private static final Logger logger = LogManager.getLogger(Logging.class);

    public static void main(String[] args) {
        logger.fatal("This is a FATAL message");
        logger.error("This is an ERROR message");
        logger.warn("This is a WARN message");
        logger.info("This is an INFO message");
        logger.debug("This is a DEBUG message");
        logger.trace("This is a TRACE message");
    }
}
