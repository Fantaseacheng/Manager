package Database.Entity;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course")
public class CourseEntity {



    @ColumnInfo(name = "course_name")
    public String name;


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "course_no")
    public String no;


    @ColumnInfo(name = "teacher")
    public String teacher;

    @ColumnInfo(name = "day")
    public String day;

    @ColumnInfo(name = "hour")
    public String hour;

    @ColumnInfo(name = "reminder")
    public int reminder;

    @ColumnInfo(name = "note")
    public String note;

    public CourseEntity( String name, String no, String teacher, String day, String hour, int reminder, String note) {
        this.name = name;
        this.no = no;
        this.teacher = teacher;
        this.day = day;
        this.hour = hour;
        this.reminder = reminder;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getReminder() {
        return reminder;
    }

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
