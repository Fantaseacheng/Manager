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

public class CourseAdapter extends ArrayAdapter<Courses> {
    private int resourceId;
    private TextView CourseName;
    public CourseAdapter(Context context, int textViewResourceId, List<Courses> objects)
    {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Courses course = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        CourseName = (TextView)view.findViewById(R.id.CName);
        CourseName.setText(course.getCourseName());
        return view;
    }

}
