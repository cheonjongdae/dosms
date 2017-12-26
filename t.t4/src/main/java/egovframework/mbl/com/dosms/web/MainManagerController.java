package egovframework.mbl.com.dosms.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.mbl.com.dosms.service.MainManagerService;
import egovframework.mbl.com.dosms.service.MainManagerVO;
import egovframework.mbl.com.dosms.service.SectorIdVO;

@Controller
public class MainManagerController {
	
	private int addDayCount = 0;
	private java.sql.Date currentSqlDate;
	
	private String viewMainManager = "egovframework/mbl/com/dosms/mainManager";
	
	@Resource
	private MainManagerService mainmanagerservice;
	
	// go MainManager.jsp
  	public String getViewMainManager() {
  		return this.viewMainManager;
  	}
  	
  	/* MainManager view */
	@RequestMapping(value="/resetMainManager.do")
	public String resetMainManager() {
		addDayCount = 0;
		return "forward:/viewMainManager.do";
	}
  	
  	/* MainManager view */
	@RequestMapping(value="/viewMainManager.do")
	public String viewMainManager(ModelMap model, HttpServletRequest reqst) {
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		java.util.Date d = new java.util.Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, addDayCount);
		
		java.sql.Date sqlD = new java.sql.Date(cal.getTimeInMillis());
		currentSqlDate = sqlD;
		
		SectorIdVO sectoridvo = new SectorIdVO();
		sectoridvo.setToday(sqlD);
		
		int readCheckSubmit = this.mainmanagerservice.readCheckedSubmit(sectoridvo);
		
		model.addAttribute("CheckSubmitMain",readCheckSubmit);
		
		List<?> TotalSectorListManager = this.mainmanagerservice.readTotalSectorListManager();
		List<?> checkedSectorListManager = this.mainmanagerservice.readCheckedSectorListManager(sectoridvo);
		
		model.addAttribute("MainManagerName", reqst.getSession().getAttribute("name"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일"); 
		
		model.addAttribute("currentDate", sdf.format(sqlD.getTime()));
		model.addAttribute("currentDateCount", addDayCount);
		
		model.addAttribute("mainTotalList", TotalSectorListManager);
		
		if(!checkedSectorListManager.isEmpty()) {
			model.addAttribute("mainCheckedList", checkedSectorListManager);
		}
		
		ArrayList<String> colorList1 = new ArrayList<String>();
		
		colorList1.add("#FFD8D8");
		colorList1.add("#FAE0D4");
		colorList1.add("#FAECC5");
		colorList1.add("#FAF4C0");
		colorList1.add("#D2E5A8");
		colorList1.add("#BCE9B7");
		colorList1.add("#C2E2E8");
		colorList1.add("#C8C7ED");
		colorList1.add("#D6C7ED");
		colorList1.add("#EDC7E8");
		
		ArrayList<String> colorList2 = new ArrayList<String>();
		
		colorList2.add("#FFEAEA");
		colorList2.add("#FFF2E6");
		colorList2.add("#FFFED7");
		colorList2.add("#FFFFD2");
		colorList2.add("#E4F7BA");
		colorList2.add("#CEFBC9");
		colorList2.add("#D4F4FA");
		colorList2.add("#DAD9FF");
		colorList2.add("#E8D9FF");
		colorList2.add("#FFD9FA");
		
		model.addAttribute("colorList1", colorList1);
		model.addAttribute("colorList2", colorList2);
		
		return getViewMainManager();
	}
	
	
	/**
	 * MainManager view 
	 * submit action
	 */ 
	@RequestMapping(value="/Action/mainManagerSubmit.do")
	public String mainManagerSubmit(ModelMap model, HttpServletRequest reqst, MainManagerVO mainManagerInfo) {
		
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}

		/* check overlap */
		SectorIdVO sectoridvo = new SectorIdVO();
		sectoridvo.setToday(currentSqlDate);
		
		int checkOverlapCount = this.mainmanagerservice.readCheckedMain(sectoridvo);
		/* check overlap */
		
		if(checkOverlapCount == 0) {
			mainManagerInfo.setDate(currentSqlDate);
			mainManagerInfo.setEmpid((Integer) reqst.getSession().getAttribute("id"));
			
			this.mainmanagerservice.insertMainManagerCheck(mainManagerInfo);
			
		}
		
		return "redirect:/viewMainManager.do";
	}

	/**
	 * MainManager view 
	 * prev action
	 */ 
	@RequestMapping(value="/Action/mainManagerPrev.do")
	public String mainManagerPrev(ModelMap model, HttpServletRequest reqst) {
		addDayCount--;
		
		return "forward:/viewMainManager.do";
	} 
	
	/**
	 * MainManager view 
	 * next action
	 */
	@RequestMapping(value="/Action/mainManagerNext.do")
	public String mainManagerNext(ModelMap model, HttpServletRequest reqst) {
		addDayCount++;
		
		return "forward:/viewMainManager.do";
	}

	/**
	 * check session method
	 */
	public static Boolean checkSession(HttpServletRequest reqst) {
		
		if(reqst.getSession().getAttribute("id") == null) {
			return false;
		}
		
	    return true;
	}
}
