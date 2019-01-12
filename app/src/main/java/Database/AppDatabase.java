package Database;

import android.app.Application;
import android.content.Context;

import Database.Entity.CourseEntity;
import Database.dao.CourseDao;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;

@Database(entities = {CourseEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CourseDao courseDao();
    private static final String DB_NAME = "course";
    private static final String DB_NAME2 = "user";


    private static AppDatabase sInstance;
    private static AppDatabase sInstance2;


    public static void init( Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).allowMainThreadQueries().build();
                }
            }
        }
        if (sInstance2 == null) {
            synchronized (AppDatabase.class) {
                if (sInstance2 == null) {
                    sInstance2 = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME2).allowMainThreadQueries().build();
                }
            }
        }
    }


    public static AppDatabase getCourseInstance() {
        synchronized (AppDatabase.class) {
            if (sInstance == null) {
                throw new NullPointerException("database == null");
            }
        }
        return sInstance;
    }


    public static AppDatabase getUserInstance() {
        synchronized (AppDatabase.class) {
            if (sInstance2 == null) {
                throw new NullPointerException("database == null");
            }
        }
        return sInstance2;
    }


}
