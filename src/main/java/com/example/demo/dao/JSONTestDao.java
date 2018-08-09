package com.example.demo.dao;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.JSONTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JSONTestDao extends JpaRepository<JSONTest,Long> {

    @Query(value = "select * from json_test as j where j.json @> '{\"id\":1}'::jsonb",nativeQuery = true)
    JSONTest findJsonBYid();

    @Query(value = "insert into json_test(json) values('{\"name\":\"名字\",\"id\":4,\"age\":56}')",nativeQuery = true)
    void insert(String json);
}
