package com.example.classmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {


    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.fragment_detail, container, false);
        TextView ShowCName = (TextView)view.findViewById(R.id.show_name);
        TextView ShowCNo = (TextView)view.findViewById(R.id.show_no);
        TextView ShowTeacher = (TextView)view.findViewById(R.id.show_teacher);
        TextView ShowTime = (TextView)view.findViewById(R.id.show_time);
        Bundle bundle = getArguments();
        ShowCName.setText(bundle.getString("E1"));
        ShowCNo.setText(bundle.getString("E2"));
        ShowTeacher.setText(bundle.getString("E3"));
        ShowTime.setText(bundle.getString("E4"));
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }







}
