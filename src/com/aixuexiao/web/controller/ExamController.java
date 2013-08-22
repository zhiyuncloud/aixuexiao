package com.aixuexiao.web.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aixuexiao.model.Classes;
import com.aixuexiao.model.Exam;
import com.aixuexiao.model.Student;
import com.aixuexiao.service.ExamService;
import com.aixuexiao.util.ExamUtil;

/**
 * 包含考试列表菜单内的所有操作
 */
@Controller
public class ExamController {
	
	public static final int pagesize = 10;
	
	@Resource(name="examService")
	private ExamService examService;
	
	@RequestMapping(value="/manager/exams",method=RequestMethod.GET)
	public ModelAndView listStudent(String pagenum,Exam exam){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("exams");
		mv.addObject("sidebar","exams");
		int num = 1;
		if(null!=pagenum){
			num = Integer.parseInt(pagenum);
		}
		List<Exam> list = examService.listExam((num-1)*pagesize, pagesize,exam);
		List<Classes> clslist = examService.findAllClasses();
		mv.addObject("examList", list);
		mv.addObject("clsList", clslist);
		mv.addObject("length", list.size());
		mv.addObject("pagenum", num);
		mv.addObject("exam", exam);
		return mv;
	}

 
	@RequestMapping(value="/manager/addexam",method=RequestMethod.POST)
	public ModelAndView addExam(Exam exam){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addexam");
		mv.addObject("sidebar","exams");
		List<Student> stlist = examService.findStudentByClassesId(exam.getClassid());
		mv.addObject("exam",exam);
		mv.addObject("stlist",stlist);
		return mv;
	}
	
	@RequestMapping(value="/manager/viewexam",method=RequestMethod.GET)
	public ModelAndView viewExam(int id){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("viewexam");
		mv.addObject("sidebar","exams");
		Exam exam =  examService.findExamById(id);
		mv.addObject("exam",exam);
		return mv;
	}
	
	@RequestMapping(value="/manager/addexammark",method=RequestMethod.POST)
	public ModelAndView addExamMark(Exam exam){
		ModelAndView mv=new ModelAndView();
		mv.addObject("sidebar","exams");
		mv.setViewName("redirect:/manager/exams");
		exam.setExamtime(new Date());
		exam = ExamUtil.sortExamMark(exam);//为分数排序
		examService.addExam(exam);
		return mv;
	}
	
}
