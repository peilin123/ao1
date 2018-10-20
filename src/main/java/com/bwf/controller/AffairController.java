package com.bwf.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Affair;
import com.bwf.entity.AffairChain;
import com.bwf.entity.AffairModule;
import com.bwf.entity.User;
import com.bwf.service.IAffairChainService;
import com.bwf.service.IAffairModuleService;
import com.bwf.service.IAffairService;
import com.bwf.service.IModuleOptionService;

@RequestMapping("affair")
@Controller
public class AffairController {
	
	@Autowired
	IAffairModuleService affairModuleService;
	
	@Autowired
	IModuleOptionService moduleOptionService;

	@Autowired
	IAffairService affairService;
	
	@Autowired
	IAffairChainService affairChainService;

	@GetMapping("show")
	public String show(ModelMap modelMap,HttpSession session){		
		User currentUser = (User) session.getAttribute("Okuser");
		List<Affair>affairByMe=affairService.getAffairByMe( currentUser );
		
		modelMap.addAttribute("affairModules", affairModuleService.getAll() );
		modelMap.addAttribute("affairByMe", affairByMe );
		return "affair/show";
	}
	
	@GetMapping("add")
	public String add( Integer affairModuleId , ModelMap modelMap){
		
		modelMap.addAttribute("moduleOptions", moduleOptionService.getModuleOptionsByAffairModuleId(affairModuleId)) ;
		modelMap.addAttribute("affairModuleId", affairModuleId);
		return "affair/add";
	}
	
	@GetMapping("doAdd")
	public String doAdd( Integer affairModuleId ,  String html , HttpSession session ){
		Affair affair = new Affair();
		AffairModule affairModule = new AffairModule();
		affairModule.setAffairModuleId(affairModuleId);
		affair.setAffairModule(affairModule);
		affair.setAffairData(html);
		User currentUser=(User)session.getAttribute("Okuser");
		affair.setProposer( currentUser  );
		affair.setAffairStatus(0);
		affairService.add( affair, currentUser );
		return "redirect:/affair/show";
	}
	
	@GetMapping("detail/{id}")
	public String detail(  @PathVariable Integer id , ModelMap modelMap){
		Affair affair=affairService.getAffairByAffairId(id);
		modelMap.addAttribute("affair", affair);
		List<AffairChain> affairChains=affairChainService.getAffairChainsByAffairId(id);
		modelMap.addAttribute("affairChains", affairChains);
		
		return "affair/detail";
	}
	
	
	
	
}
