package com.example.classmanager;

import Database.AppDatabase;
import Database.Entity.UserEntity;
import Database.dao.UserDao;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText edit_acc;
    private EditText edit_pass;
    private EditText edit_no;
    private EditText edit_name;
    private Button reg;
    private String newAcc;
    private String newPass;
    private String newNo;
    private String newName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit_acc = (EditText)findViewById(R.id.acc);
        edit_pass = (EditText)findViewById(R.id.pass);
        edit_name = (EditText)findViewById(R.id.edit_stuName);
        edit_no = (EditText)findViewById(R.id.edit_stuNo);
        reg = (Button)findViewById(R.id.reg);

        AppDatabase database = AppDatabase.getInstance();
        final UserDao userDao = database.userDao();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newAcc = edit_acc.getText().toString();
                newPass = edit_pass.getText().toString();
                newName = edit_name.getText().toString();
                newNo = edit_no.getText().toString();
                UserEntity entity = new UserEntity(newAcc,newPass,newNo,newName);
                userDao.add(entity);
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
