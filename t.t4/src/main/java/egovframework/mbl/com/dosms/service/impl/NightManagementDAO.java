package egovframework.mbl.com.dosms.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.mbl.com.dosms.service.NightManagementVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository
public class NightManagementDAO extends EgovAbstractDAO {
	
	public int selectNWCount() {
		return (Integer) super.select("NightManagement.selectNWCount");
	}
	
	public void updateNWDate(NightManagementVO nightmanagementvo) {
		super.update("NightManagement.updateNWDate", nightmanagementvo);
	}
	
	public java.sql.Date maxNWDate() {
		return (java.sql.Date) super.select("NightManagement.maxNWDate");
	}
}
