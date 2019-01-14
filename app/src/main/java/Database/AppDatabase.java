package Database;

import android.app.Application;
import android.content.Context;

import Database.Entity.CourseEntity;
import Database.Entity.UserEntity;
import Database.dao.CourseDao;
import Database.dao.UserDao;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;

@Database(entities = {CourseEntity.class,UserEntity.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CourseDao courseDao();
    public abstract UserDao userDao();
    private static final String DB_NAME = "course";

    private static AppDatabase sInstance;


    public static void init( Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).allowMainThreadQueries().build();
                }
            }
        }

    }


    public static AppDatabase getInstance() {
        synchronized (AppDatabase.class) {
            if (sInstance == null) {
                throw new NullPointerException("database == null");
            }
        }
        return sInstance;
    }




}
