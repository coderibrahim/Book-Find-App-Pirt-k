package com.iakbas.pirtuk.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iakbas.pirtuk.Api.BooksApi;
import com.iakbas.pirtuk.Model.Root;
import com.iakbas.pirtuk.R;
import com.iakbas.pirtuk.RecyclerView.RecyclerViewAdapter;
import com.iakbas.pirtuk.constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    RecyclerViewAdapter adapter;
    RecyclerView recyclerViewSearchActivity;
    Root root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerViewSearchActivity = findViewById(R.id.recyclerViewSearchActivity);

        BooksApi booksApi= retrofit.create(BooksApi.class);
        root = new Root();

        Bundle bundle = getIntent().getExtras();
        String editedQuery = bundle.getString("searchKeyword");
        String query = editedQuery.replace(" " ,"+");
        View parentLayout = findViewById(android.R.id.content);
        Call<Root> call2 = booksApi.getBooks(query);

        call2.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {

                root = response.body();
                if(root == null){
                    Snackbar.make(parentLayout.findViewById(android.R.id.content),"search is empty",Snackbar.LENGTH_LONG).show();
                }
                adapter = new RecyclerViewAdapter(root,getApplicationContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                recyclerViewSearchActivity.setLayoutManager(linearLayoutManager);
                recyclerViewSearchActivity.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }
}