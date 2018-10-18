package com.bwf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairChainMapper;
import com.bwf.dao.AffairMapper;
import com.bwf.dao.AffairModuleChainMapper;
import com.bwf.dao.UserMapper;
import com.bwf.entity.Affair;
import com.bwf.entity.AffairChain;
import com.bwf.entity.AffairModuleChain;
import com.bwf.entity.User;
import com.bwf.service.IAffairService;

@Service
public class AffairServiceImpl implements IAffairService {
	
	@Autowired
	AffairMapper affairMapper;
	
	@Autowired
	AffairModuleChainMapper affairModuleChainMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	AffairChainMapper affairChainMapper;

	@Override
	public void add(Affair affair, User currentUser) {
		// TODO Auto-generated method stub
		affairMapper.add( affair );
		
		// 获取 当前登录员工的上级
				User userWithLeader = userMapper.getUserWithLeader( currentUser );
				
				// 获取 AffairModuleChains 集合 
				List<AffairModuleChain> affairModuleChains
					= affairModuleChainMapper.getAffairModuleChainsByAffairModuleId( affair.getAffairModule().getAffairModuleId() );
						
				// 往 公文审批流程表中 添加 若干条数据	
				List<AffairChain> affairChains = new ArrayList<AffairChain>();
				for( int i=0;i<affairModuleChains.size(); i++ ){
					AffairChain affairChain = new AffairChain();
					affairChain.setAffairId(  affair.getAffairId() );
					affairChain.setAffairChainOrder( i+1 );
					affairChain.setAffairChainStatus(0);
					if ( affairModuleChains.get(i).getApproverId()== -1 ) {
						// 设置为 当前已登录员工的 上级
						//System.out.println(userWithLeader.getLeader().getUserId());
						System.out.println(currentUser.getLeader());
						//affairChain.setApprover( currentUser.getLeader().getUserId() ); 
						affairChain.setApprover( 1 ); 
					} else {
						// 就设置为当前值
						affairChain.setApprover( affairModuleChains.get(i).getApproverId() );
					}		
					
					affairChains.add(affairChain);
				}
				affairChainMapper.add ( affairChains );
		
	}

}
