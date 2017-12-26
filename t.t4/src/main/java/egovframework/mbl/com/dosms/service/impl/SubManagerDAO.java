package egovframework.mbl.com.dosms.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.mbl.com.dosms.service.SectorIdVO;
import egovframework.mbl.com.dosms.service.SubManagerVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository
public class SubManagerDAO extends EgovAbstractDAO {
	
	public List<?> readCheckListFinal(SectorIdVO sectoridvo) {
		return list("SubManager.readCheckListFinal", sectoridvo);
	}
	
	public List<?> readCheckListNight(SectorIdVO sectoridvo) {
		return list("SubManager.readCheckListNight", sectoridvo);
	}
	
	public int readChecked(SectorIdVO sectoridvo) {
		return (Integer) super.select("SubManager.readChecked", sectoridvo);
	}
	
	public void insertSubManagerCheck(SubManagerVO subManagerInfo) {
		super.insert("SubManager.insertSubManagerCheck", subManagerInfo);
	}

}
