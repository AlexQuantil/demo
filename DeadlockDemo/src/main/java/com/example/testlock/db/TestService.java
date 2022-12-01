package com.example.testlock.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class TestService {

    @Autowired
    @Qualifier("fixedThreadPool")
    ExecutorService executorService;

    @Autowired
    DbService dbService;

    public void test(){
        // Start 3 threads at the same time run the testLock() method.
        for (int i = 0; i < 2; i++) {
            int threadId = i;
            executorService.submit(() -> {
                dbService.testLock2(threadId);
                System.out.println(String.format("Thread %s finished.", threadId));
            });
        }
    }

}
