package com.example.amd.listv;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView emptyTextView, studentView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickStudent(View v){
        Intent i = new Intent(getApplicationContext(), Student.class);
        startActivity(i);
    }
    /*
        ArrayList<Student> arrayofStudent = getStudent();
        CustomStudentAdapter adapter = new CustomStudentAdapter(this, new ArrayList<Student>());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        emptyTextView = (TextView)findViewById(R.id.emptyText);
        listView.setEmptyView(emptyTextView);

        studentView = (TextView)findViewById(R.id.studentList);
        studentView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Student.class);
                startActivity(intent);
            });
        }
    }

    private ArrayList<Student> getStudent(){
        ArrayList<Student> studentArrayList = Student.getStudent();

        CustomStudentAdapter adapter = new CustomStudentAdapter(this, new ArrayList<Student>());

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        return studentArrayList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.createDummy:
                ArrayList<Student> students = getStudent();
                CustomStudentAdapter adapter = new CustomStudentAdapter(this, students);
                ListView lv = (ListView) findViewById(R.id.listView);
                lv.setAdapter(adapter);
                return true;
            case R.id.clearList:
                getStudent().clear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
}

