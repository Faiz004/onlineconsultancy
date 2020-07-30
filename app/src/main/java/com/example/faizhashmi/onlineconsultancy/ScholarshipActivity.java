package com.example.faizhashmi.onlineconsultancy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ScholarshipActivity extends AppCompatActivity {

    private ListView lv;

    ArrayAdapter<String> adapter;

    EditText inputSearch;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scholarship_activity);

        // Listview Data
        String Scholarships[] = { "DAAD Scholarship in Germany For Masters", "Finland Government Scholarship 2020", "Khalifa University Scholarship",
                "University of Canterbury Scholarship 2020", "ICDF Taiwan Scholarship 2020", "AIT Scholarship in Thailand 2020", "Bangchak Master Scholarships",
                "Australian Government Research Training Program 2020 Scholarships", "Cambridge University Scholarship UK", "Islamic Development Bank Scholarship",
                "Azerbaijan Scholarship Program", "CAS-TWAS Scholarship in China", "King Abdullah University Scholarship", "Sweden Government Scholarship", "University of Tokyo Summer Internship"};

        lv = (ListView) findViewById(R.id.ScholarshipListview);
        inputSearch = (EditText) findViewById(R.id.inputScholarshipSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item_scholarship, R.id.scholarship_name, Scholarships);
        lv.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                ScholarshipActivity.this.adapter.getFilter().filter(cs);
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
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3)
            {
                String value = (String)adapter.getItemAtPosition(position);
                System.out.print(value);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

                if (value.equals("DAAD Scholarship in Germany For Masters")) {

                    Intent ScholarActivity=new Intent(getBaseContext(),ScholarActivity.class);
                    startActivity(ScholarActivity);
                }
            }
        });
    }
}
