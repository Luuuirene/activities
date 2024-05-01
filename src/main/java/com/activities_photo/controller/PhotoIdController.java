package com.activities_photo.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Digits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.activities_item.model.ItemVO;
import com.activities_item.service.ItemService;
import com.activities_photo.model.PhotoVO;
import com.activities_photo.service.PhotoService;


@Controller
@Validated
@RequestMapping("/photo")
public class PhotoIdController {
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	ItemService itemService;
	
	/*
	 * This method will be called on select_photo.html form submission, handling POST
	 * request It also validates the user input
	 */
	@PostMapping("getOne_For_Display")
	public String getOne_For_Display(
			/***************************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			@Digits(integer = 4, fraction = 0, message = "活動照片編號請填寫整數！" )
			@RequestParam("activityPhotoId") String activityPhotoId, 
			ModelMap model) {
		/***************************2.開始查詢資料*********************************************/
		PhotoVO photoVO = photoService.getOnePhoto(Integer.valueOf(activityPhotoId));
		List<PhotoVO> list = photoService.getAll();
		model.addAttribute("photoListData", list);
		model.addAttribute("itemVO", new ItemVO());
		List<ItemVO> list2 = itemService.getAll();
		model.addAttribute("itemListData", list2);
		
		if(photoVO == null) {
			model.addAttribute("errorMessage", "查無資料");
			return "back-end/photo/select_photo";
		}
		/***************************3.查詢完成,準備轉交(Send the Success view)*****************/
		model.addAttribute("photoVO", photoVO);
		model.addAttribute("getOne_For_Display", "true");
		
		return "back-end/photo/select_photo";
	}
	
	@ExceptionHandler(value = {ConstraintViolationException.class})
	public ModelAndView handleError(HttpServletRequest req,ConstraintViolationException e,Model model) {
	    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
	    StringBuilder strBuilder = new StringBuilder();
	    for (ConstraintViolation<?> violation : violations ) {
	          strBuilder.append(violation.getMessage() + "<br>");
	    }
	    //==== 以下是當前面第64行返回 /src/main/resources/templates/back-end/photo/select_photo.html用的 ====  

		List<PhotoVO> list = photoService.getAll();
		model.addAttribute("photoListData", list);     // for select_page.html 第97 109行用
		model.addAttribute("itemVO", new ItemVO());  // for select_page.html 第133行用
		List<ItemVO> list2 = itemService.getAll();
    	model.addAttribute("itemListData",list2);    // for select_page.html 第135行用
		String message = strBuilder.toString();
	    return new ModelAndView("back-end/photo/select_photo", "errorMessage", "請修正以下錯誤:<br>"+message);
	}

}
