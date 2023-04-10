package com.example.banking.retrofit;

import com.example.banking.model.Account;
import com.example.banking.model.AccountRequest;
import com.example.banking.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountApi {
    @GET("/accounts")
    Call<List<Account>> getAllAccounts();

    @POST("/accounts")
    Call<List<Account>>addAccount(@Body AccountRequest account);
}
