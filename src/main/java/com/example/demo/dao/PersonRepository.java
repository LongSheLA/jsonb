package com.example.demo.dao;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    @Query(value = "select * from person where info ->> 'name' = :name" , nativeQuery = true)
    List<Person> findByName(@Param("name")String name);
}
