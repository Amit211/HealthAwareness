package com.example.healthawareness.Adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthawareness.Activity.HouseholdServeyView;
import com.example.healthawareness.Model.SurveyModel;
import com.example.healthawareness.R;

import java.util.ArrayList;

public class HouseholdAdapter extends RecyclerView.Adapter<HouseholdAdapter.ViewHolder>{
    Context context;
    ArrayList<SurveyModel> arrayList;

    public HouseholdAdapter(Context context, ArrayList<SurveyModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.household_custom, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.servey_village.setText(arrayList.get(position).getVilage());
        holder.servey_total_member.setText(arrayList.get(position).getTotal_member());
        holder.servey_person_name.setText(arrayList.get(position).getName());

        holder.servey_view_all_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, HouseholdServeyView.class);
                intent.putExtra("village",holder.servey_village.getText().toString().trim());
                intent.putExtra("total_member",holder.servey_total_member.getText().toString().trim());
                intent.putExtra("name",holder.servey_person_name.getText().toString().trim());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView servey_person_name,servey_village,servey_total_member,survey_symptoms;
       Button servey_view_all_details;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            servey_person_name=itemView.findViewById(R.id.servey_person_name);
            servey_village=itemView.findViewById(R.id.servey_village);
            servey_total_member=itemView.findViewById(R.id.servey_total_member);
            servey_view_all_details=itemView.findViewById(R.id.servey_view_all_details);
        }
    }
}
