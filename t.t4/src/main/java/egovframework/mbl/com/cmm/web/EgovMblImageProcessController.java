package egovframework.mbl.com.cmm.web;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import egovframework.com.cmm.SessionVO;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Class Name : EgovImageProcessController.java
 * @Description :
 * @Modification Information
 *
 *    수정일       수정자         수정내용
 *    -------        -------     -------------------
 *    2009. 4. 2.     이삼섭
 *
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009. 4. 2.
 * @version
 * @see
 *
 */
@SuppressWarnings("serial")
@Controller
public class EgovMblImageProcessController extends HttpServlet {

    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EgovMblImageProcessController.class);

    /**
     * 첨부된 이미지에 대한 미리보기 기능을 제공한다.
     *
     * @param atchFileId
     * @param fileSn
     * @param sessionVO
     * @param model
     * @param response
     * @throws Exception
     */
    @RequestMapping("/cmm/fms/getImage.mdo")
    public void getImageInf(SessionVO sessionVO, ModelMap model, @RequestParam Map<String, Object> commandMap, HttpServletResponse response) throws Exception {

    	//@RequestParam("atchFileId") String atchFileId,
    	//@RequestParam("fileSn") String fileSn,
    	String atchFileId = (String)commandMap.get("atchFileId");
    	String fileSn = (String)commandMap.get("fileSn");

    	FileVO vo = new FileVO();

    	vo.setAtchFileId(atchFileId);
    	vo.setFileSn(fileSn);

    	FileVO fvo = fileService.selectFileInf(vo);

    	//String fileLoaction = fvo.getFileStreCours() + fvo.getStreFileNm();

    	File file = new File(fvo.getFileStreCours(), fvo.getStreFileNm());
    	FileInputStream fis = new FileInputStream(file);

    	BufferedInputStream in = new BufferedInputStream(fis);
    	ByteArrayOutputStream bStream = new ByteArrayOutputStream();

        try{

	    	int imgByte;
	    	while ((imgByte = in.read()) != -1) {
	    	    bStream.write(imgByte);
	    	}
	    	in.close();

	    	String type = "";

	    	if (fvo.getFileExtsn() != null && !"".equals(fvo.getFileExtsn())) {
	    	    if ("jpg".equals(fvo.getFileExtsn().toLowerCase())) {
	    		type = "image/jpeg";
	    	    } else {
	    		type = "image/" + fvo.getFileExtsn().toLowerCase();
	    	    }
	    	    type = "image/" + fvo.getFileExtsn().toLowerCase();

	    	} else {
	    		LOGGER.debug("Image fileType is null.");
	    	}

	    	response.setHeader("Content-Type", type);
	    	response.setContentLength(bStream.size());

	    	bStream.writeTo(response.getOutputStream());

	    	response.getOutputStream().flush();
	    	response.getOutputStream().close();
	    	bStream.close();

	    } catch (Exception e) {
	    	if(null != in){
	    		in.close();
	    	}
			if(null != in){
				bStream.close();
			}

	    }
	    finally{
	    	if(null != in){
	    		in.close();
	    	}
			if(null != in){
				bStream.close();
			}

	    }

    }
}
