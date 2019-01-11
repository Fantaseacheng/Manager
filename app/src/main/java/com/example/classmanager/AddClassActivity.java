package com.example.classmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;


public class AddClassActivity extends AppCompatActivity {

    private EditText CNameEdit;
    private EditText CNoEdit;
    private EditText TeacherEdit;
    private Spinner Time;
    private Spinner Week;
    private Button AddCourse;
    private Button CancelAdd;
    private String weekday;
    private String hour;
    private String newName;
    private String newNo;
    private String newTeacher;
    private Switch reminder;
    private int remindme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        CNameEdit = (EditText)findViewById(R.id.name_edit);
        CNoEdit = (EditText)findViewById(R.id.no_edit);
        TeacherEdit = (EditText)findViewById(R.id.teacher_edit);
        AddCourse = (Button)findViewById(R.id.addcourse_button);
        CancelAdd = (Button)findViewById(R.id.cancel_add);
        Week = (Spinner)findViewById(R.id.weekday_edit);
        Time = (Spinner)findViewById(R.id.hour_edit);
        reminder = (Switch)findViewById(R.id.reminder);
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
                    remindme = 1;
                }
                else
                {
                    remindme = 0;
                }
            }
        });
        newName = CNameEdit.getText().toString();
        newNo = CNoEdit.getText().toString();
        newTeacher = TeacherEdit.getText().toString();

    }
}