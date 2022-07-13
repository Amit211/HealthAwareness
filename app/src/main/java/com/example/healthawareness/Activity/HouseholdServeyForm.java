package com.example.healthawareness.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.healthawareness.DBMS.DatabaseSqlite;
import com.example.healthawareness.Model.SurveyModel;
import com.example.healthawareness.R;

public class HouseholdServeyForm extends AppCompatActivity {
    com.google.android.material.button.MaterialButton btn_submit;
    CheckBox coughing_boold,Cough_that_lasts_three,weakness_fatigue,night_sweat,chest_pain,weight_loss,loss_appetite,child_fever;
    String mVillage="",symptom_coughing="" ,symptom_cough_last_three_weak="";
    Spinner spn_village;
    EditText helth_householder,helth_mobile_number,helth_fimally_member;
    DatabaseSqlite databaseSqlite;
    SurveyModel surveyModel;
    String[] villageArr = {"Select Village", "Motnaje", "Banka", "Ladania"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_form);

        initialization();
        setTitle("Household Survey");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        databaseSqlite=new DatabaseSqlite(getApplicationContext());
        getVillage();
        getCheckBox();
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkValidation()) {

                    surveyModel = new SurveyModel();
                    surveyModel.setVilage(mVillage);
                    surveyModel.setMobile_number(helth_mobile_number.getText().toString().trim());
                    surveyModel.setName(helth_householder.getText().toString().trim());
                    surveyModel.setTotal_member(helth_fimally_member.getText().toString().trim());

                    surveyModel.setCoughing_blood(symptom_coughing);
                    surveyModel.setCough_that_lasts_three(symptom_cough_last_three_weak);

                    if (databaseSqlite.saveServeyTotalData(surveyModel) > 0) {
                        Toast.makeText(HouseholdServeyForm.this, "insert successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HouseholdServeyForm.this, DashBoard.class);
                        startActivity(intent);
                    } else
                        Toast.makeText(HouseholdServeyForm.this, "Do Not inset data into table", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getCheckBox() {
        coughing_boold.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                symptom_coughing = "Coughing with blood";
            } else {
                symptom_coughing = "";
            }
        });

        Cough_that_lasts_three.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                symptom_cough_last_three_weak = "Cough that lasts three weeks or longer";
            } else {
                symptom_cough_last_three_weak = "";
            }
        });

    }

    private boolean checkValidation() {

        if(helth_householder.getText().toString().trim().length()==0){
            helth_householder.setError("please enter name");
            helth_householder.requestFocus();
            return false;
        }
        if(helth_mobile_number.getText().toString().trim().length()==0){
            helth_mobile_number.setError("please enter contact number");
            helth_mobile_number.requestFocus();
            return false;
        }
        if(helth_fimally_member.getText().toString().trim().length()==0){
            helth_fimally_member.setError("please enter family member");
            helth_fimally_member.requestFocus();
            return false;
        }
        return true;
    }

    private void initialization() {
        spn_village=findViewById(R.id.spn_village);
        btn_submit=findViewById(R.id.btn_submit);
        helth_mobile_number=findViewById(R.id.helth_mobile_number);
        helth_householder=findViewById(R.id.helth_householder_name);
        helth_fimally_member=findViewById(R.id.helth_fimally_member);

        coughing_boold=findViewById(R.id.coughing_boold);
        Cough_that_lasts_three=findViewById(R.id.Cough_that_lasts_three);
        weakness_fatigue=findViewById(R.id.weakness_fatigue);
        night_sweat=findViewById(R.id.night_sweat);
        chest_pain=findViewById(R.id.chest_pain);
        weight_loss=findViewById(R.id.weight_loss);
        loss_appetite=findViewById(R.id.loss_appetite);

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
                    mVillage=spn_village.getSelectedItem().toString().trim();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }
}