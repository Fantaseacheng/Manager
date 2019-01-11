package com.example.classmanager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classmanager.R;

public class ClassDetailActivity extends AppCompatActivity {

    private TextView showCName;
    private TextView showCNo;
    private TextView showTeacher;
    private TextView showTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        BottomNavigationView view = findViewById(R.id.menubar);
        Intent intent = getIntent();
        String CName = intent.getStringExtra("E1");
        String CNO = intent.getStringExtra("E2");
        String Teacher =intent.getStringExtra("E3");
        String Time = intent.getStringExtra("E4");
        final Bundle bundle = new Bundle();
        bundle.putString("E1",CName);
        bundle.putString("E2",CNO);
        bundle.putString("E3",Teacher);
        bundle.putString("E4",Time);
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectFragment(menuItem.getItemId(),bundle);
                return true;
            }
        });

        selectFragment(R.id.navigation_detail,bundle);

    }

    private void selectFragment(int id,Bundle bundle) {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(String.valueOf(id));
        if (fragment == null) {
            fragment = createFragment(id,bundle);
        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_container, fragment, String.valueOf(id));
        transaction.commitAllowingStateLoss();
    }

    private Fragment createFragment(int id,Bundle bundle) {
        Fragment fragment = null;
        switch (id) {
            case R.id.navigation_detail:
                fragment = DetailFragment.newInstance();
                fragment.setArguments(bundle);
                break;

            case R.id.navigation_note:
                fragment = NoteFragment.newInstance();
                break;


        }
        return fragment;
    }
}

