package com.example.healthawareness.DBMS;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.example.healthawareness.Model.SurveyModel;

import java.util.ArrayList;

public class DatabaseSqlite extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "helth.db";
    static final int DATABASE_VERSION = 1;
    String DB_PATH_SUFFIX = "/databases/";
    int version;
    Context ctx;

    public DatabaseSqlite(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     sqLiteDatabase.execSQL(SurveyModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    //Insert Data Into table
    public long saveServeyTotalData(SurveyModel surveyModel){
        SQLiteDatabase db=this.getWritableDatabase();
        long ids=0;
        try{
            if(db!=null&&!db.isReadOnly())
            {
                ContentValues contentValues=new ContentValues();

                contentValues.put("village",surveyModel.getVilage());
                contentValues.put("name",surveyModel.getName());
                contentValues.put("mobile_number",surveyModel.getMobile_number());
                contentValues.put("total_member",surveyModel.getTotal_member());
                contentValues.put("coughing_blood",surveyModel.getCoughing_blood());
                contentValues.put("Cough_that_lasts_three",surveyModel.getCough_that_lasts_three());

                ids=db.insert("survey",null,contentValues);
                db.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
            db.close();
        }
        return ids;
    }


    //Get Data into table used this methods

    @SuppressLint("Range")
    public ArrayList<SurveyModel> getSurveyModelData1()
    {
        ArrayList<SurveyModel> surveyTableArrayList1= new ArrayList<>();
        SQLiteDatabase db1 = this.getWritableDatabase();
        try
        {
            if (db1 != null && db1.isOpen() && !db1.isReadOnly())
            {
                String query = "select * from survey ";

                @SuppressLint("Recycle") Cursor cursor1 = db1.rawQuery(query, null);
                if (cursor1 != null && cursor1.getCount() > 0)
                {
                    cursor1.moveToFirst();
                    while (!cursor1.isAfterLast())
                    {
                        SurveyModel list1 = new SurveyModel();
                        list1.setVilage(cursor1.getString(cursor1.getColumnIndex("village")));
                        list1.setTotal_member(cursor1.getString(cursor1.getColumnIndex("total_member")));
                        list1.setName(cursor1.getString(cursor1.getColumnIndex("name")));
                        list1.setCoughing_blood(cursor1.getString(cursor1.getColumnIndex("coughing_blood")));
                        list1.setCough_that_lasts_three(cursor1.getString(cursor1.getColumnIndex("Cough_that_lasts_three")));
                        surveyTableArrayList1.add(list1);
                        cursor1.moveToNext();
                    }
                }
                db1.close();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            db1.close();
        }
        return surveyTableArrayList1;

    }

    //Seach Method

    public ArrayList<SurveyModel> getSurveyFormList(String namee) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<SurveyModel> arrayList = new ArrayList<>();
        try {
            if (db != null && db.isOpen() && !db.isReadOnly()) {
                String query = "";
                if (namee.equals("")) {
                      query = "select * from survey where name LIKE '" + namee + "%' OR village like '" + namee + "%' OR total_member like '" + namee + "%' ";
                } else {
                    query = "select * from survey where name LIKE '" + namee + "%' OR village like '" + namee + "%' OR total_member like '" + namee + "%' ";
                }
                Cursor cursor = db.rawQuery(query, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        SurveyModel pregnantWomenPojo = new SurveyModel();
                        pregnantWomenPojo.setName(cursor.getString(cursor.getColumnIndex("name")));
                        pregnantWomenPojo.setVilage(cursor.getString(cursor.getColumnIndex("village")));
                        pregnantWomenPojo.setTotal_member(cursor.getString(cursor.getColumnIndex("total_member")));
                        cursor.moveToNext();
                        arrayList.add(pregnantWomenPojo);
                    }
                    db.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            db.close();
        }
        return arrayList;
    }


}
