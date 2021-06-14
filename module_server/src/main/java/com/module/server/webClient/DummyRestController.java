package com.module.server.webClient;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DummyRestController {

    /*
        https://www.youtube.com/watch?v=1q6knZa9WLM&t=58s
     */
    Person person = new Person();

    @GetMapping("/person/{id}")
    public Person getPerson_Server(@PathVariable int id) {
        simulateDelayedProcessing();
        return person.getPerson(id);
    }


    @GetMapping("/people")
    public List<Person> getPeople_Server() {
        simulateDelayedProcessing();
        return person.getAllPeople();
    }

    @PostMapping("/person")
    public Person addPerson_Server(@RequestBody Person p1){
        simulateDelayedProcessing();
        return person.addPerson(p1);
    }

    @GetMapping("/awesome/{name}")
    public String awesome(@PathVariable String name) {
        return "This is awesome "+ name;
    }

    //Just to simulate a delay
    void simulateDelayedProcessing() {
        try {
            Thread.sleep(5000); //5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
