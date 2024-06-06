package com.razawiyah.nytimesarticles.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.razawiyah.nytimesarticles.fragments.MostEmailedFragment;
import com.razawiyah.nytimesarticles.fragments.MostViewedFragment;
import com.razawiyah.nytimesarticles.fragments.MostSharedFragment;
import com.razawiyah.nytimesarticles.fragments.SearchFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new MostViewedFragment();
            case 1: return new MostSharedFragment();
            case 2: return new MostEmailedFragment();
            case 3: return new SearchFragment();
            default: return new MostViewedFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
