package com.iakbas.pirtuk.RecyclerView;

import static com.google.android.material.snackbar.Snackbar.make;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iakbas.pirtuk.Activities.BookDetails;
import com.iakbas.pirtuk.Dao.BookDatabase;
import com.iakbas.pirtuk.Entity.Book;
import com.iakbas.pirtuk.Model.Item;
import com.iakbas.pirtuk.Model.Root;
import com.iakbas.pirtuk.R;
import com.squareup.picasso.Picasso;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    Root root;
    Context context;
    int lastPosition = -1;


    public RecyclerViewAdapter(Root root, Context context) {
        this.root = root;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String imageValid = imageIsEmpty(position,holder);
        boolean dateValid = publishedDateIsEmpty(position,holder);
        if (holder.getAdapterPosition() > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_row);
            holder.itemView.startAnimation(animation);
            lastPosition = holder.getAdapterPosition();
        }
        holder.cardViewSeeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), BookDetails.class);
                intent.putExtra("image",imageValid);
                intent.putExtra("title",root.getItems().get(position).getVolumeInfo().getTitle());
                intent.putExtra("subTitle",root.getItems().get(position).getVolumeInfo().getSubtitle());
                intent.putExtra("author",root.getItems().get(position).getVolumeInfo().getAuthors().get(0));
                intent.putExtra("description",root.getItems().get(position).getVolumeInfo().getDescription());
                if (dateValid)
                    intent.putExtra("date",root.getItems().get(position).getVolumeInfo().getPublishedDate());
                else
                    intent.putExtra("date","");

                holder.itemView.getContext().startActivity(intent);

            }
        });



        holder.bookTitle.setText(root.getItems().get(position).getVolumeInfo().getTitle());
        holder.bookDescription.setText(root.getItems().get(position).getVolumeInfo().getDescription());
        if(root.getItems().get(position).getVolumeInfo().getAuthors() != null)
            holder.bookAuthor.setText(root.getItems().get(position).getVolumeInfo().getAuthors().get(0));
        else
            holder.bookAuthor.setText("Yazar Bulunamadı");


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item itemSaved = root.getItems().get(position);
                saveBook(itemSaved.getVolumeInfo().getTitle(),
                        itemSaved.getVolumeInfo().getSubtitle(),
                        imageValid,itemSaved.getVolumeInfo().getAuthors().get(0),
                        itemSaved.getVolumeInfo().getDescription());

            }
        });

    }

    @Override
    public int getItemCount() {
        return root.getItems().size();
    }



    private void saveBook(String title, String subTitle , String image ,String author , String description){
        BookDatabase db = BookDatabase.getDbInstance(context);

        Book book2 = new Book();
        book2.bookTitle = title;
        book2.bookSubTitle = subTitle;
        book2.bookImage = image;
        book2.bookAuthor = author;
        book2.description = description;

        db.bookDatabase().createBook(book2);
    }
































    public String imageIsEmpty(int position , RecyclerViewHolder holder){

        if (root.getItems().get(position).getVolumeInfo().getImageLinks() != null){
            String imageUrl = root.getItems().get(position).getVolumeInfo().getImageLinks().getSmallThumbnail();
            String replacedImageUrl = imageUrl.replace("http","https");
            Picasso.get()
                    .load(replacedImageUrl)
                    .resize(127, 198)
                    .centerCrop()
                    .into(holder.bookImageView);
            return replacedImageUrl;
        } else {
            Picasso.get()
                    .load("https://picsum.photos/50")
                    .resize(50, 50)
                    .centerCrop()
                    .into(holder.bookImageView);
            return "https://picsum.photos/50";
        }
    }

    public boolean publishedDateIsEmpty(int position , RecyclerViewHolder holder){
        String date = root.getItems().get(position).getVolumeInfo().getPublishedDate();
        if (date != null){

            holder.textViewDate.setText(date);
            return true;
        }
        else{

            holder.textViewDate.setText("");
            return false;
        }
    }

}
