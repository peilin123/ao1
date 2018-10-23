package com.bwf.dao;

import com.bwf.entity.AttendanceSign;

public interface AttendanceSignMapper {

	void save(AttendanceSign as);

	void update(AttendanceSign as);

	AttendanceSign getAttsByDate(String dayString);

	AttendanceSign getAttsByatts(AttendanceSign as);

	

	

	

}
