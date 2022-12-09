package org.example;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Variables {
    private Variables() {
    }

    public static void printAllVariables() {
        log.info("boolean variable: " + true);
        log.info("char variable: " + 'A');
        log.info("int variable: " + 2);
        log.info("long variable: " + 100000000000L);
        log.info("float variable: " + 0.001f);
        log.info("double variable: " + 0.00000000001);
        log.info("String variable: " + "Hello World!");
    }
}
