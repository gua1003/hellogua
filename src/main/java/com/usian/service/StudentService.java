package com.usian.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.bean.Student;
import com.usian.bean.StudentVo;
import com.usian.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired(required = false)
    private StudentMapper sm;
    public void add(Student s){
        sm.insert(s);
    }

    public PageInfo<Student> findStudent(StudentVo s, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> student = sm.findStudent(s);
        PageInfo<Student> pageInfo = new PageInfo<>(student);
        return pageInfo;
    }

    public void updateStu(Student s){
        sm.updateByPrimaryKey(s);
    }

    public void deleteStu(int sid){
        sm.deleteByPrimaryKey(sid);
    }

    public Student findStuById(int sid){
        return sm.selectByPrimaryKey(sid);
    }

    public Student findStuByName(String sid){
        return sm.findStudentByName(sid);
    }

    public Student findStuByPwd(String pwd){
        return sm.findStuByPwd(pwd);
    }
}
