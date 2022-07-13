package com.example.healthawareness.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.healthawareness.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashBoard extends AppCompatActivity {
    LinearLayout ll_household,ll_suspected_household,synch_household;
    TextView tv_new_servey;
    Spinner spn_village;
    String[] villageArr = {"Select Village", "Motnaje", "Banka", "Ladania"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diskboard);
        setTitle("Dashboard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intializaation();
        getVillage();


        ll_household.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), HouseholdSurveyList.class);
                startActivity(intent);
            }
        });
        ll_suspected_household.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), SuspectedHousehold.class);
                startActivity(intent);
            }
        });

        synch_household.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), SynchronizeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void intializaation() {
        spn_village=findViewById(R.id.spn_village);
        ll_household=findViewById(R.id.ll_household);
        ll_suspected_household=findViewById(R.id.ll_suspected_household);
        synch_household=findViewById(R.id.synch_household);
    }
    private void getVillage() {
        ArrayAdapter<String> gender_aArrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,villageArr);
        gender_aArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_village.setAdapter(gender_aArrayAdapter);
        spn_village.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position!=0)
                {
                    spn_village.getSelectedItem().toString().trim();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

}