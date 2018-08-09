package com.example.demo.Servcie;

import com.example.demo.dao.JSONTestDao;
import com.example.demo.dao.PersonRepository;
import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServcie {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person) throws Exception{
       return personRepository.save(person);

    }

    public List<Person> findByName(String name){
        return personRepository.findByName(name);
    }
}
