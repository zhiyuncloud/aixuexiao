package com.aixuexiao.web.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aixuexiao.model.Classes;
import com.aixuexiao.model.ExamMark;
import com.aixuexiao.model.Student;
import com.aixuexiao.model.StudentMessage;
import com.aixuexiao.service.StudentService;

/**
 * 包含学生列表菜单内的所有操作
 */
@Controller
public class StudentController {
	
	public static final int pagesize = 8;
	
	@Resource(name="studentService")
	private StudentService studentService;
	
	@RequestMapping(value="/manager/students",method=RequestMethod.GET)
	public ModelAndView listStudent(String pagenum,Student student){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("students");
		mv.addObject("sidebar","students");
		int num = 1;
		if(null!=pagenum){
			num = Integer.parseInt(pagenum);
		}
		List<Student> list = studentService.listStudent((num-1)*pagesize, pagesize,student);
		List<Classes> clslist = studentService.findAllClasses();
		mv.addObject("studentList", list);
		mv.addObject("clsList", clslist);
		mv.addObject("length", list.size());
		mv.addObject("pagenum", num);
		mv.addObject("student", student);
		return mv;
	}

	
	@RequestMapping(value="/manager/leavemessage",method=RequestMethod.GET)
	public ModelAndView leavemessage(int studentid){
		ModelAndView mv=new ModelAndView();
		Student student = studentService.findStudentById(studentid);
		if(null == student){
			mv.setViewName("redirect:/manager/students");
		}else{
			mv.setViewName("addstudentmessage");
			mv.addObject("sidebar","students");
			mv.addObject("student",student);
			List<StudentMessage> list = studentService.listMessageByStudentId(studentid, 100);
			mv.addObject("studentMessageList", list);
		}
		return mv;
	}
	
	@RequestMapping(value="/manager/examdetail",method=RequestMethod.GET)
	public ModelAndView examdetail(int studentid){
		ModelAndView mv=new ModelAndView();
		Student student = studentService.findStudentById(studentid);
		if(null == student){
			mv.setViewName("redirect:/manager/students");
		}else{
			mv.setViewName("examdetail");
			mv.addObject("sidebar","students");
			mv.addObject("student",student);
			List<ExamMark> list = studentService.findExamMarkByStudentId(studentid, 100);
			mv.addObject("emlist", list);
		}
		return mv;
	}
	
	@RequestMapping(value="/manager/addmessage",method=RequestMethod.POST)
	public ModelAndView addmessage(StudentMessage studentMessage){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/manager/leavemessage");
		mv.addObject("studentid",studentMessage.getStudentid());
		studentMessage.setInserttime(new Date());
		studentService.addStudentMessage(studentMessage);
		mv.addObject("notice","留言成功");
		return mv;
	}
	
	@RequestMapping(value="/manager/deletemessage",method=RequestMethod.GET)
	public ModelAndView deletemessage(int studentid,int messageid){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/manager/leavemessage");
		mv.addObject("studentid",studentid);
		studentService.deleteStudentMessageById(messageid);
		mv.addObject("notice","删除成功");
		return mv;
	}
	
	
}
