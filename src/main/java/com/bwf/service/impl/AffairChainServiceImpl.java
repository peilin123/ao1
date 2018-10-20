package com.bwf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairChainMapper;
import com.bwf.entity.AffairChain;
import com.bwf.service.IAffairChainService;

@Service
public class AffairChainServiceImpl implements IAffairChainService {
	@Autowired
	AffairChainMapper affairChainMapper;

	@Override
	public List<AffairChain> getAffairChainsByAffairId(Integer id) {
		// TODO Auto-generated method stub
		return affairChainMapper.getAffairChainsByAffairId( id);
	}

}
