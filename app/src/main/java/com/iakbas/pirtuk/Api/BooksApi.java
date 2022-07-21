package com.iakbas.pirtuk.Api;

import com.iakbas.pirtuk.Model.Root;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksApi {


    @GET("books/v1/volumes?")
    Call<Root> getBooks(@Query("q") String keyword);
}
