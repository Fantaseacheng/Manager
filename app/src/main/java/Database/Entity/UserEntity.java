package Database.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {

    @ColumnInfo(name = "account")
    private String account;

    @ColumnInfo(name = "password")
    private String password;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "number")
    private String stu_no;

    @ColumnInfo(name = "name")
    private String stu_name;

    public UserEntity(String account, String password, @NonNull String stu_no, String stu_name) {
        this.account = account;
        this.password = password;
        this.stu_no = stu_no;
        this.stu_name = stu_name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(@NonNull String stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }
}
