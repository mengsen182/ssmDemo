package cn.bdqn.entity;

/**
 * Created by Administrator on 2018/2/27/027.
 */
public class Student {
    /*
    * idint(11) NOT NULL
grade_idint(11) NULL班级id
student_namevarchar(10) NULL学生姓名
gendervarchar(2) NULL性别
ageint(11) NULL年龄
student_numvarchar(20) NULL学号*/

    private Integer id;
    private String studentName;
    private String gender;
    private String studentNum;
    private Integer age;

    private  Grade grade;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
