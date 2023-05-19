package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Hello world!");
        //create a new person object
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Smith");  //If one field is null, it will be printed as null.
        person.setAge(30);
        person.setAddress("1 vista avenue");

        //serialize the person object into a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(person);
        System.out.println(jsonString);  //{"firstName":"John","lastName":"Smith","age":30}

        //deserialize the json string into an object
        Person newPerson = objectMapper.readValue(jsonString, Person.class);
        System.out.println(newPerson.getFirstName());
        System.out.println(newPerson.getLastName());
        System.out.println(newPerson.getAge());
        System.out.println(newPerson.getAddress());  //If a field is marked with JsonIgnore, the output here would be null instead of an exception.

    }
}