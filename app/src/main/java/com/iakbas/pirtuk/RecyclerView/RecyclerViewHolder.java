package com.iakbas.pirtuk.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.iakbas.pirtuk.R;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView bookImageView , imageView;
    TextView bookTitle , bookDescription , bookAuthor , textViewDate ;
    CardView cardViewSeeDetails;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        bookImageView = itemView.findViewById(R.id.bookImageView);
        bookTitle = itemView.findViewById(R.id.bookTitle);
        bookDescription = itemView.findViewById(R.id.bookDescription);
        bookAuthor = itemView.findViewById(R.id.bookAuthor);
        textViewDate = itemView.findViewById(R.id.textViewDate);
        cardViewSeeDetails = itemView.findViewById(R.id.cardViewSeeDetails);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
