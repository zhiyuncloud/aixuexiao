package com.aixuexiao.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aixuexiao.model.Exam;
import com.aixuexiao.model.ExamMark;

/**
 * 考试相关工具类
 */
public class ExamUtil {

	/**
	 * 为考试成绩排序 并计算平均分/最高分/最低发
	 * @param exam 考试对象
	 * @return
	 */
	public static Exam  sortExamMark(Exam exam){
		List<ExamMark> ems = exam.getExamMarks();
		Collections.sort(ems);//对分数进行排序
		BigDecimal topmark = null,lowestmark = null,total = new BigDecimal(0);
		int rank = ems.size();
		for(int i = 0;i<ems.size();i++){
			ExamMark em = ems.get(i);
			if(i==0)lowestmark = em.getMark();//最低分
			if(i==ems.size()-1)topmark = em.getMark();//最高分
			em.setExamtime(exam.getExamtime());
			em.setRank(rank--);
			total = total.add(em.getMark());
		}
		exam.setAverage(total.divide(new BigDecimal(ems.size()),2, BigDecimal.ROUND_DOWN));
		exam.setTopmark(topmark);
		exam.setLowestmark(lowestmark);
		return exam;
	}
	
}
