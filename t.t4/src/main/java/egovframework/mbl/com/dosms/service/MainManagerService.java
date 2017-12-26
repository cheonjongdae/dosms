package egovframework.mbl.com.dosms.service;

import java.util.HashMap;
import java.util.List;

public interface MainManagerService {
	public List<?> readTotalSectorListManager();
	
	public List<?> readCheckedSectorListManager(SectorIdVO sectoridvo);
	
	public int readCheckedMain(SectorIdVO sectoridvo);
	
	public HashMap<Boolean, Object> insertMainManagerCheck(MainManagerVO mainManagerInfo);
	
	public int readCheckedSubmit(SectorIdVO sectoridvo);
}