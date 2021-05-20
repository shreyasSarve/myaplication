package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.example.myapplication.First;
import com.example.myapplication.Second;
import com.example.myapplication.Third;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentManager fragmentManager,Lifecycle lifecycle)
    {
        super(fragmentManager, lifecycle);
    }


//    public  void addFragment(Fragment fragment,String title)
//    {
//
//    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 0:return new First();
            case 1:return new Second();
            case 2:return new Third();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}