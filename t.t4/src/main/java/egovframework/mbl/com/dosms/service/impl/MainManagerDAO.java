package egovframework.mbl.com.dosms.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.mbl.com.dosms.service.MainManagerVO;
import egovframework.mbl.com.dosms.service.SectorIdVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository
public class MainManagerDAO extends EgovAbstractDAO {
	
	public List<?> readTotalSectorListManager() {
		return list("MainManager.readTotalSectorListManager");
	}
	
	public List<?> readCheckedSectorListManager(SectorIdVO sectoridvo) {
		return list("MainManager.readCheckedSectorListManager", sectoridvo);
	}
	
	public int readCheckedMain(SectorIdVO sectoridvo) {
		return (Integer) super.select("MainManager.readChecked", sectoridvo);
	}
	
	public void insertMainManagerCheck(MainManagerVO mainManagerInfo) {   
		super.insert("MainManager.insertMainManagerCheck", mainManagerInfo);
	}
	
	public int readCheckedSubmit(SectorIdVO sectoridvo) {
		return (Integer) super.select("MainManager.readCheckedSubmit", sectoridvo);
	}
	
}
