package com.example;

import java.util.logging.Logger;

public class CodeSmellTest {

    private static final Logger logger = Logger.getLogger(CodeSmellTest.class.getName());

    public static void main(String[] args) {

        int denominator = 2;

        if (denominator == 0) {
            logger.warning("Denominator cannot be zero");
        } else {
            int result = 10 / denominator;
            logger.info("Result: " + result);
        }

        String apiKey = System.getenv("API_KEY");
        logger.info("API Key loaded: " + apiKey);
    }
}
