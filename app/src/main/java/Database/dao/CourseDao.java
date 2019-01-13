package Database.dao;

import java.util.List;

import Bean.Courses;
import Database.Entity.CourseEntity;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Flowable;

@Dao
public interface CourseDao {

    @Query("select * from course")
    List<CourseEntity> getAll();

    @Query("select * from course where course_name = :name and course_no = :no")
    Flowable<CourseEntity> getOne(String name, String no);

    @Insert
    void add(CourseEntity entity);

    @Query("update course set note = :note where course_no = :no")
    void addnote(String no,String note);

    @Delete
    void delete(CourseEntity entity);

    @Update
    void update(CourseEntity entity);

}