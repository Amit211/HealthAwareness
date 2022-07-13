package com.example.healthawareness.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.healthawareness.R;

public class HouseholdServeyView extends AppCompatActivity {
    TextView survey_village,household_name,mobile_number,total_family_member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_survey);
        setTitle("Household Survey Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        survey_village=findViewById(R.id.survey_village);
        household_name=findViewById(R.id.household_name);
        mobile_number=findViewById(R.id.mobile_number);
        total_family_member=findViewById(R.id.total_family_member);

        survey_village.setText(getIntent().getStringExtra("village"));
        household_name.setText(getIntent().getStringExtra("name"));
        total_family_member.setText(getIntent().getStringExtra("total_member"));
    }


}