package com.test.Autowired;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activities_category.model.CategoryVO;
import com.activities_category.service.CategoryService;

@Controller
public class Demo_SpringDataJPA_Controller_testDS4 {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/testDS4")
	@ResponseBody
	public String testDS()throws SQLException{
		
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setActivityCategoryName("親子活動");
		categoryVO.setActivityCategoryInfo("Test");
		categoryService.addCategory(categoryVO);
		
		return "Test testDS4-EmpRepository OK";
	}
	

}
