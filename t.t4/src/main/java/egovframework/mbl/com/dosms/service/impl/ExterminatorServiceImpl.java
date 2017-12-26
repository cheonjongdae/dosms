package egovframework.mbl.com.dosms.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.mbl.com.dosms.service.ExterminatorService;
import egovframework.mbl.com.dosms.service.NightIdVO;
import egovframework.mbl.com.dosms.service.SectorIdVO;
import egovframework.mbl.com.dosms.service.ExterminatorVO;

@Service
public class ExterminatorServiceImpl implements ExterminatorService{
	
	@Resource
	private ExterminatorDAO exterminatordao;
	
	@Override
	public HashMap<Boolean, Object> addSecurity(ExterminatorVO securityInfo) {   

		this.exterminatordao.addSecurity(securityInfo);
		return null;
	}
	
	@Override
	public List<?> readTotalSectorList() {
		return this.exterminatordao.readTotalSectorList();
	}
	
	@Override
	public List<?> readCheckedSectorList(SectorIdVO sectoridvo) {
		return this.exterminatordao.readCheckedSectorList(sectoridvo);
	}
	
	@Override
	public int readClickedSectorCount(SectorIdVO sectoridvo) {
		return this.exterminatordao.readClickedSectorCount(sectoridvo);
	}
	
	@Override
	public int readCheckedCalender(NightIdVO nightid) {
		return this.exterminatordao.readCheckedCalender(nightid);
	}
	
	@Override
	public List<?> readNightCalender(NightIdVO nightid) {
		return this.exterminatordao.readNightCalender(nightid);
	}

}
