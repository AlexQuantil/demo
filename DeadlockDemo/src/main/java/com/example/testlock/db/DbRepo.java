package com.example.testlock.db;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository
public interface DbRepo extends CrudRepository<TestLock, Integer> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    TestLock findByIdAndType(int id, String type);

    @Modifying
    @Query(value = "insert ignore into test_lock(id, type) values (?1, ?2)", nativeQuery = true)
    void insertIgnoreResourceLock(int id, String type);

}
