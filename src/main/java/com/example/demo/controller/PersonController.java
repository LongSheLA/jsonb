package com.example.demo.controller;

import com.example.demo.Servcie.PersonServcie;
import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonServcie personServcie;


    @GetMapping("/savePerson")
    public ResponseEntity<?> savePerson(){
        Person save = null;
        try {
            Person p = new Person();
            Map m = new HashMap();
            m.put("name","汪云飞");
            m.put("age",11);
            p.setInfo(m);
            save = personServcie.save(p);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam("name") String name){
        List<Person>  personList= null;
        try {
            personList = personServcie.findByName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(personList == null){
            personList.add(new Person());
        }
        return ResponseEntity.status(HttpStatus.OK).body(personList);
    }


}
