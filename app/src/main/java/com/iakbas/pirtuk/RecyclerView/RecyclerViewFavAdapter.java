package com.iakbas.pirtuk.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iakbas.pirtuk.Entity.Book;
import com.iakbas.pirtuk.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFavAdapter  extends RecyclerView.Adapter<RecyclerViewFavViewHolder>{

    List<Book> bookList;
    Context context;
    int lastPosition = -1;


    public RecyclerViewFavAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fav_list_row,parent,false);
        RecyclerViewFavViewHolder holder = new RecyclerViewFavViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewFavViewHolder holder, int position) {
        if (holder.getAdapterPosition() > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_row);
            holder.itemView.startAnimation(animation);
            lastPosition = holder.getAdapterPosition();
        }
        holder.cardViewFav.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ProcessBuilder pb= new ProcessBuilder();

                return false;
            }
        });
        Picasso.get().load(bookList.get(position).getBookImage().toString()).resize(197,128).centerCrop().into(holder.bookFavoriteImage);
        holder.bookFavTitle.setText(bookList.get(position).getBookTitle());
        holder.bookFavSubTitle.setText(bookList.get(position).getBookSubTitle());
        holder.bookFavoriteDescription.setText(bookList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
