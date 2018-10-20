package com.bwf.service;

import java.util.List;

import com.bwf.entity.AffairChain;

public interface IAffairChainService {

	List<AffairChain> getAffairChainsByAffairId(Integer id);

}
