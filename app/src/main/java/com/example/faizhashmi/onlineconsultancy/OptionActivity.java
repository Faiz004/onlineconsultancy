package com.example.faizhashmi.onlineconsultancy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OptionActivity extends AppCompatActivity {

   private RadioGroup radioGroup;
    Button submit;
    int status = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);

        submit = (Button)findViewById(R.id.btn_optionfilter_next);
        radioGroup = (RadioGroup)findViewById(R.id.radioOptionGroup);

        // Uncheck or reset the radio buttons initially
        radioGroup.clearCheck();

        // Add the Listener to the RadioGroup
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group,int checkedId)
                    {
                        RadioButton radioButton = (RadioButton)group.findViewById(checkedId);
                    }
                });

    }

    public void onRadioButtonClickedOptions(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str="";

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioUniversities:
                if(checked)
                    str = "Universities Selected";
                    status = 1;
                break;
            case R.id.radioCountries:
                if(checked)
                    str = "Countries Selected";
                    status = 2;
                break;
            case R.id.radioScholarships:
                if(checked)
                    str = "Scholarships Selected";
                    status = 3;

                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void onNextOptions (View v) {

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton)radioGroup.findViewById(selectedId);
                if (selectedId == -1) {
                    Toast.makeText(OptionActivity.this, "Please select any option to proceed",
                            Toast.LENGTH_SHORT).show();
                }
                else if (status == 1) {
                    Intent UniversityActivity=new Intent(getBaseContext(),UniversityActivity.class);
                    startActivity(UniversityActivity);
                }
                else if (status == 2) {
                    Intent CountryActivity=new Intent(getBaseContext(), CountryActivity.class);
                    startActivity(CountryActivity);
                }
                else if (status == 3) {
                    Intent ScholarshipActivity=new Intent(getBaseContext(),ScholarshipActivity.class);
                    startActivity(ScholarshipActivity);
                }

            }
        });



    }
}

