package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.codeforcesclient.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem aMenuItem) {
        switch (aMenuItem.getItemId()) {
        case R.id.action_contest:
            Toast.makeText(MainActivity.this, "Contests", Toast.LENGTH_SHORT).show();
            break;
        case R.id.action_problemset:
            Toast.makeText(MainActivity.this, "Problemsets", Toast.LENGTH_SHORT).show();
            break;
        case R.id.action_rating:
            Toast.makeText(MainActivity.this, "Rating", Toast.LENGTH_SHORT).show();
            break;
        }
        return true;
    }
}
