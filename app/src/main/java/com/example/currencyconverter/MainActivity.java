package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toolbar;

import com.example.currencyconverter.fragments.MainFragment;
import com.example.currencyconverter.items.Currency;
import com.example.currencyconverter.items.CurrencyXmlParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "DEBUGGG";

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
        new Thread(new Runnable() {
            public void run() {
                try{
                    String content = download("http://www.cbr.ru/scripts/XML_daily.asp");
                    //usersList.post(new Runnable() {
                        //public void run() {
                            CurrencyXmlParser parser = new CurrencyXmlParser();
                            if(parser.parse(content))
                            {
                                ArrayAdapter<Currency> adapter = new ArrayAdapter(getBaseContext(),
                                        android.R.layout.simple_list_item_1, parser.getUsers());
                                //usersList.setAdapter(adapter);
                                //contentView.setText("Загруженно объектов: " + adapter.getCount());
                                Log.i(TAG, "Загруженно объектов: " + adapter.getCount());
                            }
                            else
                                Log.i(TAG, "kapec1");
                        //}
                   // });
                }
                catch (IOException ex){
                    Log.i(TAG, "kapec2");
                    //contentView.post(new Runnable() {
                        //public void run() {
                        //    contentView.setText("Ошибка: " + ex.getMessage());
                       // }
                    //});
                }
            }
        }).start();



        mainFragment = new MainFragment();
        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.add(R.id.ListFragment, MainActivity.mainFragment);
        fTrans.commit();
    }


    private String download(String urlPath) throws IOException {
        StringBuilder xmlResult = new StringBuilder();
        BufferedReader reader = null;
        InputStream stream = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlPath);
            connection = (HttpURLConnection) url.openConnection();
            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line=reader.readLine()) != null) {
                xmlResult.append(line);
            }
            return xmlResult.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}