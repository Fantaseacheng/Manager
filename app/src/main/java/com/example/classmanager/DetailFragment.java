package com.example.classmanager;

import android.content.Intent;
import android.os.Bundle;

import Database.AppDatabase;
import Database.Entity.CourseEntity;
import Database.dao.CourseDao;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import Any.PxUntil;


public class DetailFragment extends Fragment {
    private TextView ShowCName;
    private TextView ShowCNo;
    private TextView ShowTeacher;
    private TextView ShowDay;
    private TextView ShowHour;
    private TextView ShowRemind;
    private ImageButton Delete;

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.fragment_detail, container, false);

        AppDatabase database = AppDatabase.getInstance();
        final CourseDao courseDao = database.courseDao();

        ShowCName = view.findViewById(R.id.show_name);
        ShowCNo = view.findViewById(R.id.show_no);
        ShowTeacher = view.findViewById(R.id.show_teacher);
        ShowDay = view.findViewById(R.id.show_day);
        ShowHour = view.findViewById(R.id.show_time);
        ShowRemind = view.findViewById(R.id.show_remind);
        Delete = view.findViewById(R.id.delete);
        final Bundle bundle = getArguments();
        ShowCName.setText(bundle.getString("E1"));
        ShowCNo.setText(bundle.getString("E2"));
        ShowTeacher.setText(bundle.getString("E3"));
        ShowDay.setText(bundle.getString("E4"));
        ShowHour.setText(bundle.getString("E5"));
        String reminder = bundle.getString("E7");
        if("1".equals(reminder))
        {
            ShowRemind.setText("已设置提醒");
        }
        else
        {
            ShowRemind.setText("未设置提醒");
        }

        Delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CourseEntity entity = new CourseEntity(bundle.getString("E1"),bundle.getString("E2"),
                        bundle.getString("E3"),bundle.getString("E4"),
                        bundle.getString("E5"),bundle.getString("E7"),bundle.getString("E6"),bundle.getString("E8"));
                courseDao.delete(entity);
                View toastView =LayoutInflater.from(getActivity()).inflate(R.layout.toast, null);
                LinearLayout relativeLayout = (LinearLayout)toastView.findViewById(R.id.toast_linear);
                PxUntil pxUntil = new PxUntil();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)pxUntil.dpToPx(getActivity(), 130), (int)pxUntil.dpToPx(getActivity(), 130));
                relativeLayout.setLayoutParams(layoutParams);
                TextView textView = (TextView)toastView.findViewById(R.id.tv_toast_clear);
                textView.setText("课程已删除");
                Toast toast = new Toast(getActivity());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setView(toastView);
                toast.show();
                Intent i = new Intent(getActivity(),MainActivity.class);
                startActivity(i);
            }
        });

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }







}
