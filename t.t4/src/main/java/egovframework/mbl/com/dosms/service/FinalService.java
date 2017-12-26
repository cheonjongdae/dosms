package egovframework.mbl.com.dosms.service;

import java.util.HashMap;
import java.util.List;

public interface FinalService {
	
	public HashMap<Boolean, Object> addFinalInfo(FinalVO finalInfo);

	public int readExistSectorCount(SectorIdVO sectoridvo);
	
	public int readCheckedCalenderFinal(NightIdVO nightid);
	
	public List<?> readNightCalenderFinal(NightIdVO nightid);
}
