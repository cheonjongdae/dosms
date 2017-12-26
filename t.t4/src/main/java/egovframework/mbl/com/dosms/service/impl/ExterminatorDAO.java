package egovframework.mbl.com.dosms.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.mbl.com.dosms.service.NightIdVO;
import egovframework.mbl.com.dosms.service.SectorIdVO;
import egovframework.mbl.com.dosms.service.ExterminatorVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository
public class ExterminatorDAO extends EgovAbstractDAO {
	
	public void addSecurity(ExterminatorVO securityInfo) {

		super.insert("Security.addSecurity", securityInfo);
	}
	
	public List<?> readTotalSectorList() {
		return list("Security.readTotalSectorList");
	}
	
	public List<?> readCheckedSectorList(SectorIdVO sectoridvo) {
		return list("Security.readCheckedSectorList", sectoridvo);
	}
	
	public int readClickedSectorCount(SectorIdVO sectoridvo) {
		return (Integer) super.select("Security.readClickedSectorCount", sectoridvo);
	}
	
	public int readCheckedCalender(NightIdVO nightid) {
		return (Integer) super.select("Security.readCheckedCalender", nightid);
	}

	public List<?> readNightCalender(NightIdVO nightid) {
		return list("Security.readNightCalender", nightid);
	}
}
