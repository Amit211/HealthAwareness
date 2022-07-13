package com.example.healthawareness.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthawareness.Adaptor.SuspectedHouseholdSurvey;
import com.example.healthawareness.DBMS.DatabaseSqlite;
import com.example.healthawareness.Model.SurveyModel;
import com.example.healthawareness.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
public class SuspectedHousehold extends AppCompatActivity {
    FloatingActionButton addStakeholderSurvey;
    RecyclerView recycler_view_survey;
    Context context1 = this;
    ArrayList<SurveyModel> arrayList1=new ArrayList<>();
    SuspectedHouseholdSurvey surveyAdaptor;
    DatabaseSqlite databaseSqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspected_household);
        setTitle("Suspected Household List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_view_survey=findViewById(R.id.recycler_view_survey) ;
        addStakeholderSurvey=findViewById(R.id.addStakeholderSurvey);

        databaseSqlite=new DatabaseSqlite(getApplicationContext());

        arrayList1 = databaseSqlite.getSurveyModelData1();
        surveyAdaptor = new SuspectedHouseholdSurvey(context1,arrayList1);
        recycler_view_survey.setHasFixedSize(true);
        recycler_view_survey.setLayoutManager(new LinearLayoutManager(this));
        recycler_view_survey.setAdapter(surveyAdaptor);

        addStakeholderSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SuspectedHousehold.this, HouseholdServeyForm.class);
                startActivity(intent);
            }
        });
    }
}