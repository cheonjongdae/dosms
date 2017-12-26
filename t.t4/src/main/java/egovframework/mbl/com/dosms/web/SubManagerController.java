package egovframework.mbl.com.dosms.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.mbl.com.dosms.service.SectorIdVO;
import egovframework.mbl.com.dosms.service.SubManagerService;
import egovframework.mbl.com.dosms.service.SubManagerVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class SubManagerController {
	private int addDayCount = 0;
	private java.sql.Date currentSqlDate;
	
	private String viewSubManager = "egovframework/mbl/com/dosms/subManager";
	
	@Resource
	private SubManagerService submangerservice;
	
	// 첨부파일 관련
    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileMngService;

    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;
    
	// go SubManager.jsp
  	public String getViewSubManager() {
  		return this.viewSubManager;
  	}
  	
  	/* SubManager view */
	@RequestMapping(value="/resetSubManager.do")
	public String resetSubManager() {
		addDayCount = 0;
		return "forward:/viewSubManager.do";
	}
  	

  	/* SubManager view */
	@RequestMapping(value="/viewSubManager.do")
	public String viewSubManager(ModelMap model, HttpServletRequest reqst) {
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
		sectoridvo.setStid((String) reqst.getSession().getAttribute("managersecid"));

		List<?> subManagerCheckListFinal = this.submangerservice.readCheckListFinal(sectoridvo);
		List<?> subManagerCheckListNight = this.submangerservice.readCheckListNight(sectoridvo);
		
		if(!subManagerCheckListFinal.isEmpty()) {
			
			EgovMap record1 = (EgovMap) subManagerCheckListFinal.get(0);
			
			model.addAttribute("subManagerCheckListFinal", subManagerCheckListFinal);
			model.addAttribute("subManagerCheckListFinal2", record1);
			model.addAttribute("att2", ((EgovMap)subManagerCheckListFinal.get(0)).get("appendpicFinal"));
		}
		
		
		if(!subManagerCheckListNight.isEmpty()) {
			EgovMap record2 = (EgovMap) subManagerCheckListNight.get(0);
			
			model.addAttribute("subManagerCheckListNight", subManagerCheckListNight);
			model.addAttribute("subManagerCheckListNight2", record2);
			model.addAttribute("att3", ((EgovMap)subManagerCheckListNight.get(0)).get("appendpicNight"));
		}
		
		model.addAttribute("SubManagerName", reqst.getSession().getAttribute("name"));
		model.addAttribute("SubManagerSector", reqst.getSession().getAttribute("managersecid"));
		model.addAttribute("SubManagerSectorName", reqst.getSession().getAttribute("managersecnm"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일"); 

		model.addAttribute("currentDate", sdf.format(sqlD.getTime()));
		model.addAttribute("currentDateCount", addDayCount);
		
		int subManagerChecked = this.submangerservice.readChecked(sectoridvo);
		model.addAttribute("submitStand", subManagerChecked);
		
		model.addAttribute("att", "FILE_000000000000000");
		
		return getViewSubManager();
	}
	
	/**
	 * SubManager view 
	 * submit action
	 */ 
	@RequestMapping(value="/Action/subManagerSubmit.do")
	public String subManagerSubmit(ModelMap model, HttpServletRequest reqst, SubManagerVO subManagerInfo) {
		
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}

		/* check overlap */
		SectorIdVO sectoridvo = new SectorIdVO();
		sectoridvo.setToday(currentSqlDate);
		sectoridvo.setStid((String) reqst.getSession().getAttribute("managersecid"));
		
		int checkOverlapCount = this.submangerservice.readChecked(sectoridvo);
		/* check overlap */
		
		if(checkOverlapCount == 0) {
			subManagerInfo.setDatee(currentSqlDate);
			subManagerInfo.setSectorid((String) reqst.getSession().getAttribute("managersecid"));
			subManagerInfo.setEmpid((Integer) reqst.getSession().getAttribute("id"));
			
			this.submangerservice.insertSubManagerCheck(subManagerInfo);
		}
		
		return "redirect:/viewSubManager.do";
	}

	/**
	 * SubManager view 
	 * prev action
	 */ 
	@RequestMapping(value="/Action/subManagerPrev.do")
	public String subManagerPrev() {
		addDayCount--;
		
		return "forward:/viewSubManager.do";
	} 
	
	/**
	 * SubManager view 
	 * next action
	 */
	@RequestMapping(value="/Action/subManagerNext.do")
	public String subManagerNext() {
		addDayCount++;
		
		return "forward:/viewSubManager.do";
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
