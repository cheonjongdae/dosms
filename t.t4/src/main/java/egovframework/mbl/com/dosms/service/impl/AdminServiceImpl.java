package egovframework.mbl.com.dosms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.mbl.com.dosms.service.AdminService;
import egovframework.mbl.com.dosms.service.AdminVO;
import egovframework.mbl.com.dosms.service.NightIdVO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Resource
	private AdminDAO admindao;

	@Override
	public List<?> readAdminNightCalender(NightIdVO nightid) {
		// TODO Auto-generated method stub
		return this.admindao.readAdminNightCalender(nightid);
	}

	@Override
	public void changeNightDate(AdminVO adminInfo) {
		// TODO Auto-generated method stub
		this.admindao.changeNightDate(adminInfo);
	}
}
