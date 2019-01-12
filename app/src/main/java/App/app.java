package App;

import android.app.Application;

import Database.AppDatabase;

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.init(this);
    }
}
