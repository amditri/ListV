package com.example.amd.listv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditStudentActivity extends AppCompatActivity {

    EditText idEdit, nimEdit, namaEdit, emailEdit, phoneEdit;
    ArrayList<Student> StudentList;
    Button Saved, Canceled;
    private int position;
    Student student;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        StudentList = Student.StudentList;

        idEdit = (EditText)findViewById(R.id.edit_id);
        nimEdit = (EditText)findViewById(R.id.edit_nim);
        namaEdit = (EditText)findViewById(R.id.edit_nama);
        emailEdit = (EditText)findViewById(R.id.edit_email);
        phoneEdit = (EditText)findViewById(R.id.edit_phone);
        Saved = (Button)findViewById(R.id.save);
        listView = (ListView)findViewById(R.id.listView);
        Canceled = (Button)findViewById(R.id.cancel);
        //editButton = (Button)findViewById(R.id.editBttn);

        //final int value = getIntent().getExtras().getInt("no");

        Student studentValue = (Student) getIntent().getSerializableExtra("StudentList")

        idEdit.setText(student.getId());
        nimEdit.setText(student.getNIM());
        namaEdit.setText(student.getNama());
        emailEdit.setText(student.getEmail());
        phoneEdit.setText(student.getPhone());

        Saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });

        Canceled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void edit(){
        int getId = Integer.parseInt(idEdit.getText().toString());
        String getNIM = nimEdit.getText().toString();
        String getNama = namaEdit.getText().toString();
        String getEmail = emailEdit.getText().toString();
        String getPhone = phoneEdit.getText().toString();

        Student student = new Student(getId, getNIM, getNama, getEmail, getPhone);
        StudentList.set(position, student);
        finish();

        Toast.makeText(getApplicationContext(), "Data Already Edited", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), Student.class);

        startActivity(i);
        /*nim = (EditText) findViewById(R.id.edit_nim);
        nama = (EditText) findViewById(R.id.edit_nama);
        email = (EditText) findViewById(R.id.edit_email);
        phone = (EditText) findViewById(R.id.edit_phone);
        ArrayList<Student> student = new CustomStudentAdapter().getList();
        student.set(value, new Student(
                value+1,
                nim.getText().toString(),
                nama.getText().toString(),
                email.getText().toString(),
                phone.getText().toString()));
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_deletestudent, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editRemove:
                remove();
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(intent);

                Toast.makeText(this, "Remove Success", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void remove() {
        int value = getIntent().getExtras().getInt("no");
        ArrayList<Student> students = new CustomStudentAdapter().getList();
        students.remove(value);
    }

}
