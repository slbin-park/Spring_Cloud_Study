package com.example.elkstack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class HelloBatchConfig extends DefaultBatchConfiguration{


    @Bean
    public Job helloJob(final JobRepository jobRepository, final Step sendSmsStackStep) {
        return new JobBuilder("HelloJob", jobRepository)
                .start(sendSmsStackStep)
                .build();
    }

    @Bean
    public Step simpleStep1(JobRepository jobRepository, Tasklet testTasklet, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("HelloJobTaskletStep", jobRepository)
                .tasklet(testTasklet, platformTransactionManager).build();
    }

    @Bean
    public Tasklet testTasklet(){
        return ((contribution, chunkContext) -> {
            log.info("==== Tasklet called....");

            for(int i = 0 ; i <100; i ++) {
                log.info("Hello Job Batch Log ", i);
            }
            return RepeatStatus.FINISHED;
        });
    }
}