package com.example.healthawareness.Model;

public class SurveyModel {
        private String vilage;
        private String name;
        private String mobile_number;
        private String total_member;
        private String coughing_blood;
        private String Cough_that_lasts_three;


    public String getCough_that_lasts_three() {
        return Cough_that_lasts_three;
    }

    public void setCough_that_lasts_three(String cough_that_lasts_three) {
        Cough_that_lasts_three = cough_that_lasts_three;
    }

    public String getCoughing_blood() {
        return coughing_blood;
    }

    public void setCoughing_blood(String coughing_blood) {
        this.coughing_blood = coughing_blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVilage() {
            return vilage;
        }

        public void setVilage(String vilage) {
            this.vilage = vilage;
        }

        public String getMobile_number() {
            return mobile_number;
        }

        public void setMobile_number(String mobile_number) {
            this.mobile_number = mobile_number;
        }

        public String getTotal_member() {
            return total_member;
        }

        public void setTotal_member(String total_member) {
            this.total_member = total_member;
        }


        static final String TABLE_NAME = "survey";
        static final String COLUMN_localId = "local_id";
        static final String COLUMN_village = "village";
        static final String COLUMN_name = "name";
        static final String COLUMN_mobile_number= "mobile_number";
        static final String COLUMN_total_fimally_member = "total_member";
        static final String COLUMN_coughing_blood = "coughing_blood";
        static final String COLUMN_Cough_that_lasts_three = "Cough_that_lasts_three";


        public static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_localId + " INTEGER ,"

                + COLUMN_village + " TEXT ,"
                + COLUMN_name + " TEXT ,"
                + COLUMN_mobile_number + " TEXT ,"
                + COLUMN_total_fimally_member + " TEXT ,"
                + COLUMN_coughing_blood + " TEXT, "
                + COLUMN_Cough_that_lasts_three + " TEXT "

                + ")";
}
