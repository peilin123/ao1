package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.AffairChain;

public interface AffairChainMapper {

	void add(@Param("affairChains") List<AffairChain> affairChains);

	List<AffairChain> getAffairChainsByAffairId(Integer id);

}
