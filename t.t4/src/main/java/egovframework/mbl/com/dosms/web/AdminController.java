package egovframework.mbl.com.dosms.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.mbl.com.dosms.service.AdminService;
import egovframework.mbl.com.dosms.service.AdminVO;
import egovframework.mbl.com.dosms.service.NightIdVO;

@Controller
public class AdminController {
	
	private String viewAdminList = "egovframework/mbl/com/dosms/prevAdminView";
	private String viewAdminCalender = "egovframework/mbl/com/dosms/adminCalender";
	
	@Resource
	private AdminService adminservice;

	@RequestMapping(value="/adminPrevList.do")
	public String adminPrevList(HttpServletRequest reqst, ModelMap model) {
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		model.addAttribute("adname",reqst.getSession().getAttribute("name"));
		
		return viewAdminList;
	}
	
	@RequestMapping(value="/adminGoNightList.do")
	public String adminGoNightList(HttpServletRequest reqst, ModelMap model, AdminVO adminInfo) {
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		java.util.Date d = new java.util.Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		cal.add(Calendar.DATE, -3);

		java.sql.Date sqlD = new java.sql.Date(cal.getTimeInMillis());

		NightIdVO nightidvo = new NightIdVO();
		nightidvo.setDate(sqlD);
		
		List<?> adminNightCalender = this.adminservice.readAdminNightCalender(nightidvo);

		if(!adminNightCalender.isEmpty()) {
			model.addAttribute("checkCalender",1);
			model.addAttribute("adminNightList",adminNightCalender);
		} else {
			model.addAttribute("checkCalender",0);
		}

		return viewAdminCalender;
	}
	
	
	@RequestMapping(value="/Action/doChange.do")
	public String doChange(HttpServletRequest reqst, ModelMap model, AdminVO adminInfo, @RequestParam("changedateString") String changedateString) {
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		java.sql.Date sqlDateTrans = java.sql.Date.valueOf(changedateString);
		
		adminInfo.setChangedate(sqlDateTrans);
		
		this.adminservice.changeNightDate(adminInfo);
		
		return "redirect:/adminGoNightList.do";
	}
	
	
	
	
	/*
	 * check session method
	 */
	public static Boolean checkSession(HttpServletRequest reqst) {
		
		if(reqst.getSession().getAttribute("id") == null) {
			return false;
		}
		
	    return true;
	}
}
