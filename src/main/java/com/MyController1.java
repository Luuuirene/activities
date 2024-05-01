package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activities_category.model.CategoryVO;
import com.activities_category.service.CategoryService;
import com.activities_item.model.ItemVO;
import com.activities_item.service.ItemService;

@Controller  //p.65、77、139
public class MyController1 {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ItemService itemService;
	
//	@GetMapping("/") //p.65、77、139
//	public String myMethod1() {
//		return "form1";  // -->p.264 /src/main/resources/templates/form1.html (預設位置) 
//	}
	@GetMapping("/form2") //p.65、77、139
	public String myMethod2() {
		return "form2";  // -->p.264 /src/main/resources/templates/form2.html (預設位置) 
	}
	@GetMapping("/form3") //p.65、77、139
	@ResponseBody
	public String myMethod3() {
		return "<font color=red><b>form3</b></font>";  
	}
	
	@GetMapping("/")
	public String index(Model model) {
		return "activity_management";
	}
	
	@GetMapping("/category/select_category")
	public String select_category(Model model) {
		return "back-end/category/select_category";
	}
	
	@GetMapping("/category/listAllCategory")
	public String listAllCategory(Model model) {
		return "back-end/category/listAllCategory";
	}
	
	@ModelAttribute("categoryListData") // 下拉選單、SHOW跑出DB已有的值 for select_page.html 第97 109行用 // for listAllEmp.html 第85行用
	protected List<CategoryVO> referenceListData(Model model){
		
		List<CategoryVO> list = categoryService.getAll();
		return list;
	}
	
	
	@GetMapping("/item/select_item")
	public String select_item(Model model) {
		return "back-end/item/select_item";
	}
	
	@GetMapping("/item/listAllItem")
	public String listAllItem(Model model) {
		return "back-end/item/listAllItem";
	}
	
	@ModelAttribute("itemListData") // 下拉選單、SHOW跑出DB已有的值 for select_page.html 第97 109行用 // for listAllEmp.html 第85行用
	protected List<ItemVO> referenceListData2(Model model){
		
		List<ItemVO> list = itemService.getAll();
		return list;
	}
	
	@ModelAttribute("categoryListData2") // 下拉選單、SHOW跑出DB已有的值 for select_page.html 第97 109行用 // for listAllEmp.html 第85行用
	protected List<CategoryVO> referenceListData_Cate(Model model){
		model.addAttribute("categoryVO", new CategoryVO());
		List<CategoryVO> list = categoryService.getAll();
		return list;
	}
	
	

}
