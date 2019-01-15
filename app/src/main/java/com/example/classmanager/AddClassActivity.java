package com.example.classmanager;

import Database.dao.CourseDao;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import Database.AppDatabase;
import Database.Entity.CourseEntity;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class AddClassActivity extends Activity {

    private EditText CNameEdit;
    private EditText CNoEdit;
    private EditText TeacherEdit;
    private Spinner Time;
    private Spinner Week;
    private Button AddCourse;
    private Button CancelAdd;
    private Switch reminder;
    private String remindme;
    private String weekday;
    private String hour;
    private String newName;
    private String newTeacher;
    private String newNo;
    private CompositeDisposable mDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        CNameEdit = findViewById(R.id.name_edit);
        CNoEdit = findViewById(R.id.no_edit);
        TeacherEdit = findViewById(R.id.teacher_edit);
        AddCourse = findViewById(R.id.addcourse_button);
        CancelAdd = findViewById(R.id.cancel_add);
        Week = findViewById(R.id.weekday_edit);
        Time = findViewById(R.id.hour_edit);
        reminder = findViewById(R.id.reminder);


        AppDatabase database = AppDatabase.getInstance();
        final CourseDao courseDao = database.courseDao();

        Week.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                weekday = (String)Week.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hour = (String)Time.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        reminder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    remindme = "1";
                }
                else if(!isChecked)
                {
                    remindme = "2";
                }
            }
        });


        AddCourse = (Button)findViewById(R.id.addcourse_button);
        AddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newName = CNameEdit.getText().toString();
                newNo = CNoEdit.getText().toString();
                newTeacher = TeacherEdit.getText().toString();
                Intent i = getIntent();
                String stuNo =i.getStringExtra("X1");
                CourseEntity courseEntity = new CourseEntity(newName,newNo,newTeacher,weekday,hour,remindme,null,stuNo);
                courseDao.add(courseEntity);
                Intent intent = new Intent(AddClassActivity.this,MainActivity.class);
                intent.putExtra("Ex3",stuNo);
                startActivity(intent);
            }
        });

        CancelAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddClassActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

}
