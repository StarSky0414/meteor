package com.starsky.meteor.db.op;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_info", schema = "meteor", catalog = "")
public class UserInfoEntity {
    private int id;
    private String userPhone;
    private String userPassword;
    private String userNickname;

    @Id
    @Column(name = "_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_phone", nullable = true, length = 20)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_password", nullable = true, length = 50)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_nickname", nullable = true, length = 50)
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoEntity that = (UserInfoEntity) o;
        return id == that.id &&
                Objects.equals(userPhone, that.userPhone) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(userNickname, that.userNickname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userPhone, userPassword, userNickname);
    }
}
