package com.example.classmanager;

import android.accounts.Account;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classmanager.R;

public class LoginActivity extends AppCompatActivity {


    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private CheckBox Remember;
    private Button login_button;
    final String account = "a";
    final String password = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountEdit = (EditText)findViewById(R.id.login_account);
        passwordEdit = (EditText)findViewById(R.id.login_password);
        Remember = (CheckBox)findViewById(R.id.RememberPassWord);
        login_button = (Button)findViewById(R.id.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = pref.getBoolean("remember_pass",false);
        if(isRemember)
        {
            String account = pref.getString("account","");
            String password  = pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            Remember.setChecked(true);
        }
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getAccount = accountEdit.getText().toString();
                String getPassword = passwordEdit.getText().toString();
                if(getAccount.equals(account)&&getPassword.equals(password)){
                    editor = pref.edit();
                    if(Remember.isChecked())
                    {
                        editor.putBoolean("remember_pass",true);
                        editor.putString("account",getAccount);
                        editor.putString("password",getPassword);
                    }
                    else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"password error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
