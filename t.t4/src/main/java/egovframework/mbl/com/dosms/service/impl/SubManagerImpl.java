package egovframework.mbl.com.dosms.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.mbl.com.dosms.service.SectorIdVO;
import egovframework.mbl.com.dosms.service.SubManagerService;
import egovframework.mbl.com.dosms.service.SubManagerVO;

@Service
public class SubManagerImpl implements SubManagerService {
	
	@Resource
	private SubManagerDAO submanagerdao;
	
	@Override
	public List<?> readCheckListFinal(SectorIdVO sectoridvo) {
		return this.submanagerdao.readCheckListFinal(sectoridvo);
	}
	
	@Override
	public List<?> readCheckListNight(SectorIdVO sectoridvo) {
		return this.submanagerdao.readCheckListNight(sectoridvo);
	}
	
	@Override
	public int readChecked(SectorIdVO sectoridvo) {
		return this.submanagerdao.readChecked(sectoridvo);
	}
	
	@Override
	public HashMap<Boolean, Object> insertSubManagerCheck(SubManagerVO subManagerInfo) {   
		this.submanagerdao.insertSubManagerCheck(subManagerInfo);
		return null;

	}
	
}
