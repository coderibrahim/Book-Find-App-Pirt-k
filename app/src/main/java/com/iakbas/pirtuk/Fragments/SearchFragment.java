package com.iakbas.pirtuk.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iakbas.pirtuk.Api.BooksApi;
import com.iakbas.pirtuk.Model.Root;
import com.iakbas.pirtuk.R;
import com.iakbas.pirtuk.RecyclerView.RecyclerViewAdapter;
import com.iakbas.pirtuk.constant;

import android.content.Intent;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragment extends Fragment {


    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();


    RecyclerView recyclerView;
    SearchView editText;
    Button buttonSearchFragment;
    Root root;
    RecyclerViewAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        editText = view.findViewById(R.id.editTextHome);
        buttonSearchFragment = view.findViewById(R.id.buttonSearchFragment);
        recyclerView = view.findViewById(R.id.recyclerView);
        BooksApi booksApi= retrofit.create(BooksApi.class);
        root = new Root();


        buttonSearchFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editedQuery = editText.getQuery().toString();
                String query = editedQuery.replace(" " ,"+");
                Log.d("query",query);

                Call<Root> call2 = booksApi.getBooks(query);

                call2.enqueue(new Callback<Root>() {
                    @Override
                    public void onResponse(Call<Root> call, Response<Root> response) {

                        Root root = response.body();
                        adapter = new RecyclerViewAdapter(root,getActivity());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<Root> call, Throwable t) {

                    }
                });
            }
        });

        return view;
    }
}