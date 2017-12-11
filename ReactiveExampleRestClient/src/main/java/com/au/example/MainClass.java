package com.au.example;

import com.au.example.client.models.Person;
import com.au.example.client.rest.RestClient;
import com.au.example.client.rest.RestClientImpl;

public class MainClass {

    public static void main(String[] args) {
        RestClient restClient = new RestClientImpl();

        Person p = new Person("1","Ayhan");
        restClient.createPerson(p);

        restClient.getAllPerson();
        System.out.println("asd");
    }
}
