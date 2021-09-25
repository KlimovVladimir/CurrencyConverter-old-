package com.example.currencyconverter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.currencyconverter.MainActivity;
import com.example.currencyconverter.R;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //MainActivity.getInstance().setTitle(film.getLocalizedName());
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               // MainActivity.fTrans = MainActivity.getInstance().getSupportFragmentManager().beginTransaction();
                //MainActivity.fTrans.replace(R.id.ListFragment, MainActivity.listFragment);
               // MainActivity.fTrans.addToBackStack(null);
               // MainActivity.fTrans.commit();
        }
        return super.onOptionsItemSelected(item);
    }
}