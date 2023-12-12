package com.learning.LearningSpringboot.Controllers;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "/testController")
@Slf4j
public class BasicRestController {

    @GetMapping("/hello")
    @Timed(value = "greeting.time", description = "Time taken to return greeting")
    /*
    If you don’t see your custom metric, make sure that you have triggered this function
    at least once. The metric won’t appear until the timer has recorded at least once.
     */
    public ResponseEntity<?> helloWorld(){
        log.info("Hello World!!");
        log.info("Calling Add fn: " + add(5,3));
        log.error("Test Error");
        log.error("Test Error2");
        log.debug("Test Debug");
        log.warn("Test Warn");
        return new ResponseEntity<>("Hello World!!", HttpStatus.OK);
    }

//    @Timed(value = "add.time", description = "Time taken to return addition")
    public int add(int a, int b){
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a+b;
    }
}
