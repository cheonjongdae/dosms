package egovframework.mbl.com.dosms.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.mbl.com.dosms.service.FinalService;
import egovframework.mbl.com.dosms.service.FinalVO;
import egovframework.mbl.com.dosms.service.NightIdVO;
import egovframework.mbl.com.dosms.service.SectorIdVO;

@Service
public class FinalServiceImpl implements FinalService {
	
	@Resource
	private FinalDAO finaldao;
	
	@Override
	public HashMap<Boolean, Object> addFinalInfo(FinalVO finalInfo) {

		this.finaldao.addFinalInfo(finalInfo);
		return null;
	}
	
	@Override
	public int readExistSectorCount(SectorIdVO sectoridvo) {
		return this.finaldao.readExistSectorCount(sectoridvo);
	}

	@Override
	public int readCheckedCalenderFinal(NightIdVO nightid) {
		return this.finaldao.readCheckedCalenderFinal(nightid);
	}
	
	@Override
	public List<?> readNightCalenderFinal(NightIdVO nightid) {
		return this.finaldao.readNightCalenderFinal(nightid);
	}
}
