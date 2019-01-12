package Any;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.classmanager.R;

import java.util.List;

import Bean.Courses;
import Database.Entity.CourseEntity;

public class CourseAdapter extends ArrayAdapter<CourseEntity> {
    private int resourseId;

    public CourseAdapter(Context context,int textViewResourceId,List<CourseEntity>objects)
    {
        super(context,textViewResourceId,objects);
        resourseId = textViewResourceId;
    }

    public View getView(int position,View convertView,ViewGroup parent){
        CourseEntity courseEntity = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        TextView CName = (TextView)view.findViewById(R.id.CName);
        CName.setText(courseEntity.getName());
        return view;
    }
}
