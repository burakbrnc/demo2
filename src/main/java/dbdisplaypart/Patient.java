package dbdisplaypart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class Patient {
    int patient_id;
    String first_name;
    String last_name;
    Long tc_no;
    String date_of_birth;
    Long tel_no;
    String job;
    String gender;
    String report_date; //YYYY-MM-DD
    String address;



    public Patient(int patient_id, String first_name, String last_name, Long tc_no, String date_of_birth, Long tel_no, String job, String gender, String report_date, String address){
        this.patient_id=patient_id;
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

    public Patient() {

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

    public String getDate_of_birth() {
        return date_of_birth;
    }
    public void setDate_of_birth(String date_of_birth) {
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

    public String getReport_date(){return report_date;}
    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

    public int test()
    {
        return  1;
    }

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}


}
