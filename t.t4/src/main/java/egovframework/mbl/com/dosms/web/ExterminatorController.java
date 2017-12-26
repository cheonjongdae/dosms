package egovframework.mbl.com.dosms.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.mbl.com.dosms.service.ExterminatorService;
import egovframework.mbl.com.dosms.service.NightIdVO;
import egovframework.mbl.com.dosms.service.SectorIdVO;
import egovframework.mbl.com.dosms.service.ExterminatorVO;

@Controller
public class ExterminatorController {

	private String viewExterminatorList = "egovframework/mbl/com/dosms/exterminatorList";
	private String viewExterminator = "egovframework/mbl/com/dosms/exterminator";
	private String viewFinish = "egovframework/mbl/com/dosms/finish";
	
	private String viewExterminatorPrevList = "egovframework/mbl/com/dosms/prevNightView";
	private String viewCalender= "egovframework/mbl/com/dosms/workingCalender";
	private String viewTips = "egovframework/mbl/com/dosms/workingTips";
	
	
	@Resource
	private ExterminatorService exterminatorservice;
	
	private String currentSectId;
	private String currentSectName;
	
	// 첨부파일 관련
    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileMngService;

    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;
    
    //go exterminatorList.jsp
  	public String getViewExterminatorList() {
  		return this.viewExterminatorList;
  	}
	
	//go exterminator.jsp
	public String getViewExterminator() {
		return this.viewExterminator;
	}
	
	
	@RequestMapping(value="/exterminatorPrevList.do")
	public String exterminatorPrevList(HttpServletRequest reqst, ModelMap model) {
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		model.addAttribute("extname",reqst.getSession().getAttribute("name"));
		
		return viewExterminatorPrevList;
	}
	
	
	/* exterminatorprevlist view */
	@RequestMapping(value="/exterminatorGoCal.do")
	public String exterminatorGoCal(HttpServletRequest reqst, ModelMap model) {
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
		
		int checkCalender = this.exterminatorservice.readCheckedCalender(nightidvo);
		
		List<?> nightCalender = this.exterminatorservice.readNightCalender(nightidvo);

		model.addAttribute("checkCalender",checkCalender);

		if(!nightCalender.isEmpty()) {
			model.addAttribute("nightCalenderList",nightCalender);
			model.addAttribute("currenteId",reqst.getSession().getAttribute("id"));
		}
		
		return viewCalender;
	}
	
	@RequestMapping(value="/exterminatorGoDes.do")
	public String exterminatorGoDes() {
		return viewTips;
	}
	
	@RequestMapping(value="/exterminatorGoList.do")
	public String exterminatorGoList() {
		return "forward:/exterminatorList.do";
	}
	
	
	/* exterminatorlist view */
	@RequestMapping(value="/exterminatorList.do")
	public String exterminatorList(ModelMap model, HttpServletRequest reqst) {
		//model.addAttribute("securityInfo", new SecurityVO());
		
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		List<?> TotalSectorList = this.exterminatorservice.readTotalSectorList();
		
		java.util.Date d = new java.util.Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		if(Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) >= 0 && Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) <= 60000) {
			cal.add(Calendar.DATE, -1);
		}
		
		java.sql.Date sqlD = new java.sql.Date(cal.getTimeInMillis());
		
		SectorIdVO sectoridvo = new SectorIdVO();
		sectoridvo.setToday(sqlD);
		
		List<?> checkedSectorList = this.exterminatorservice.readCheckedSectorList(sectoridvo);
		
		for(Object object : checkedSectorList) {
		    TotalSectorList.remove(object);
		}
		
		if(TotalSectorList.size() == 0) {
			return viewFinish;
		}

		ArrayList<String> colorList = new ArrayList<String>();
		
		colorList.add("#FFD8D8");
		colorList.add("#FAE0D4");
		colorList.add("#FAECC5");
		colorList.add("#FAF4C0");
		colorList.add("#D2E5A8");
		colorList.add("#BCE9B7");
		colorList.add("#C2E2E8");
		colorList.add("#C8C7ED");
		colorList.add("#D6C7ED");
		colorList.add("#EDC7E8");
		
		model.addAttribute("dlist", TotalSectorList);
		model.addAttribute("empname", reqst.getSession().getAttribute("name"));
		
		model.addAttribute("colorList", colorList);
		return getViewExterminatorList();
	}
	
	/* exterminator view */
	@RequestMapping(value="/exterminator.do")
	public String exterminator(ModelMap model, HttpServletRequest reqst) {	
		//session check
		if(checkSession(reqst) == false) {
			return "redirect:/hello.do";
		}
		
		model.addAttribute("secNm",currentSectName);
		model.addAttribute("currentSecId",currentSectId);
		
		return getViewExterminator();
	}
	
	/* exterminatorlist click event */
	@RequestMapping(value="/exterminatorGoDetail.do")
	public String exterminatorGoDetail(ModelMap model, @RequestParam("clickSectId") String clickedSectId, @RequestParam("clickSectName") String clickedSectorName) {
		
		java.util.Date d = new java.util.Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		if(Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) >= 0 && Integer.parseInt(new SimpleDateFormat("HHmmss").format(cal.getTime())) <= 60000) {
			cal.add(Calendar.DATE, -1);
		}
		
		java.sql.Date sqlD = new java.sql.Date(cal.getTimeInMillis());

		
		
		SectorIdVO sectoridvo = new SectorIdVO();
		sectoridvo.setToday(sqlD);
		sectoridvo.setStid(clickedSectId);
		
		int clickedSectorCount = this.exterminatorservice.readClickedSectorCount(sectoridvo);
		
		if(clickedSectorCount == 0) {

			try {
				clickedSectorName =  URLDecoder.decode(clickedSectorName,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			currentSectId = clickedSectId;
			currentSectName = clickedSectorName;
			
			return "forward:/exterminator.do";
		} else {
			return "redirect:/exterminatorList.do";
		}
	}

	/* exterminator view 
	 * element insert
	 * */
	@RequestMapping(value="/Action/doCheck.do")
	public String doCheck(HttpServletRequest reqst, ModelMap model, ExterminatorVO exterminatorInfo) {
		
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
		sectoridvo.setStid(currentSectId);
		
		int checkSectorCount = this.exterminatorservice.readClickedSectorCount(sectoridvo);
		
		if(checkSectorCount != 0) {
			return "redirect:/exterminatorList.do";
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
        exterminatorInfo.setImgname(_atchFileId); // 첨부파일 ID
        
        exterminatorInfo.setSectorid(currentSectId);
        exterminatorInfo.setEmpid((Integer) reqst.getSession().getAttribute("id"));

        exterminatorInfo.setDate(sqlD);

		this.exterminatorservice.addSecurity(exterminatorInfo);
		model.addAttribute("exterminatorInfo", exterminatorInfo);

		return "redirect:/exterminatorList.do";
			
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
