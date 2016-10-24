package com.example.amd.listv;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;


public class Student {
    private int id;
    private String nim;
    private String nama;
    private String email;
    private String phone;

    public Student(int id, String nim, String nama, String email, String phone) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNIM() {
        return nim;
    }

    public void setNIM(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public static ArrayList<Student> getStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "3145136916", "Mikael Y", "mikael@gmail.com", "0812345678"));
        studentList.add(new Student(2, "3145136214", "Dimas S", "dimas@gmail.com", "08122395688"));
        studentList.add(new Student(3, "3145136208", "Alitinia P", "alitinia@gmail.com", "0812983054"));
        studentList.add(new Student(4, "3145136195", "Gregorius A H", "gregorius@gmail.com", "08120470759"));
        return studentList;
    }
}
