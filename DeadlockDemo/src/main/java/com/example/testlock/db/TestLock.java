package com.example.testlock.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "test_lock")
public class TestLock {

    @Id
    int id;

    String type;

}
