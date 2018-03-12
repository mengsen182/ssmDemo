package cn.bdqn.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/2/5/005.
 */
public class Grade {
    /**
     *
     FieldTypeComment
     idint(11) NOT NULL班级id
     grade_namevarchar(10) NULL班级名称
     create_datedate NULL创建时间
     detailsvarchar(500) NULL班级描述
     */
    private Integer id;
    private String gradeName,details;
    private Date createDate;

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                ", details='" + details + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
