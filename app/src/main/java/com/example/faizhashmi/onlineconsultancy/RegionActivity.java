package com.example.faizhashmi.onlineconsultancy;

import android.graphics.Region;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class RegionActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    Button regionnext;
    int status=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region_activity);

        regionnext = (Button)findViewById(R.id.btn_regionfilter_next);
        radioGroup = (RadioGroup)findViewById(R.id.radioRegion);
        // Uncheck or reset the radio buttons initially

        radioGroup.clearCheck();
    }

    public void onRadioButtonClickedRegions(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str="";

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioAll:
                if(checked)
                    str = "All Regions Selected";
                status = 1;
                break;
            case R.id.radioAsia:
                if(checked)
                    str = "Asia Selected";
                status = 2;
                break;
            case R.id.radioEurope:
                if(checked)
                    str = "Europe Selected";
                status = 3;
                break;
            case R.id.radioAfrica:
                if(checked)
                    str = "Africa Selected";
                status = 4;
                break;
            case R.id.radioNorthAmerica:
                if(checked)
                    str = "North America Selected";
                status = 5;
                break;

        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void onNextRegion (View v) {

        regionnext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton)radioGroup.findViewById(selectedId);
                if (selectedId == -1) {
                    Toast.makeText(RegionActivity.this, "Please select any option to proceed",
                            Toast.LENGTH_SHORT).show();
                }
                else if (status == 1) {
                    Intent OptionActivity=new Intent(getBaseContext(),OptionActivity.class);
                    startActivity(OptionActivity);
                }
                else if (status == 2) {
                    Intent OptionActivity=new Intent(getBaseContext(),OptionActivity.class);
                    startActivity(OptionActivity);
                }
                else if (status == 3) {
                    Intent OptionActivity=new Intent(getBaseContext(),OptionActivity.class);
                    startActivity(OptionActivity);
                }
                else if (status == 4) {
                    Intent OptionActivity=new Intent(getBaseContext(),OptionActivity.class);
                    startActivity(OptionActivity);
                }
                else if (status == 5) {
                    Intent OptionActivity=new Intent(getBaseContext(),OptionActivity.class);
                    startActivity(OptionActivity);
                }

                else
                {
                }
            }
        });


    }
}
