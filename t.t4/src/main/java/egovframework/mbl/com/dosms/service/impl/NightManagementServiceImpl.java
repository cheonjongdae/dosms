package egovframework.mbl.com.dosms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.mbl.com.dosms.service.NightManagementService;
import egovframework.mbl.com.dosms.service.NightManagementVO;

@Service
public class NightManagementServiceImpl implements NightManagementService {
	
	@Resource
	private NightManagementDAO nightmanagemnetdao;
	
	@Override
	public int selectNWCount() {
		return this.nightmanagemnetdao.selectNWCount();
	}
	
	@Override
	public void updateNWDate(NightManagementVO nightmanagementvo) {
		this.nightmanagemnetdao.updateNWDate(nightmanagementvo);
	}
	
	@Override
	public java.sql.Date maxNWDate() {
		return this.nightmanagemnetdao.maxNWDate();
	}

}
