package egovframework.mbl.com.dosms.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.mbl.com.dosms.service.MainManagerService;
import egovframework.mbl.com.dosms.service.MainManagerVO;
import egovframework.mbl.com.dosms.service.SectorIdVO;

@Service
public class MainManagerImpl implements MainManagerService {

	@Resource
	private  MainManagerDAO mainmanagerdao;
	
	@Override
	public List<?> readTotalSectorListManager() {
		return this.mainmanagerdao.readTotalSectorListManager();
	}
	
	@Override
	public List<?> readCheckedSectorListManager(SectorIdVO sectoridvo) {
		return this.mainmanagerdao.readCheckedSectorListManager(sectoridvo);
	}
	
	@Override
	public int readCheckedMain(SectorIdVO sectoridvo) {
		return this.mainmanagerdao.readCheckedMain(sectoridvo);
	}

	@Override
	public HashMap<Boolean, Object> insertMainManagerCheck(MainManagerVO mainManagerInfo) {   
		this.mainmanagerdao.insertMainManagerCheck(mainManagerInfo);
		return null;
	}
	
	@Override
	public int readCheckedSubmit(SectorIdVO sectoridvo) {
		return this.mainmanagerdao.readCheckedSubmit(sectoridvo);
	}
}
