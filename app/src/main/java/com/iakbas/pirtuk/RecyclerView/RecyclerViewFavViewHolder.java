package com.iakbas.pirtuk.RecyclerView;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.iakbas.pirtuk.R;

public class RecyclerViewFavViewHolder extends RecyclerViewHolder{

    TextView bookFavTitle , bookFavSubTitle ,bookFavoriteDescription;
    CardView cardViewFav;
    ImageView bookFavoriteImage;


    public RecyclerViewFavViewHolder(@NonNull View itemView) {
        super(itemView);
        bookFavTitle = itemView.findViewById(R.id.bookFavTitle);
        bookFavSubTitle = itemView.findViewById(R.id.bookFavSubTitle);
        bookFavoriteDescription = itemView.findViewById(R.id.bookFavoriteDescription);
        cardViewFav = itemView.findViewById(R.id.cardViewFav);
        bookFavoriteImage = itemView.findViewById(R.id.bookFavoriteImage);

    }
}
