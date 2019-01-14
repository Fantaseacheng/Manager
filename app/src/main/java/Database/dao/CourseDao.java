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

    @Query("select * from course where course_no = :no")
    CourseEntity getOne(String no);

    @Insert
    void add(CourseEntity entity);

    @Update
    void addnote(CourseEntity entity);

    @Delete
    void delete(CourseEntity entity);

    @Update
    void update(CourseEntity entity);

}