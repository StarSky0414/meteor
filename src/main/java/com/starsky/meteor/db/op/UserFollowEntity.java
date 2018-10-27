package com.starsky.meteor.db.op;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_follow", schema = "meteor", catalog = "")
public class UserFollowEntity {
    private int id;
    private String userId;
    private String friendId;
    private String nickname;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "friend_id", nullable = false, length = 20)
    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 50)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFollowEntity that = (UserFollowEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(friendId, that.friendId) &&
                Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, friendId, nickname);
    }
}
