package com.iakbas.pirtuk.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iakbas.pirtuk.Api.BooksApi;
import com.iakbas.pirtuk.Model.Root;
import com.iakbas.pirtuk.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookDetails extends AppCompatActivity {


    TextView textViewTitle ,textViewSubTitle, textViewAuthor,textViewDescription ;
    ImageView imageViewBook;

    Button goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewSubTitle = findViewById(R.id.textViewSubTitle);
        textViewAuthor = findViewById(R.id.textViewAuthor);
        textViewDescription = findViewById(R.id.textViewDescription);
        imageViewBook = findViewById(R.id.imageViewBook);

        Bundle bundle = getIntent().getExtras();
        String image = bundle.getString("image");
        String title = bundle.getString("title");
        String subTitle = bundle.getString("subTitle");
        String author = bundle.getString("author");
        String description = bundle.getString("description");
        String date = bundle.getString("date");


        textViewTitle.setText(title);
        textViewSubTitle.setText(subTitle);
        textViewAuthor.setText(author);
        textViewDescription.setText(description);

        Picasso.get()
                .load(image.toString())
                .resize(127, 198)
                .centerCrop()
                .into(imageViewBook);




    }
}