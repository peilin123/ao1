package com.bwf.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwf.entity.AttendanceSign;
import com.bwf.entity.Time;
import com.bwf.entity.User;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
	
	@Autowired
	com.bwf.service.IAttendanceService  attendanceService;
	
	@RequestMapping("show")
	public String show(){
		
		return "attendance/show";
	}
	
	@GetMapping("sign")
	public String sign(ModelMap modelMap){
		Date day=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");  
	    String dateString = formatter.format(day);
		modelMap.addAttribute("daytime",dateString);
		return "attendance/sign";
	}
	
	@GetMapping("addSign")
	@ResponseBody
	public Time addSign(Integer id ,String comment,ModelMap modelMap,HttpSession session){

		Time t = new Time();

		User user=(User)session.getAttribute("Okuser");
		//id=1表示上班时间
	    if(id==1){
	    	Date day1=new Date();
	    	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");  
		    String dateString1 = formatter1.format(day1);
		   
		    SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd ");  
		    String date1 = formatter4.format(day1);
		    System.out.println("上午日期:"+date1);
		    //上班考勤打卡对象
		    AttendanceSign as=new AttendanceSign();
		    as.setUserId(user.getUserId());
		    as.setSignInTime(dateString1);
		    as.setSignInComment(comment);
		    as.setDateString(date1);
		    
		   String rt =attendanceService.save(as);
		   t.setCardTime(rt);
	    }
	    //id=2表示下班时间
	    else if (id==2){
	    	Date day2=new Date();
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");  
		    String dateString2 = formatter2.format(day2);
		    
		    SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd ");  
		    String date2 = formatter3.format(day2);
		  //下班考勤打卡对象
		    AttendanceSign as=new AttendanceSign();
		    as.setUserId(user.getUserId());
		    as.setSignOutTime(dateString2);
		    as.setSignOutComment(comment);
		   as.setDateString(date2);
		   //返回下班时间字符串
		   String xia =attendanceService.update(as);
		   t.setCardTime(xia); 
	    }
	    else{
	    	System.out.println("other");
	    	 t.setCardTime("request id error");
	    }
	  
	    return t;
	}
	
	
	@GetMapping("signts")
	public String signts(){
		
		return "attendance/signts";
	}

}
