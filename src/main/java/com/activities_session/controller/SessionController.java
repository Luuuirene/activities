package com.activities_session.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.activities_item.service.ItemService;
import com.activities_session.model.SessionVO;
import com.activities_session.service.SessionService;

@Controller
@RequestMapping("/session")
public class SessionController {
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	ItemService itemService;
	
	/*
	 * 如要新增時
	 * This method will serve as addSession.html handler.
	 */
	@GetMapping("addSession")
	public String addSession(ModelMap model) {
		
		SessionVO sessionVO = new SessionVO();
		model.addAttribute("sessionVO", sessionVO);
		System.out.println("轉交請求");
		return "back-end/sesssion/addSession";
	}
	
	/*
	 * This method will be called on addSession.html form submission, handling POST request It also validates the user input
	 * 新增
	 * BindingResult:配合@Valid一起使用，用于接收bean中的校验信息
	 */
	@PostMapping("insert")
	public String insert(@Valid SessionVO sessionVO, BindingResult result, ModelMap model) {
		
/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		
    	if(result.hasErrors()) {
    		System.out.println("資料有誤");
    		return "back-end/session/addSession";
    	}
    	/*************************** 2.開始新增資料 *****************************************/
		sessionService.addSession(sessionVO);
		/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
		List<SessionVO> list = sessionService.getAll();
		model.addAttribute("sessionListData", list);
		model.addAttribute("success", "- (新增成功)");
		return "redirect:/session/listAllSession"; // 新增成功後重導至IndexController_inSpringBoot.java的第58行@GetMapping("/emp/listAllEmp")
    	
	}
	
	/*
	 * This method will be called on listAllSession.html form submission, handling POST request
	 * 刪除
	 */
	@PostMapping("delete")
	public String delete(@RequestParam("activitySessionId") String activitySessionId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始刪除資料 *****************************************/
		sessionService.deleteSession(Integer.valueOf(activitySessionId));
		/*************************** 3.刪除完成,準備轉交(Send the Success view) **************/
		List<SessionVO> list = sessionService.getAll();
		model.addAttribute("sessionListData", list);
		model.addAttribute("success", "- (刪除成功)");
		return "back-end/session/listAllSession"; // 刪除完成後轉交listAllSession.html
	}
	
	/*
	 * 如要修改時
	 * This method will be called on listAllSession.html form submission, handling POST request
	 */
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("activitySessionId") String activitySessionId, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始查詢資料 *****************************************/
		SessionVO sessionVO = sessionService.getOneSession(Integer.valueOf(activitySessionId));
		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
		model.addAttribute("sessionVO", sessionVO);
		System.out.println("修改開始");
		return "back-end/session/update_session_input"; // 查詢完成後轉交update_session_input.html
		
	}
	
	@PostMapping("update")
	public String update(@Valid SessionVO sessionVO, BindingResult result, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		if(result.hasErrors()) {
			System.out.println("資料不全");
			return "back-end/session/update_session_input";
		}
		/*************************** 2.開始修改資料 *****************************************/
		sessionService.updateSessiom(sessionVO);
		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		sessionVO = sessionService.getOneSession(Integer.valueOf(sessionVO.getActivitySessionId()));
		model.addAttribute("sessionVO", sessionVO);
		return "back-end/session/listOneSession";
		
	}
	
	/*
     * This method will be called on select_session.html form submission, handling POST request
     *複合查詢
     */
	@PostMapping("listSession_ByCompositeQuery")
	public String listAllSession(HttpServletRequest req, Model model) {
		Map<String, String[]> map = req.getParameterMap();//複合請求
		List<SessionVO> list = sessionService.getAll(map); //搜尋的範圍列出
		model.addAttribute("sessionListData", list);
		return "back-end/session/listAllSession";
	}
	
}
