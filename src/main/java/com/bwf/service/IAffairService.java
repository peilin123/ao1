package com.bwf.service;

import com.bwf.entity.Affair;
import com.bwf.entity.User;

public interface IAffairService {

	void add(Affair affair,User currentUser);

}
