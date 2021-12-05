package com.wtj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerController {
    private final static Logger logger = LoggerFactory.getLogger(LoggerController.class);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            logger.debug("ok");
        }

    }
}
