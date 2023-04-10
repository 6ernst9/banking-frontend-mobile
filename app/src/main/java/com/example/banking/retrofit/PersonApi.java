package com.example.banking.retrofit;

import com.example.banking.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PersonApi {

    @GET("/people")
    Call<List<Person>> getAllPersons();

    @POST("/people")
    Call<List<Person>>addPerson(@Body Person person);
}
