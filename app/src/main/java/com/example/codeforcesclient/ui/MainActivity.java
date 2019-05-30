package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.codeforcesclient.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private BottomNavigationView mBottomNavigationView;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation();
        if (null == savedInstanceState) {
            ContestFragment fragment = new ContestFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment);
        }
        showFragment(new ProblemFragment());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem aMenuItem) {
        switch (aMenuItem.getItemId()) {
        case R.id.action_contest:

            showFragment(new ContestFragment());
            break;
        case R.id.action_problemset:
            showFragment(new ProblemFragment());
            break;
        case R.id.action_rating:
            showFragment(new RatingFragment());
            break;
        case R.id.action_gym:
            showFragment(new GymContestsFragment());
            break;
        case R.id.action_menu:
            Toast.makeText(MainActivity.this, "Menu", Toast.LENGTH_SHORT).show();
            break;
        }
        return true;
    }

    public void showFragmentWithBackStack(Fragment aFragment) {
        mCurrentFragment = aFragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, mCurrentFragment)
                .addToBackStack(null)
                .commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    void showFragment(Fragment aFragment) {

        if (mCurrentFragment != null && mCurrentFragment.getClass() == aFragment.getClass()) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, aFragment)
                .commit();
        mCurrentFragment = aFragment;
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void setupBottomNavigation() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }
}
