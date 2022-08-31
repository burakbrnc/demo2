package dbdisplaypart;

import java.util.Date;

public class Patient {
    int patient_id;
    String first_name;
    String last_name;
    Long tc_no;
    java.sql.Date date_of_birth;
    Long tel_no;
    String job;
    String gender;
    java.sql.Date report_date; //YYYY-MM-DD
    String address;

    public Patient() {}
    public Patient(int patient_id, String first_name, String last_name, Long tc_no, java.sql.Date date_of_birth, Long tel_no, String job, String gender, java.sql.Date report_date, String address){
        this.patient_id=patient_id;
        setVariables(first_name,last_name,tc_no,date_of_birth,tel_no,job,gender,report_date,address);
    }
    public Patient(String first_name, String last_name, Long tc_no, java.sql.Date date_of_birth, Long tel_no, String job, String gender, java.sql.Date report_date, String address){
        setVariables(first_name,last_name,tc_no,date_of_birth,tel_no,job,gender,report_date,address);
    }

    void setVariables(String first_name, String last_name, Long tc_no, java.sql.Date date_of_birth, Long tel_no, String job, String gender, java.sql.Date report_date, String address)
    {
        this.first_name=first_name;
        this.last_name=last_name;
        this.tc_no=tc_no;
        this.date_of_birth=date_of_birth;
        this.tel_no=tel_no;
        this.job=job;
        this.gender=gender;
        this.report_date=report_date;
        this.address=address;
    }
    public int getPatient_id() {
        return patient_id;
    }
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getTc_no() {
        return tc_no;
    }
    public void setTc_no(Long tc_no) {
        this.tc_no = tc_no;
    }

    public java.sql.Date getDate_of_birth() {
        return date_of_birth;
    }
    public void setDate_of_birth(java.sql.Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Long getTel_no() {
        return tel_no;
    }
    public void setTel_no(Long tel_no) {
        this.tel_no = tel_no;
    }

    public String  getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {return gender;}
    public void setGender(String gender) {
        this.gender = gender;

    }

    public java.sql.Date getReport_date(){return report_date;}
    public void setReport_date(java.sql.Date report_date) {
        this.report_date = report_date;
    }

    public int test()
    {
        return  1;
    }

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}


}
