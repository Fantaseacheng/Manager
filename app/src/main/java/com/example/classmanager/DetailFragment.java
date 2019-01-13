package com.example.classmanager;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {
    private TextView ShowCName;
    private TextView ShowCNo;
    private TextView ShowTeacher;
    private TextView ShowDay;
    private TextView ShowHour;
    private TextView ShowRemind;

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.fragment_detail, container, false);
        ShowCName = (TextView)view.findViewById(R.id.show_name);
        ShowCNo = (TextView)view.findViewById(R.id.show_no);
        ShowTeacher = (TextView)view.findViewById(R.id.show_teacher);
        ShowDay = (TextView)view.findViewById(R.id.show_day);
        ShowHour = (TextView)view.findViewById(R.id.show_time);
        ShowRemind = (TextView)view.findViewById(R.id.show_remind);
        Bundle bundle = getArguments();
        ShowCName.setText(bundle.getString("E1"));
        ShowCNo.setText(bundle.getString("E2"));
        ShowTeacher.setText(bundle.getString("E3"));
        ShowDay.setText(bundle.getString("E4"));
        ShowHour.setText(bundle.getString("E5"));
        String reminder = bundle.getString("E7");
        if(reminder.equals("1"))
        {
            ShowRemind.setText("已设置提醒");
        }
        else
        {
            ShowRemind.setText("未设置提醒");
        }
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }







}
