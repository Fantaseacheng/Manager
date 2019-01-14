package com.example.classmanager;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import Database.dao.CourseDao;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import Any.CourseAdapter;
import Database.AppDatabase;
import Database.Entity.CourseEntity;
import androidx.room.Room;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<CourseEntity> coursesList= new ArrayList<>();
    private ImageButton Add;
    private NavigationView navigationView;
    private CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCourse();
        CourseAdapter adapter = new CourseAdapter(MainActivity.this,R.layout.course_list,coursesList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        Add = (ImageButton)findViewById(R.id.add_course);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CourseEntity courses = coursesList.get(position);
                Log.e(TAG,courses.toString() );
                String Cname = courses.getName();
                String Cno = courses.getNo();
                String Teacher = courses.getTeacher();
                String day = courses.getDay();
                String hour = courses.getHour();
                String note = courses.getNote();
                String remind = courses.getReminder();
                Intent intent = new Intent(MainActivity.this,ClassDetailActivity.class);
                intent.putExtra("E1",Cname);
                intent.putExtra("E2",Cno);
                intent.putExtra("E3",Teacher);
                intent.putExtra("E4",day);
                intent.putExtra("E5",hour);
                intent.putExtra("E6",note);
                intent.putExtra("E7",remind);
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

        Intent getintent = getIntent();
        final String UserAccount = getintent.getStringExtra("Ex1");
        final String UserName = getintent.getStringExtra("Ex2");
        final String UserNo = getintent.getStringExtra("Ex3");
        navigationView = (NavigationView)findViewById(R.id.nav);
        View headerView = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.favorite:
                        Intent intent1 = new Intent();
                        intent1.setClass(MainActivity.this, InfoActivity.class);
                        intent1.putExtra("X1",UserAccount);
                        intent1.putExtra("X2",UserName);
                        intent1.putExtra("X3",UserNo);
                        startActivity(intent1);
                        break;
                    case R.id.quit:
                        Intent intent2 = new Intent();
                        intent2.setClass(MainActivity.this, LoginActivity.class);
                        startActivity(intent2);
                        break;

                }

                return true;
            }
        });

    }



    private void getCourse(){
        AppDatabase db = AppDatabase.getInstance();
        CourseDao courseDao = db.courseDao();
        coursesList.addAll(courseDao.getAll());

    }
}
