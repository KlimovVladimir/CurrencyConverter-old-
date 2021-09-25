package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.currencyconverter.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;

    public static MainFragment mainFragment;
    public static FragmentTransaction fTrans;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        //listFragment = new ListFragment();
        mainFragment = new MainFragment();
        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.add(R.id.ListFragment, MainActivity.mainFragment);
        fTrans.commit();
    }
}