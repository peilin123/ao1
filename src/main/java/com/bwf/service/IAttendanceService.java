package com.bwf.service;

import com.bwf.entity.AttendanceSign;

public interface IAttendanceService {

	String save(AttendanceSign as);

	String update(AttendanceSign as);

	AttendanceSign getAttsByDate(String dayString);

	

}
