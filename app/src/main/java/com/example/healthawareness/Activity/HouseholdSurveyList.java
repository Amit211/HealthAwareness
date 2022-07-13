package com.example.healthawareness.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.healthawareness.Adaptor.HouseholdAdapter;
import com.example.healthawareness.DBMS.DatabaseSqlite;
import com.example.healthawareness.Model.SurveyModel;
import com.example.healthawareness.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HouseholdSurveyList extends AppCompatActivity {
    EditText list_search;
    FloatingActionButton addStakeholderSurvey;
   RecyclerView recycler_view_survey;
    Context context1 = this;
    ArrayList<SurveyModel> arrayList1=new ArrayList<>();
   HouseholdAdapter surveyAdaptor;
   DatabaseSqlite databaseSqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_recycler_view);
        setTitle("Household Survey List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler_view_survey=findViewById(R.id.recycler_view_survey) ;
        addStakeholderSurvey=findViewById(R.id.addStakeholderSurvey);
        list_search=findViewById(R.id.list_search);
        databaseSqlite=new DatabaseSqlite(getApplicationContext());

        arrayList1 = databaseSqlite.getSurveyModelData1();

        surveyAdaptor = new HouseholdAdapter(context1, arrayList1);
        recycler_view_survey.setHasFixedSize(true);
        recycler_view_survey.setLayoutManager(new LinearLayoutManager(this));
        recycler_view_survey.setAdapter(surveyAdaptor);


        addStakeholderSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HouseholdSurveyList.this, HouseholdServeyForm.class);
                startActivity(intent);
            }
        });

        list_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String search = list_search.getText().toString();
                arrayList1 = databaseSqlite.getSurveyFormList(search);
                HouseholdAdapter registerAdapter = new HouseholdAdapter(HouseholdSurveyList.this,arrayList1);
                int counter = arrayList1.size();
                //  FarmerCount.setText("Farmer 0"+counter);
                recycler_view_survey.setHasFixedSize(true);
                recycler_view_survey.setLayoutManager(new LinearLayoutManager(HouseholdSurveyList.this));
                recycler_view_survey.setAdapter(registerAdapter);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}