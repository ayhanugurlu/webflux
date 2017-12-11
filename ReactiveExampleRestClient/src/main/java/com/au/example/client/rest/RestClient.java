package com.au.example.client.rest;

import com.au.example.client.models.Person;

public interface RestClient {

    void createPerson(Person person);

    void getAllPerson();

}
