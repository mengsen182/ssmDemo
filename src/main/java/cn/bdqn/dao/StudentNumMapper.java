package cn.bdqn.dao;

/**
 * Created by Administrator on 2018/2/28/028.
 */
public interface StudentNumMapper {
    public Integer addStudentNum(Integer gradeId);

    public Integer updateMaxNumByGradeId(Integer gradeId);

    public Integer queryMaxNumByGradeId(Integer gradeId);
}
