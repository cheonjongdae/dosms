package egovframework.mbl.com.dosms.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.mbl.com.dosms.service.AdminVO;
import egovframework.mbl.com.dosms.service.NightIdVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository
public class AdminDAO extends EgovAbstractDAO {
	
	public List<?> readAdminNightCalender(NightIdVO nightid) {
		return list("Admin.readAdminNightCalender", nightid);
	}

	public void changeNightDate(AdminVO adminInfo) {
		// TODO Auto-generated method stub
		super.update("Admin.changeNightDate", adminInfo);
	}

}
