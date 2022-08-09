package com.example.sqlite;

public class ModelClass {


    String studentName, studentMail;

    public ModelClass( String studentName, String studentMail) {


        this.studentName = studentName;
        this.studentMail = studentMail;

    }





    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMail() {
        return studentMail;
    }

    public void setStudentMail(String studentMail) {
        this.studentMail = studentMail;
    }



}