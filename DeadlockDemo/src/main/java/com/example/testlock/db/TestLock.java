package com.example.testlock.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class TestLock {

    @Id
    int id;

    String type;

}
