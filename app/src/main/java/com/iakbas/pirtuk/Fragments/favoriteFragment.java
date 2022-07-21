package com.iakbas.pirtuk.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.iakbas.pirtuk.Dao.BookDatabase;
import com.iakbas.pirtuk.Entity.Book;
import com.iakbas.pirtuk.Model.Item;
import com.iakbas.pirtuk.R;
import com.iakbas.pirtuk.RecyclerView.RecyclerViewFavAdapter;

import java.util.ArrayList;
import java.util.List;


public class favoriteFragment extends Fragment {

    RecyclerView recyclerViewFavBook;
    RecyclerViewFavAdapter adapter;
    SwipeRefreshLayout refreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerViewFavBook = view.findViewById(R.id.recyclerViewFavBook);
        refreshLayout = view.findViewById(R.id.refreshLayout);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });



        recyclerViewFavBook.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerViewFavBook.setAdapter(adapter);

        return view;
    }

    void db(){



        BookDatabase database = BookDatabase.getDbInstance(getActivity());
        List<Book> bookList  = database.bookDatabase().getAllBooks();
        adapter = new RecyclerViewFavAdapter(bookList,getActivity());

    }
}