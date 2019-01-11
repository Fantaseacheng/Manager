package com.example.classmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class NoteFragment extends Fragment {


    public static NoteFragment newInstance(){
        return new NoteFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.fragment_note, container, false);
        ImageButton addButton = (ImageButton)view.findViewById(R.id.add_note);
        final ImageButton checkButton = (ImageButton)view.findViewById(R.id.check);
        final TextView wancheng = (TextView)view.findViewById(R.id.wancheng);
        final EditText editText = (EditText)view.findViewById(R.id.note);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setFocusableInTouchMode(true);
                editText.setFocusable(true);
                editText.requestFocus();
                checkButton.setVisibility(View.VISIBLE);
                wancheng.setVisibility(View.VISIBLE);
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setFocusable(false);
                editText.setFocusableInTouchMode(false);
                checkButton.setVisibility(View.INVISIBLE);
                wancheng.setVisibility(View.INVISIBLE);
            }
        });
        SharedPreferences pref = this.getActivity().getSharedPreferences("con",Context.MODE_PRIVATE);
        String note = editText.getText().toString();
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("note",note);
        editor.commit();
        String note2 =pref.getString("note","");
        Toast.makeText(getContext(),note2,Toast.LENGTH_SHORT).show();
        editText.setText(note2);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
