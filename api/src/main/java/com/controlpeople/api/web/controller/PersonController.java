package com.controlpeople.api.web.controller;


import com.controlpeople.api.entity.Person;
import com.controlpeople.api.service.PersonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    @ApiOperation("Get all persons")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @GetMapping("/person/{personId}")
    @ApiOperation("Get person by id")
    public ResponseEntity<Person> findById(@PathVariable Integer personId) {
        try {
            return new ResponseEntity<>(personService.findById(personId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @ApiOperation("Save person")
    public void savePerson(@RequestBody Person person){
       personService.save(person);
    }

    @DeleteMapping("/person/{personId}")
    @ApiOperation("Delete person by id")
    public void delete(@PathVariable Integer personId){
        personService.deleteById(personId);
    }

    @PutMapping("/person/{personId}")
    @ApiOperation("Update person by id")
    public ResponseEntity<?> updatePerson(@RequestBody Person person, @PathVariable Integer personId) {
        try {
            Person personUpd = personService.findById(personId);
            personUpd.setName(person.getName());
            personUpd.setLastname(person.getLastname());
            personUpd.setPhone(person.getPhone());
            personUpd.setDate(person.getDate());
            personUpd.setAmount(person.getAmount());
            personService.save(personUpd);
            return new ResponseEntity<Person>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    }