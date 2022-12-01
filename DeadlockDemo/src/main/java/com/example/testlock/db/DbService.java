package com.example.testlock.db;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DbService {

    @Autowired
    DbRepo dbRepo;

    @Autowired
    DbService2 dbService2;

//    @SneakyThrows
//    @Transactional
//    public void testLock(int threadId) {
//        System.out.println(String.format("Thread %s outside transaction.", threadId));
//        dbService2.insertLock(threadId);
//        // Do some MongoDB jobs takes 1-2 seconds
//        Thread.sleep(2000L);
//        dbRepo.findByIdAndType(1, "test1");
//    }

    /**
     * Deadlock
     * @param threadId
     */
    @SneakyThrows
    @Transactional
    public void testLock2(int threadId) {
        System.out.println(String.format("Thread %s outside transaction.", threadId));
        dbRepo.insertIgnoreResourceLock(1, "test1");
        // Do some MongoDB jobs takes 1-2 seconds
        Thread.sleep(2000L);
        dbRepo.findByIdAndType(1, "test1");
    }



}
