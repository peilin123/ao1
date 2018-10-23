package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.entity.AttendanceSign;
import com.bwf.service.IAttendanceService;

@Service
public class AttendanceSignServiceImpl implements IAttendanceService {
	
	@Autowired
	com.bwf.dao.AttendanceSignMapper attendanceSignMapper;

	@Override
	public String save(AttendanceSign as) {
		// TODO Auto-generated method stub
		
		//先看数据库当天上班时间是否为空
		AttendanceSign as2= attendanceSignMapper.getAttsByatts(as);
		if(as2==null){
			attendanceSignMapper.save(as);
			return "今天你的上班时间是："+as.getSignInTime();
		}else{
			return "今天你已打上班卡，时间为："+as2.getSignInTime();
		}
		
	}

	@Override
	public String update(AttendanceSign as) {
		// TODO Auto-generated method stub
		
		//先看数据库当天下班时间是否为空
		AttendanceSign as2= attendanceSignMapper.getAttsByatts(as);
		if(as2.getSignOutTime()==null){
			attendanceSignMapper.update(as);
			return "今天你的下班时间是："+as.getSignOutTime();
		}else{
			return "今天你已打下班卡，时间为："+as2.getSignOutTime();
		}
		
		
		
		
	}
	

	@Override
	public AttendanceSign getAttsByDate(String dayString) {
		// TODO Auto-generated method stub
		return attendanceSignMapper.getAttsByDate(dayString);
	}

}
