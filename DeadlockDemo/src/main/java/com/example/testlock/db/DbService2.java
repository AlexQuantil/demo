package com.example.testlock.db;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DbService2 {

    @Autowired
    DbRepo dbRepo;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertLock(int threadId) {
        System.out.println(String.format("Thread %s inner transaction.", threadId));
        dbRepo.insertIgnoreResourceLock(1, "test1");
    }



}
