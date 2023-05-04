package com.example.demotask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;

import com.example.demotask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        Fragment fragment1 = new LeftFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout1, fragment1).commit();


        Fragment fragment2 = new RightFragment();
        FragmentManager fragmentManager2 = getSupportFragmentManager();
        fragmentManager2.beginTransaction()
                .replace(R.id.frameLayout2, fragment2).commit();
    }




}