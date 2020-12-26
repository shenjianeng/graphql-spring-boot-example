package com.example._03_.resolver;

import com.example._03_.pojo.Teacher;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author shenjianeng
 * @date 2020/12/19
 */
@Slf4j
@Component
public class TeacherGraphQLQueryResolver implements GraphQLQueryResolver {

    private final ExecutorService executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @PreDestroy
    public void destroy() {
        executor.shutdown();
    }

    public CompletableFuture<Collection<Teacher>> getTeachers() {
        log.info("start getTeachers...");
        CompletableFuture<Collection<Teacher>> future = CompletableFuture.supplyAsync(() -> {
            log.info("invoke getTeachers...");
            sleep();
            Teacher teacher = new Teacher();
            teacher.setId(666);
            teacher.setName("coder小黑");
            teacher.setAge(17);
            return Collections.singletonList(teacher);
        }, executor);

        log.info("end getTeachers...");
        return future;
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
