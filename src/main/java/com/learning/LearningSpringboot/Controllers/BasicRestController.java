package com.learning.LearningSpringboot.Controllers;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testController")
@Slf4j
public class BasicRestController {

    @GetMapping("/hello")
    @Timed(value = "greeting.time", description = "Time taken to return greeting")
    public ResponseEntity<?> helloWorld(){
        log.info("Hello World!!");
        System.out.println("Calling Add fn: " + add(5,3));
        return new ResponseEntity<>("Hello World!!", HttpStatus.OK);
    }

//    @Timed(value = "add.time", description = "Time taken to return addition")
    public int add(int a, int b){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a+b;
    }
}
