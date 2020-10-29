package com.usian.mapper;

import com.usian.bean.Student;
import com.usian.bean.StudentVo;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    List<Student> findStudent(Student s);

    Student findStudentByName(String sid);


    Student findStuByPwd(String pwd);
}
