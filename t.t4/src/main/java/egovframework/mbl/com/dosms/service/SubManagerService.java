package egovframework.mbl.com.dosms.service;

import java.util.HashMap;
import java.util.List;

public interface SubManagerService {
	
	public List<?> readCheckListFinal(SectorIdVO sectoridvo);
	
	public List<?> readCheckListNight(SectorIdVO sectoridvo);
	
	public int readChecked(SectorIdVO sectoridvo);
	
	public HashMap<Boolean, Object> insertSubManagerCheck(SubManagerVO subManagerInfo);
	
}
