package cn.bdqn.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/5/005.
 */
public class Hobby {
    private int id;
    private String hobbyName;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", hobbyName='" + hobbyName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
