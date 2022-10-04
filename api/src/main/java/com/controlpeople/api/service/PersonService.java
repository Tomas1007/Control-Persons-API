package com.controlpeople.api.service;

import com.controlpeople.api.entity.Person;
import com.controlpeople.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAll(){
        return personRepository.findAll();
    }
    public Person findById(Integer personId){
        return personRepository.findById(personId).get();
    }

    public void save (Person person){
        personRepository.save(person);
    }

    public void deleteById(Integer personId){
        personRepository.deleteById(personId);
    }

}