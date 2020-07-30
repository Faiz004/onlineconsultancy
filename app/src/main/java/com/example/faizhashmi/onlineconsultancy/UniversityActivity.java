package com.example.faizhashmi.onlineconsultancy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class UniversityActivity extends AppCompatActivity {

    private ListView lv;

    ArrayAdapter<String> adapter;

    EditText inputSearch;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.university_activity);

        // Listview Data
        String Universities[] = {
                "Harward University", "Stanford University",
                "University of Toronto", "University of Alberta",
                "Carleton University", "University of Thailand",
                "University of Bankok", "National University of Sweden",
                "University of Calgary", "The University of Sydney",
                "The University of Melbourne", "Monash University",
                "Moscow State University", "Univerity of Pisa",
                "The University of Paris"
                };

        String UniversitiesA[] = { "Harward University", "Stanford University" };

        lv = (ListView) findViewById(R.id.UniversityListview);
        inputSearch = (EditText) findViewById(R.id.inputUniversitySearch);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item_university, R.id.university_name, Universities);
        lv.setAdapter(adapter);

        String value = getIntent().getStringExtra("value");

        if (value.isEmpty()) {
            // Adding items to listview
            adapter = new ArrayAdapter<String>(this, R.layout.list_item_university, R.id.university_name, Universities);
            lv.setAdapter(adapter);
        }
        else if (value.equals("America")){
            adapter = new ArrayAdapter<String>(this, R.layout.list_item_university, R.id.university_name, UniversitiesA);
            lv.setAdapter(adapter);

        }


        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text

                UniversityActivity.this.adapter.getFilter().filter(cs);

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

                if (value.equals("Stanford University")) {

                    Intent UniActivity=new Intent(getBaseContext(),UniActivity.class);
                    startActivity(UniActivity);
                }
                else if (value.equals("Harward University")) {

                Intent UniiActivity=new Intent(getBaseContext(),UniiActivity.class);
                startActivity(UniiActivity);
            }
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
            }
        });

        Switch onOffSwitch = (Switch)  findViewById(R.id.uniSwitchfilter);
        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                {
                    Toast.makeText(UniversityActivity.this, "Scholarship Filter is Enabled" ,
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(UniversityActivity.this, "Scholarship Filter is Disabled" ,
                            Toast.LENGTH_SHORT).show();
                }

            }

        });

    }



}