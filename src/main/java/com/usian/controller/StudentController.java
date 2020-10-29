package com.usian.controller;

import com.github.pagehelper.PageInfo;
import com.usian.bean.Student;
import com.usian.bean.StudentVo;
import com.usian.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService ss;

    @RequestMapping("test")
    public void hh(){
        System.out.println("test222");
    }

    @RequestMapping("toZc")
    public String toZc(){
        return "zc";
    }

    @RequestMapping("findName")
    @ResponseBody
    public Student findName(String sname){
        Student s = ss.findStuByName(sname);
        System.out.println(s);
        return s;
    }

    @RequestMapping("zc")
    public String zC(Student s){
        ss.add(s);
        return "redirect:/student/login";
    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("login")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("add")
    public String add(Student s){
        System.out.println(s);
        ss.add(s);
        return "redirect:/student/show";
    }

    @RequestMapping("show")
    public String findStudent(Model m, StudentVo s, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "2")int pageSize){
        PageInfo<Student> page = ss.findStudent(s, pageNum, pageSize);
        m.addAttribute("page",page);
        m.addAttribute("sname",s.getSname());
        m.addAttribute("starttime",s.getStarttime());
        m.addAttribute("stoptime",s.getStoptime());
        return "show";

    }

    @RequestMapping("deleteStudent")
    public String deleteStu(int sid){
        ss.deleteStu(sid);
        return "redirect:/student/show";
    }

    @RequestMapping("findStudentById")
    public String findStudentById(int sid,Model m){
        Student s = ss.findStuById(sid);
        m.addAttribute("s",s);
        return "update";
    }

    @RequestMapping("updateStudent")
    public String updateStudent(Student s){
        ss.updateStu(s);
        return "redirect:/student/show";
    }

    @RequestMapping("toLogin")
    public String login(String sname, String pwd, Model m, HttpSession session){
        Student s = ss.findStuByName(sname);
        if(s==null){
            m.addAttribute("err","账号不存在");
            return "login";
        }
        Student s2 = ss.findStuByPwd(pwd);
        if(s2==null){
            m.addAttribute("err","密码错误");
            return "login";
        }else{
            session.setAttribute("s",s2);
            return "redirect:/student/show";
        }
    }
}
