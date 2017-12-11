package com.au.example.client.rest;


import com.au.example.client.models.Person;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RestClientImpl implements RestClient {


    @Override
    public void createPerson(Person person) {
        WebClient webClient = WebClient.create("http://localhost:8080");
        Mono<Person> resp = webClient.post()
                .uri("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(person), Person.class)
                .retrieve()
                .bodyToMono(Person.class);

        resp.subscribe(person1 -> {
            System.out.println("response");

        });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test");

    }

    @Override
    public void getAllPerson() {

        WebClient webClient = WebClient.create("http://localhost:8080");
        Flux<Person> resp = webClient.get()

                .retrieve()
                .bodyToFlux(Person.class);
        resp.subscribe(person -> {
            System.out.println("response");
        });


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test");

    }


}
