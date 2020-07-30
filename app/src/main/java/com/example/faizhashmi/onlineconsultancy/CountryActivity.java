package com.example.faizhashmi.onlineconsultancy;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class CountryActivity extends AppCompatActivity {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_activity);

        // Listview Data
        String Countries[] = { "America", "Australia", "Canada", "London", "China", "Thailand",
                "Bankok", "Sweden",
                "Norway", "Italy", "Spain", "France", "Russia", "Paris", "Japan"};

        lv = (ListView) findViewById(R.id.CountryListview);
        inputSearch = (EditText) findViewById(R.id.inputCountrySearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item_country, R.id.country_name, Countries);
        lv.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                CountryActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                String value = (String)adapter.getItemAtPosition(position);

                System.out.print(value);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                Intent UniversityActivity=new Intent(getBaseContext(),UniversityActivity.class);
                UniversityActivity.putExtra("value", value);
                startActivity(UniversityActivity);

            }
        });

    }




}