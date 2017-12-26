package egovframework.mbl.com.dosms.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.mbl.com.dosms.service.FinalVO;
import egovframework.mbl.com.dosms.service.NightIdVO;
import egovframework.mbl.com.dosms.service.SectorIdVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository
public class FinalDAO extends EgovAbstractDAO {
	
	public void addFinalInfo(FinalVO finalInfo) {

		super.insert("Final.addFinalInfo", finalInfo);
	}
	
	public int readExistSectorCount(SectorIdVO sectoridvo) {
		return (Integer) super.select("Final.readExistSectorCount", sectoridvo);
	}

	public int readCheckedCalenderFinal(NightIdVO nightid) {
		return (Integer) super.select("Final.readCheckedCalender", nightid);
	}

	public List<?> readNightCalenderFinal(NightIdVO nightid) {
		return list("Final.readNightCalender", nightid);
	}
}
