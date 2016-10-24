package com.example.amd.listv;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddStudentActivity extends AppCompatActivity {

    EditText idAdd, nimAdd, namaAdd, emailAdd, phoneAdd;
    ArrayList<Student> StudentList;
    Button Saved, Canceled;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        StudentList = Student.StudentList;

        idAdd = (EditText) findViewById(R.id.edit_id);
        nimAdd = (EditText) findViewById(R.id.edit_nim);
        namaAdd = (EditText) findViewById(R.id.edit_nama);
        emailAdd = (EditText) findViewById(R.id.edit_email);
        phoneAdd = (EditText) findViewById(R.id.edit_phone);
        int auto = StudentList.size()+1;
        idAdd.setText(String.valueOf(auto));
        Saved = (Button)findViewById(R.id.save);
        Canceled = (Button)findViewById(R.id.cancel);
        Intent i = getIntent();
        Saved.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Saved;
            }
        });
        Canceled.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        public void Saved() {
        String getNim = nimAdd.getText().toString();
        String getNama = namaAdd.getText().toString();
        String getEmail = emailAdd.getText().toString();
        String getPhone = phoneAdd.getText().toString();
        Student student = new Student(StudentList.size()+1, getNim, getNama, getEmail, getPhone);
        StudentList.add(student);
        finish();

            Toast.makeText(getApplicationContext(), "Data Has Been Saved", Toast.LENGTH_SHORT)/show();
            Intent i = new Intent(getApplicationContext(), Student.class);
            startActivity(i);
        }
    }


/*
        FloatingActionButton saveActionButton = (FloatingActionButton) findViewById(R.id.save);
        FloatingActionButton cancelActionButton = (FloatingActionButton) findViewById(R.id.cancel);
        saveActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Saved;
            }
        });

        cancelActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    protected void saveNewData(){
        int id = Integer.parseInt(idText.getText().toString());
        String nim = nimText.getText().toString();
        String nama = namaText.getText().toString();
        String email = emailText.getText().toString();
        String phone = phoneText.getText().toString();

        student = new Student(id, nim, nama, email, phone);
        StudentList studentList = studentList.getInstance();
    }
}



/*
    private boolean validation(){
        if (nim.getText().toString().isEmpty()){
            nim.setError("Insert this field");
            return false;
        }
        if (nama.getText().toString().isEmpty()){
            nama.setError("Insert this field");
            return false;
        }
        if (email.getText().toString().isEmpty()){
            email.setError("Insert this field");
            return false;
        }
        if (phone.getText().toString().isEmpty()) {
            phone.setError("Insert this field");
            return false;
        }

        return true;
    }

    private void AddStudent(){
        CustomStudentAdapter studentList = CustomStudentAdapter.getInstance();
        studentList.addStudent(new Student(
                studentList.sizeStudentList()+1,
                nim.getText().toString(),
                nama.getText().toString(),
                email.getText().toString(),
                phone.getText().toString()));,
        ))
    }
*/

}
