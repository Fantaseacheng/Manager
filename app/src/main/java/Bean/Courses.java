package Bean;

public class Courses {
    private String CourseName;

    public String getCourseName() {
        return CourseName;
    }

    public Courses(String courseName, String courseNo, String teacher, String time, boolean reminder) {
        CourseName = courseName;
        CourseNo = courseNo;
        Teacher = teacher;
        Time = time;
        this.reminder = reminder;
    }

    public void setCourseName(String courseName) {

        CourseName = courseName;
    }

    public String getCourseNo() {
        return CourseNo;
    }

    public void setCourseNo(String courseNo) {
        CourseNo = courseNo;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    private String CourseNo;
    private String Teacher;
    private String Time;
    private boolean reminder;
}
