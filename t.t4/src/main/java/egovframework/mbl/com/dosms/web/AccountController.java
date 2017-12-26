package egovframework.mbl.com.dosms.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.mbl.com.dosms.service.AccountService;
import egovframework.mbl.com.dosms.service.AccountVO;
import egovframework.mbl.com.dosms.service.ExterminatorVO;
import egovframework.mbl.com.dosms.service.NightIdVO;

@Controller
public class AccountController {
	
	private String viewHello = "egovframework/mbl/com/dosms/newAccountForm";
	
	private String viewFinalPrevList = "egovframework/mbl/com/dosms/prevFinalView";
	
	@Resource
	private AccountService accountservice;
	
	//go newAccountForm.jsp
	public String getViewHello() {
		return this.viewHello;
	}
	
	/* login view start */
	@RequestMapping(value="/hello.do")
	public String helloworld(ModelMap model) {
		model.addAttribute("accountinfo", new AccountVO());
		return getViewHello();
	}

	
	/* 
	 * login button action
	 * */
	@RequestMapping(value="Action/login.do")
	public String goMain(HttpServletRequest reqst, ModelMap model, @ModelAttribute("accountinfo")AccountVO accountInfo) {
		model.addAttribute("accountinfo", accountInfo);
		model.addAttribute("exterminatorInfo", new ExterminatorVO());
		
		int checkId = this.accountservice.checkId(accountInfo);
		int checkIdPassword = this.accountservice.checkIdPassword(accountInfo);
		
		int loginCheck = -1;

		if(checkId == 1) {
			if(checkIdPassword == 1) {
				loginCheck = 100;
			} else if(checkIdPassword == 0) {
				loginCheck = 50;
			} else {
				loginCheck = -100;
			}
		} else if(checkId == 0) {
			loginCheck = -1;
		} else {
			loginCheck = -101;
		}

		
		if(loginCheck == 100) {
			model.addAttribute("loginAccept","success");
			
			if(reqst.getSession().getAttribute("id") != null) {
				reqst.getSession().invalidate();
			}
			
			int depId = this.accountservice.readDeptId(accountInfo);
			accountInfo.setDeptid(depId);
			
			String sectorId = this.accountservice.readSecId(accountInfo);
			accountInfo.setSectorid(sectorId);
			
			String sectorNm = this.accountservice.readSecNm(accountInfo);
			
			String empname = this.accountservice.readName(accountInfo);
			
			HttpSession session = reqst.getSession();
			session.setAttribute("id", accountInfo.getAccount());
			session.setAttribute("depid", accountInfo.getDeptid());
			session.setAttribute("secid", sectorId);
			session.setAttribute("secnm", sectorNm);
			session.setAttribute("name", empname);
			session.setMaxInactiveInterval(60*60);
			
			/* 
			 * id, password 일치한 유저가 main manager인지 여부 판단
			 * */

			if(accountInfo.getAccount() == 999999) {
				return "forward:/adminPrevList.do";
			}
			
			/* 
			 * id, password 일치한 유저가 main manager인지 여부 판단
			 * */
			int checkMainManager = this.accountservice.checkMainManager(accountInfo);
			
			if(checkMainManager == 1) {
				return "forward:/resetMainManager.do";
			}
			
			/* 
			 * id, password 일치한 유저가 sub manager인지 여부 판단
			 * */
			int checkSubManager = this.accountservice.checkSubManager(accountInfo);
			
			if(checkSubManager == 1) {
				String managerSectorId = this.accountservice.readManagerSecId(accountInfo);
				String managerSectorNm = this.accountservice.readManagerSecNm(accountInfo);
				
				session.setAttribute("managersecid", managerSectorId);
				session.setAttribute("managersecnm", managerSectorNm);
				
				return "forward:/resetSubManager.do";
			}

			/* 
			 * id, password 일치한 유저가 당직자인지 여부 판단
			 * */
			java.util.Date d = new java.util.Date();
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			
			if(cal.get(Calendar.DAY_OF_WEEK) == 1) {
				cal.add(Calendar.DATE, -2);
			} else if(cal.get(Calendar.DAY_OF_WEEK) == 7) {
				cal.add(Calendar.DATE, -1);
			}
			
			if(Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) >= 0 && Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) <= 60000) {
				cal.add(Calendar.DATE, -1);
			}
			
			java.sql.Date sqlD = new java.sql.Date(cal.getTimeInMillis());
			
	        NightIdVO nightid = new NightIdVO();
	        nightid.setDate(sqlD);
	        nightid.setEnid(accountInfo.getAccount());

			int exterminatorCount = this.accountservice.readNWId(nightid);
			int exterminatorCountTotal = this.accountservice.readNWIdTotal(nightid);
			
			if(exterminatorCount == 1 && exterminatorCountTotal == 1) {
				return "forward:/exterminatorPrevList.do";
			}
			
			return "forward:/finalPrevList.do";

		} else if (loginCheck == 50) {
			model.addAttribute("loginAccept","password do not match");
		} else if (loginCheck == -1){
			model.addAttribute("loginAccept","no id");
		} else {
			model.addAttribute("loginAccept","error");
		}

		return getViewHello();
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
