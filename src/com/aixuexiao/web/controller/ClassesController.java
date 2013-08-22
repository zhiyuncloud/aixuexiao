package com.aixuexiao.web.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aixuexiao.model.Classes;
import com.aixuexiao.model.ClassesNews;
import com.aixuexiao.model.Student;
import com.aixuexiao.service.ClassesService;

/**
 * 包含班级列表菜单内的所有操作
 */
@Controller
public class ClassesController {
	
	
	public static int pagesize = 10;
	
	@Resource(name="classesService")
	private ClassesService classesService;
	
	
	@RequestMapping(value="/manager/classes",method=RequestMethod.GET)
	public ModelAndView listStudent(String pagenum,Classes classes){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("classes");
		mv.addObject("sidebar","classes");
		int num = 1;
		if(null!=pagenum){
			num = Integer.parseInt(pagenum);
		}
		List<Classes> list = classesService.listClasses((num-1)*pagesize, pagesize,classes);
		mv.addObject("classesList", list);
		mv.addObject("length", list.size());
		mv.addObject("pagenum", num);
		mv.addObject("classes", classes);
		return mv;
	}

	
	@RequestMapping(value="/manager/addclassespage",method=RequestMethod.GET)
	public ModelAndView addClassesPage(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addclasses");
		mv.addObject("sidebar","classes");
		return mv;
	}
	
	@RequestMapping(value="/manager/addclasses",method=RequestMethod.POST)
	public ModelAndView addClasses(Classes classes){
		ModelAndView mv=new ModelAndView();
		Classes cls = classesService.findClassesById(classes.getId());
		if(null==cls){
			mv.setViewName("redirect:/manager/classes");
			classes.setStudentcount(0);
			classesService.addClasses(classes);
		}else{
			mv.setViewName("redirect:/manager/addclassespage");
			mv.addObject("name", classes.getName());
			mv.addObject("headteacher", classes.getHeadteacher());
			mv.addObject("notice","已存在编号为"+classes.getId()+"的班级");
		}
		return mv;
	}
	
	@RequestMapping(value="/manager/managerstudentpage",method=RequestMethod.GET)
	public ModelAndView studentPage(int classesid){
		ModelAndView mv=new ModelAndView();
		Classes cls = classesService.findClassesById(classesid);
		List<Student> stlist = classesService.findStudentByClassesId(classesid);
		mv.setViewName("addstudents");
		mv.addObject("sidebar","classes");
		mv.addObject("cls",cls);
		mv.addObject("stlist",stlist);
		mv.addObject("length", stlist.size());
		return mv;
	}
	
	@RequestMapping(value="/manager/classesnewspage",method=RequestMethod.GET)
	public ModelAndView classesnewsPage(int classesid){
		ModelAndView mv=new ModelAndView();
		Classes cls = classesService.findClassesById(classesid);
		List<ClassesNews> cnlist= classesService.findClassesNewsByClassId(classesid);
		mv.setViewName("addclassesnews");
		mv.addObject("sidebar","classes");
		mv.addObject("cls",cls);
		mv.addObject("cnlist",cnlist);
		return mv;
	}
	
	@RequestMapping(value="/manager/addclassesnews",method=RequestMethod.POST)
	public ModelAndView addClassesNews(ClassesNews classesNews){
		ModelAndView mv=new ModelAndView();
		classesNews.setInserttime(new Date());
		classesService.addClassesNews(classesNews);
		mv.addObject("notice","添加班级动态成功");
		mv.addObject("classesid",classesNews.getClassid());
		mv.setViewName("redirect:/manager/classesnewspage");
		return mv;
	}
	
	
	@RequestMapping(value="/manager/deleteclassesnews",method=RequestMethod.GET)
	public ModelAndView deleteClassesNews(int classesid,int id){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/manager/classesnewspage");
		mv.addObject("classesid",classesid);
		classesService.deleteClassesNewsById(id);
		mv.addObject("notice","删除动态成功");
		return mv;
	}
	
	
	@RequestMapping(value="/manager/addstudent",method=RequestMethod.POST)
	public ModelAndView addStudent(Student student){
		ModelAndView mv=new ModelAndView();
		Student stu = classesService.findStudentById(student.getId());
		if(stu==null){
			classesService.addStudent(student);
			classesService.updateClassStudentCount(student.getClassid());
			mv.addObject("notice","添加学生成功");
		}else{
			mv.addObject("notice","已经存在编号为"+student.getId()+"的学生("+stu.getName()+")！");
		}
		mv.addObject("classesid",student.getClassid());
		mv.setViewName("redirect:/manager/managerstudentpage");
		return mv;
	}
	
	@RequestMapping(value="/manager/deletestudent",method=RequestMethod.GET)
	public ModelAndView deleteStudent(int studentid,int classid){
		ModelAndView mv=new ModelAndView();
		classesService.deleteStudentById(studentid);
		classesService.updateClassStudentCount(classid);
		mv.addObject("classesid",classid);
		mv.addObject("notice","删除学生信息成功");
		mv.setViewName("redirect:/manager/managerstudentpage");
		return mv;
	}
	
	@RequestMapping(value="/manager/updatestudent",method=RequestMethod.POST)
	public ModelAndView updateStudent(Student student){
		ModelAndView mv=new ModelAndView();
		classesService.updateStudentBy(student); 
		mv.addObject("classesid",student.getClassid());
		mv.addObject("notice","编辑学生信息成功");
		mv.setViewName("redirect:/manager/managerstudentpage");
		return mv;
	}
	
}
