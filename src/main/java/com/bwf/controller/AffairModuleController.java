package com.bwf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.AffairModule;
import com.bwf.service.IDepartmentService;


// 公文模板控制器 
@Controller
@RequestMapping("affair_module")
public class AffairModuleController {
	
	@Autowired
	IDepartmentService departmentService;

	@GetMapping("show")
	public String show(){
		
		return "affair_module/show";
	}
	
	@GetMapping("add")
	public String add(ModelMap modelMap){
		
		modelMap.addAttribute("allDepartments", departmentService.getAll() ) ;
		return "affair_module/add";
	}
	
	@PostMapping("doAdd")
	public String doAdd( AffairModule affairModule , 
			String[] optionName , 
			Integer[] optionId , 
			String[] optionData ,
			Integer[] approverId 
	) {
		// 公文模板表 新增一条数据
		System.out.println( affairModule.getAffairModuleName() );
		
		for( int i=0; i < optionName.length ; i++) {
			System.out.println( optionId[i] + ":" + optionName[i] );
			if ( !optionData[i].trim().isEmpty() ) {
				System.out.println( "\t" + optionData[i] );
			}
		}
		
		// 模板选项关系表中 新增 n 条数据
		//   1) 获取 刚刚 公文模板表中新增的数据的自增列的值？
		
		//  如果该选项有选项数据 
		//   往 该选项对应的选项数据表中 填写对应的m条数据
		//
		
		
		// 往模板审批表中写入l条数据
		System.out.print( "审批人编号：" );
		for( int i=0;i<approverId.length ; i++ ) {
			 System.out.print( approverId[i] + "," );
		}
		
		return null;
	}
	
	
}
