package com.example.testlock;

import com.example.testlock.db.DbService;
import com.example.testlock.db.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class Runner implements CommandLineRunner {

    @Autowired
    private TestService testService;

    @Override
    public void run(String... args) throws Exception {
        testService.test();
        System.out.println("done!");

    }
}
