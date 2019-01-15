package com.example.classmanager;

import Any.PxUntil;
import Database.AppDatabase;
import Database.Entity.UserEntity;
import Database.dao.UserDao;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

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
        edit_acc = findViewById(R.id.acc);
        edit_pass = findViewById(R.id.pass);
        edit_name = findViewById(R.id.edit_stuName);
        edit_no = findViewById(R.id.edit_stuNo);
        reg = findViewById(R.id.reg);

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
                View toastView =LayoutInflater.from(RegisterActivity.this).inflate(R.layout.toast, null);
                LinearLayout relativeLayout = toastView.findViewById(R.id.toast_linear);
                PxUntil pxUntil = new PxUntil();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)pxUntil.dpToPx(RegisterActivity.this, 130), (int)pxUntil.dpToPx(RegisterActivity.this, 130));
                relativeLayout.setLayoutParams(layoutParams);
                TextView textView = toastView.findViewById(R.id.tv_toast_clear);
                textView.setText("注册成功");
                Toast toast = new Toast(RegisterActivity.this);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setView(toastView);
                toast.show();
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
