package Database.dao;

import Database.Entity.UserEntity;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void add(UserEntity userEntity);

    @Query("select * from user where account = :account")
    UserEntity get(String account);
}
