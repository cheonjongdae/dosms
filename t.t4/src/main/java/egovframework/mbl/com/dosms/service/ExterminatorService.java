package egovframework.mbl.com.dosms.service;

import java.util.HashMap;
import java.util.List;

import egovframework.mbl.com.dosms.service.ExterminatorVO;

public interface ExterminatorService {
	public HashMap<Boolean, Object> addSecurity(ExterminatorVO securityInfo);
	
	public List<?> readTotalSectorList();
	
	public List<?> readCheckedSectorList(SectorIdVO sectoridvo);
	
	public int readClickedSectorCount(SectorIdVO sectoridvo);
	
	public int readCheckedCalender(NightIdVO nightid);
	
	public List<?> readNightCalender(NightIdVO nightid);
}
