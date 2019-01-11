package com.example.classmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.classmanager.R;

import java.util.ArrayList;
import java.util.List;

import Any.CourseAdapter;
import Bean.Courses;

public class MainActivity extends AppCompatActivity {

    private List<Courses> coursesList= new ArrayList<>();
    private ImageButton Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCourse();
        CourseAdapter adapter = new CourseAdapter(MainActivity.this,R.layout.course_list,coursesList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        Add = (ImageButton)findViewById(R.id.add_course);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Courses courses = coursesList.get(position);
                String Cname = courses.getCourseName();
                String Cno = courses.getCourseNo();
                String Teacher = courses.getTeacher();
                String Time = courses.getTime();
                TextView T1 = (TextView)findViewById(R.id.CName);
                T1.setText(Cname);
                Intent intent = new Intent(MainActivity.this,ClassDetailActivity.class);
                intent.putExtra("E1",Cname);
                intent.putExtra("E2",Cno);
                intent.putExtra("E3",Teacher);
                intent.putExtra("E4",Time);
                startActivity(intent);
            }
        });
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddClassActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initCourse(){
        Courses C1 = new Courses("Android开发基础","1","祝鹏","8:00--9:35",true);
        coursesList.add(C1);
        Courses C2 = new Courses("软件工程","2","xx","8:00--9:35",true);
        coursesList.add(C2);
    }
}
