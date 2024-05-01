package com.activities_photo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.activities_item.model.ItemVO;
import com.activities_item.service.ItemService;
import com.activities_photo.model.PhotoVO;
import com.activities_photo.service.PhotoService;


@Controller
@RequestMapping("/photo")
public class PhotoController {
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	ItemService itemService;
	
	/*
	 * 如要新增時
	 * This method will serve as addPhoto.html handler.
	 */
	@GetMapping("addPhoto")
	public String addPhoto(ModelMap model) {
		PhotoVO photoVO = new PhotoVO();
		model.addAttribute("photoVO", photoVO);
		System.out.println("轉交請求");
		return "back-end/photo/addPhoto";
	}
	
	/*
	 * This method will be called on addPhoto.html form submission, handling POST request It also validates the user input
	 * 新增
	 * BindingResult:配合@Valid一起使用，用于接收bean中的校验信息
	 */
	@PostMapping("insert")
	public String insert(@Valid PhotoVO photoVO, BindingResult result, ModelMap model,
			@RequestParam("activityPhoto") MultipartFile[] parts) throws IOException{
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		// 去除BindingResult中upFiles欄位的FieldError紀錄
    	result = removeFieldError(photoVO, result, "activityPhoto");
    	if(parts[0].isEmpty()) {// 使用者未選擇要上傳的圖片時
    		model.addAttribute("errorMessage", "請上傳活動照片！");
    	}else {
    		for(MultipartFile multipartFile : parts) {
    			byte[] buf = multipartFile.getBytes();
    			photoVO.setActivityPhoto(buf);
    		}
    	}
		
		if(result.hasErrors() || parts[0].isEmpty()) {
    		System.out.println("資料有誤");
    		return "back-end/photo/addPhoto";
    	}
    	/*************************** 2.開始新增資料 *****************************************/
    	photoService.addPhoto(photoVO);
    	/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
    	List<PhotoVO> list = photoService.getAll();
    	model.addAttribute("photoListData", list);
    	model.addAttribute("success", "- (新增成功)");
    	return "redirect:/photo/listAllPhoto"; // 新增成功後重導至IndexController_inSpringBoot.java的第58行@GetMapping("/emp/listAllEmp")
	}
	
	/*
	 * This method will be called on listAllCategory.html form submission, handling POST request
	 * 刪除
	 */
	@PostMapping("delete")
	public String delete(@RequestParam("activityPhotoId") String activityPhotoId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始刪除資料 *****************************************/
		photoService.deletePhoto(Integer.valueOf(activityPhotoId));
		/*************************** 3.刪除完成,準備轉交(Send the Success view) **************/
		List<PhotoVO> list = photoService.getAll();
		model.addAttribute("categoryListData", list);
		model.addAttribute("success", "- (刪除成功)");
		return "back-end/photo/listAllPhoto"; // 刪除完成後轉交listAllPhoto.html
	}
	
	/*
	 * Method used to populate the List Data in view. 如 : 
	 * <form:select path="deptno" id="deptno" items="${deptListData}" itemValue="deptno" itemLabel="dname" />
	 */
	@ModelAttribute("itemListData")
	protected List<ItemVO> referenceListData(){
		List<ItemVO> list = itemService.getAll();
		return list;
	}
	
	
	/*
	 * This method will be called on listAllPhoto.html form submission, handling POST request
	 */
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("activityPhotoId") String activityPhotoId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始查詢資料 *****************************************/
		PhotoVO photoVO = photoService.getOnePhoto(Integer.valueOf(activityPhotoId));
		
		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
		model.addAttribute("photoVO", photoVO);
		System.out.println("修改開始");
		return "back-end/photo/update_photo_input"; // 查詢完成後轉交update_photo_input.html
		
	}
	
	/*
	 * This method will be called on update_photo_input.html form submission, handling POST request It also validates the user input
	 */
	@PostMapping("update")
	public String update(@Valid PhotoVO photoVO, BindingResult result, ModelMap model,
			@RequestParam("activityPhoto") MultipartFile[] parts) throws IOException {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		// 去除BindingResult中activityPhoto欄位的FieldError紀錄 
		result = removeFieldError(photoVO, result, "activityPhoto");
		
		if (parts[0].isEmpty()) { // 使用者未選擇要上傳的新圖片時
			
			byte[] activityPhoto = photoService.getOnePhoto(photoVO.getActivityPhotoId()).getActivityPhoto();
			photoVO.setActivityPhoto(activityPhoto);
		} else {
			for (MultipartFile multipartFile : parts) {
				byte[] activityPhoto = multipartFile.getBytes();
				photoVO.setActivityPhoto(activityPhoto);
			}
		}
		if (result.hasErrors()) {
			System.out.println("資料不全");
			return "back-end/photo/update_photo_input";
		}
		/*************************** 2.開始修改資料 *****************************************/
		photoService.updatePhoto(photoVO);
		
		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		photoVO = photoService.getOnePhoto(Integer.valueOf(photoVO.getActivityPhotoId()));
		model.addAttribute("photoVO", photoVO);
		return "back/photo/listOnePhoto"; // 修改成功後轉交listOnePhoto.html
	}
	
	/*
     * This method will be called on select_photo.html form submission, handling POST request
     *複合查詢
     */
	@PostMapping("listPhoto_ByCompositeQuery")
	public String listAllPhoto(HttpServletRequest req, Model model) {
		Map<String, String[]> map = req.getParameterMap();
		List<PhotoVO> list = photoService.getAll(map);
		model.addAttribute("photoListData", list); // for listAllPhoto.html 用
		return "back/photo/listAllPhoto";
	}
	
	
	
	// 去除BindingResult中某個欄位的FieldError紀錄
		public BindingResult removeFieldError(PhotoVO photoVO, BindingResult result, String removedFieldname) {
			List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
					.filter(fieldname -> !fieldname.getField().equals(removedFieldname))
					.collect(Collectors.toList());
			result = new BeanPropertyBindingResult(photoVO, "photoVO");
			for (FieldError fieldError : errorsListToKeep) {
				result.addError(fieldError);
			}
			return result;
		}
}
