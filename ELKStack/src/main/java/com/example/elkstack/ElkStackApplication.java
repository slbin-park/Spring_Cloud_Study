package com.example.elkstack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
@Slf4j
public class ElkStackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElkStackApplication.class, args);
        log.error("==== Tasklet called....");

        for(int i = 0 ; i <100; i ++) {
            log.error("Hello Job Batch Log {}", i);
        }
    }

}
