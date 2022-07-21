package com.iakbas.pirtuk.Activities;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.iakbas.pirtuk.R;
import com.iakbas.pirtuk.Fragments.SearchFragment;
import com.iakbas.pirtuk.Fragments.favoriteFragment;
import com.iakbas.pirtuk.Fragments.homeFragment;

import java.util.ArrayList;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    ViewPager2 viewPager2;
    AnimatedBottomBar bottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.viewPager2);
        bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setupWithViewPager2(viewPager2);

        fragmentList.add(new homeFragment());
        fragmentList.add(new SearchFragment());
        fragmentList.add(new favoriteFragment());



        ViewPageAdapter adapter = new ViewPageAdapter(this);
        viewPager2.setAdapter(adapter);

    }


    public class ViewPageAdapter extends FragmentStateAdapter {


        public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentList.size();
        }
    }

}