package egovframework.mbl.com.dosms.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.mbl.com.dosms.service.FinalService;
import egovframework.mbl.com.dosms.service.FinalVO;
import egovframework.mbl.com.dosms.service.NightIdVO;
import egovframework.mbl.com.dosms.service.SectorIdVO;

@Controller
public class FinalController {
	
	private String viewFinal = "egovframework/mbl/com/dosms/final";
	private String viewFinish = "egovframework/mbl/com/dosms/finish";
	
	private String viewFinalPrevList = "egovframework/mbl/com/dosms/prevFinalView";
	private String viewCalender= "egovframework/mbl/com/dosms/workingCalender";
	private String viewTips = "egovframework/mbl/com/dosms/workingTips";
	
	@Resource
	private FinalService finalservice;
	
	// 첨부파일 관련
    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileMngService;

    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;
    
    //go final.jsp
  	public String getViewFinal() {
  		return this.viewFinal;
  	}
  	
  	
  	@RequestMapping(value="/finalPrevList.do")
	public String finalPrevList(HttpServletRequest reqst, ModelMap model) {
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		model.addAttribute("finname",reqst.getSession().getAttribute("name"));
		
		return viewFinalPrevList;
	}
  	
  	
  	/* exterminatorprevlist view */
	@RequestMapping(value="/finalGoCal.do")
	public String finalGoCal(HttpServletRequest reqst, ModelMap model) {
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		java.util.Date d = new java.util.Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		if(Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) >= 0 && Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) <= 60000) {
			cal.add(Calendar.DATE, -1);
		}
		
		java.sql.Date sqlD = new java.sql.Date(cal.getTimeInMillis());

		NightIdVO nightidvo = new NightIdVO(); 
		nightidvo.setEnid((Integer) reqst.getSession().getAttribute("id"));
		nightidvo.setDate(sqlD);
		
		int checkCalender = this.finalservice.readCheckedCalenderFinal(nightidvo);
		
		List<?> nightCalender = this.finalservice.readNightCalenderFinal(nightidvo);

		model.addAttribute("checkCalender",checkCalender);

		if(!nightCalender.isEmpty()) {
			model.addAttribute("nightCalenderList",nightCalender);
			model.addAttribute("currenteId",reqst.getSession().getAttribute("id"));
		}
		
		return viewCalender;
	}
  	
  	@RequestMapping(value="/finalGoDes.do")
	public String finalGoDes() {
		return viewTips;
	}
	
	@RequestMapping(value="/finalGoList.do")
	public String finalGoList() {
		return "forward:/viewFinal.do";
	}
  	
  	/* final view */
	@RequestMapping(value="/viewFinal.do")
	public String viewFinal(ModelMap model, HttpServletRequest reqst) {
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		java.util.Date d = new java.util.Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		if(Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) >= 0 && Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) <= 60000) {
			cal.add(Calendar.DATE, -1);
		}
		
		java.sql.Date sqlD = new java.sql.Date(cal.getTimeInMillis());
		
		SectorIdVO sectoridvo = new SectorIdVO();
		sectoridvo.setToday(sqlD);
		sectoridvo.setStid((String) reqst.getSession().getAttribute("secid"));
		
		int existSectorCount = this.finalservice.readExistSectorCount(sectoridvo);
		
		if(existSectorCount == 0) {
			model.addAttribute("secNm",(String) reqst.getSession().getAttribute("secnm"));
			model.addAttribute("secId",(String) reqst.getSession().getAttribute("secid"));
			return getViewFinal();
		} else {
			return viewFinish;
		}
	}
	
	/* final view 
	 * element insert
	 * */
	@RequestMapping(value="/Action/doCheckFinal.do")
	public String doCheck(HttpServletRequest reqst, ModelMap model, FinalVO finalInfo) {
		
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		/* check overlap */
		java.util.Date d = new java.util.Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		if(Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) >= 0 && Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) <= 60000) {
			cal.add(Calendar.DATE, -1);
		}
		
		java.sql.Date sqlD = new java.sql.Date(cal.getTimeInMillis());
		
		SectorIdVO sectoridvo = new SectorIdVO();
		sectoridvo.setToday(sqlD);
		sectoridvo.setStid((String) reqst.getSession().getAttribute("secid"));
		
		int existSectorCount = this.finalservice.readExistSectorCount(sectoridvo);
		
		if(existSectorCount != 0) {
			return viewFinish;
		}
		/* check overlap */
		
		
		// 첨부파일 관련 첨부파일ID 생성
        List<FileVO> _result = null;
        String _atchFileId = "";
		

		MultipartHttpServletRequest mpReqst  = (MultipartHttpServletRequest)reqst;

		final Map<String, MultipartFile> files = mpReqst.getFileMap();

        if (!files.isEmpty()) {
            try {
				_result = fileUtil.parseFileInf(files, "FILE_", 0, "", "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            try {
				_atchFileId = fileMngService.insertFileInfs(_result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 파일이 생성되고나면 생성된 첨부파일 ID를 리턴한다.
        }
        
        // 리턴받은 첨부파일ID를 셋팅한다..
        finalInfo.setImgname(_atchFileId); // 첨부파일 ID
        
        finalInfo.setDeptid((Integer) reqst.getSession().getAttribute("depid"));
        finalInfo.setEmpid((Integer) reqst.getSession().getAttribute("id"));
        finalInfo.setSectorid((String) reqst.getSession().getAttribute("secid"));
        
		finalInfo.setDate(sqlD);

		this.finalservice.addFinalInfo(finalInfo);
		model.addAttribute("finalInfo", finalInfo);

		return viewFinish;
			
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
