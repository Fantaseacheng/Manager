package com.example.classmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import Alarm.AlarmReceiver;
import Database.dao.CourseDao;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
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
import java.util.Calendar;
import java.util.List;

import Any.CourseAdapter;
import Database.AppDatabase;
import Database.Entity.CourseEntity;
import androidx.room.Room;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<CourseEntity> coursesList= new ArrayList<>();
    private ImageButton Add;
    private NavigationView navigationView;
    int alarm_day;
    int alarm_hour;
    int alarm_minute;
    int flag;
    PendingIntent pi;
    long time;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pi=PendingIntent.getBroadcast(this,0,getMsgIntent(),0);
        time=System.currentTimeMillis();
        am= (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent i = getIntent();
        final String stuNo = i.getStringExtra("Ex3");
        getCourse(stuNo);

        if(!coursesList.isEmpty())
        {
            for(CourseEntity s:coursesList)
            {
            switch (s.getDay()){
                case "周一":
                    alarm_day = 2;
                    break;
                case "周二":
                    alarm_day = 3;
                    break;
                case "周三":
                    alarm_day = 4;
                    break;
                case "周四":
                    alarm_day = 5;
                    break;
                case "周五":
                    alarm_day = 6;
                    break;
            }
            switch (s.getHour()){
                case "8:00--9:35":
                    alarm_hour = 7;
                    break;
                case "9:50--11:25":
                    alarm_hour = 9;
                    break;
                case "2:30--4:05":
                    alarm_hour = 14;
                    break;
                case "4:20--5:55":
                    alarm_hour = 16;
                    break;
            }
            switch (s.getHour()){
                    case "8:00--9:35":
                        alarm_minute = 50;
                        break;
                    case "9:50--11:25":
                        alarm_minute = 40;
                        break;
                    case "2:30--4:05":
                        alarm_minute = 20;
                        break;
                    case "4:20--5:55":
                        alarm_minute = 10;
                        break;
                }
                if(("1").equals(s.getReminder())) {
                    setAlarm(alarm_day, alarm_hour, alarm_minute);
                }
            }

        }

        CourseAdapter adapter = new CourseAdapter(MainActivity.this,R.layout.course_list,coursesList);
        ListView listView = findViewById(R.id.list_view);
        Add = findViewById(R.id.add_course);
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
                intent.putExtra("E8",stuNo);
                startActivity(intent);
            }
        });


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddClassActivity.class);
                intent.putExtra("X1",stuNo);
                startActivity(intent);
            }
        });

        Intent getintent = getIntent();
        final String UserAccount = getintent.getStringExtra("Ex1");
        final String UserName = getintent.getStringExtra("Ex2");
        final String UserNo = getintent.getStringExtra("Ex3");
        navigationView = findViewById(R.id.nav);
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

    private Intent getMsgIntent(){
        Intent intent=new Intent(this,AlarmReceiver.class);
        intent.setAction("action.alarm");
        return intent;
    }

    private void setAlarm(int day,int hour,int minute){
            am.setExact(AlarmManager.RTC_WAKEUP,getTimeDiff(day,hour,minute),pi);
    }

    public long getTimeDiff(int day,int hour,int minute){
        Calendar ca=Calendar.getInstance();
        ca.set(Calendar.DAY_OF_WEEK,day);
        ca.set(Calendar.HOUR_OF_DAY,hour);
        ca.set(Calendar.MINUTE,minute);
        ca.set(Calendar.SECOND,0);
        return ca.getTimeInMillis();
    }


    private void getCourse(String s) {
        AppDatabase db = AppDatabase.getInstance();
        CourseDao courseDao = db.courseDao();
        coursesList.addAll(courseDao.getAll(s));
    }
}
