package com.example.amd.listv;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class StudentActivity {
    private TextView emptyView;
    ListView listView;
    static ArrayList<Student> StudentList;
    CustomStudentAdapter customStudentAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_student_list, menu);
        return true;
    }

    public void toForm(View v){
        Intent i = new Intent(getApplicationContext(), AddStudentActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.one:
                populateUsersList();

                return true;
            case R.id.two:
                ClearList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }





    @Override

    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);
        emptyView = (TextView)findViewById(R.id.empty);
        listView = (ListView)findViewById(R.id.Listview);

        if (StudentList == null) StudentList = new ArrayList<Student>();
        customStudentAdapter = new CustomStudentAdapter(this, StudentList);
        listView = (ListView)findViewById(R.id.Listview);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student StudentListItem = StudentList.get(position);
                Intent i = new Intent(StudentActivity.this, EditStudentActivity.class);
                i.putExtra("StudentListItem", StudentListItem);
                i.putExtra("position",position);
                startActivity(i);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        TextView empty_view = (TextView)findViewById(R.id.emptyText);
        if(StudentList.size() == 0) {
            customStudentAdapter = new CustomStudentAdapter(this, new ArrayList<Student>());
            listView.setEmptyView(empty_view);
            empty_view.setText("No Student Found");
        } else {
            customStudentAdapter = new CustomStudentAdapter(this, StudentList);
            empty_view.setText("");
        }
        listView.setAdapter(customStudentAdapter);
    }


    private void ClearList() {
        StudentList.clear();
        customStudentAdapter = new CustomStudentAdapter(this, StudentList);
        listView.setAdapter(customStudentAdapter);

    }


    private void populateUsersList() {
        StudentList.add(new Student(StudentList.size()+1,"3135136***","Just Dummy","0812323211","dummy@gmail.com"));
        customStudentAdapter = new CustomStudentAdapter(this, StudentList);
        listView.setAdapter(customStudentAdapter);
    }
}
