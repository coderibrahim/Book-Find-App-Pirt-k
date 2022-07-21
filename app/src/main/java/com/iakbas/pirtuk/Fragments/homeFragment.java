package com.iakbas.pirtuk.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.iakbas.pirtuk.Activities.BlogActivity;
import com.iakbas.pirtuk.Activities.SearchActivity;
import com.iakbas.pirtuk.Model.Root;
import com.iakbas.pirtuk.R;


public class homeFragment extends Fragment {


    Root root;

    SearchView editTextHome;
    Button buttonSearchHome;

    Button buttonMagazine, buttonAdventure , buttonRomance , buttonThriller , buttonFantasy , buttonHistorical;

    CardView cardViewWhat , cardViewEnjoy , cardViewBests;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        cardViewWhat = view.findViewById(R.id.cardViewWhat);
        cardViewEnjoy = view.findViewById(R.id.cardViewEnjoy);
        cardViewBests = view.findViewById(R.id.cardViewBests);
        buttonMagazine = view.findViewById(R.id.buttonMagazine);
        buttonAdventure = view.findViewById(R.id.buttonAdventure);
        buttonRomance = view.findViewById(R.id.buttonRomance);
        buttonThriller = view.findViewById(R.id.buttonThriller);
        buttonFantasy = view.findViewById(R.id.buttonFantasy);
        buttonHistorical = view.findViewById(R.id.buttonHistorical);

        editTextHome = view.findViewById(R.id.editTextHome);
        buttonSearchHome = view.findViewById(R.id.buttonSearchHome);

        buttonSearchHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = editTextHome.getQuery().toString();
                if (key.equals("")){
                    Snackbar.make(getActivity().findViewById(android.R.id.content),"search cannot be empty",Snackbar.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    intent.putExtra("searchKeyword",key);
                    startActivity(intent);
                }
            }
        });


        blogSearch();
        bookSearch();



        return view;
    }


    public void blogSearch(){

        cardViewWhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BlogActivity.class);
                intent.putExtra("url","https://en.wikipedia.org/wiki/Book#:~:text=A%20book%20is%20a%20medium,codex%20(plural%2C%20codices).");
                startActivity(intent);
            }
        });

        cardViewBests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),BlogActivity.class);
                intent.putExtra("url","https://www.whichbook.net/mood-emotion/");
                startActivity(intent);
            }
        });

        cardViewEnjoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),BlogActivity.class);
                intent.putExtra("url","https://cultivatewhatmatters.com/blogs/cwm/how-to-enjoy-reading");
                startActivity(intent);
            }
        });

    }


    public void bookSearch(){

        buttonMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                intent.putExtra("searchKeyword","Magazines");
                startActivity(intent);
            }
        });

        buttonAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                intent.putExtra("searchKeyword","Adventure");
                startActivity(intent);
            }
        });

        buttonThriller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                intent.putExtra("searchKeyword","Thriller");
                startActivity(intent);
            }
        });

        buttonRomance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                intent.putExtra("searchKeyword","Romance");
                startActivity(intent);
            }
        });

        buttonFantasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                intent.putExtra("searchKeyword","Fantasy");
                startActivity(intent);
            }
        });

        buttonHistorical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                intent.putExtra("searchKeyword","Historical");
                startActivity(intent);
            }
        });

    }
}