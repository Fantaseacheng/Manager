package com.example.classmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView showAccount;
    private TextView showName;
    private TextView showNo;
    private String Account;
    private String Number;
    private String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        final Intent intent = getIntent();
        Account = intent.getStringExtra("X1");
        Number = intent.getStringExtra("X2");
        Name = intent.getStringExtra("X3");

        showAccount = (TextView)findViewById(R.id.show_acc);
        showName = (TextView)findViewById(R.id.show_stuName);
        showNo = (TextView)findViewById(R.id.show_stuNo);
        showAccount.setText(Account);
        showName.setText(Number);
        showNo.setText(Name);

    }
}
