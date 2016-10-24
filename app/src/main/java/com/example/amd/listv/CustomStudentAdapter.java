package com.example.amd.listv;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomStudentAdapter extends ArrayAdapter<Student> {
    public CustomStudentAdapter(Context context, ArrayList<Student> students){
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Student student = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_list, parent, false);
        }

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView nim = (TextView) convertView.findViewById(R.id.nim);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView email = (TextView) convertView.findViewById(R.id.email);
        TextView phone = (TextView) convertView.findViewById(R.id.phone);

        id.setText(student.getId()+"");
        nim.setText(student.getNIM());
        nama.setText(student.getNama());
        email.setText(student.getEmail());
        phone.setText(student.getPhone());

        return convertView;
    }

}
