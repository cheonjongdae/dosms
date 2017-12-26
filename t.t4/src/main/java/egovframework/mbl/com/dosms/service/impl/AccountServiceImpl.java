package egovframework.mbl.com.dosms.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.mbl.com.dosms.service.AccountService;
import egovframework.mbl.com.dosms.service.AccountVO;
import egovframework.mbl.com.dosms.service.NightIdVO;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Resource
	private AccountDAO accountdao;    // 스프링에서 자동으로 인식시켜줄 것임.

	@Override
	public HashMap<String, Object> addAccount(AccountVO accountInfo) {
		this.accountdao.addAccount(accountInfo);
		return null;
	}
	
	@Override
	public HashMap<String, Object> removeAccount(AccountVO accountInfo) {
		this.accountdao.removeAccount(accountInfo);
		return null;
	}
	
	@Override
	public List<?> selectServiceList() {
		return this.accountdao.selectServiceList();
	}

	@Override
	public int checkId(AccountVO accountInfo) {
		return this.accountdao.checkId(accountInfo);
	}
	
	@Override
	public int checkIdPassword(AccountVO accountInfo) {
		return this.accountdao.checkIdPassword(accountInfo);
	}
	
	@Override
	public int readNWId(NightIdVO nightid) {
		return this.accountdao.readNWId(nightid);
	}
	
	@Override
	public int readNWIdTotal(NightIdVO nightid) {
		return this.accountdao.readNWIdTotal(nightid);
	}
	
	@Override
	public int readDeptId(AccountVO accountInfo) {
		return this.accountdao.readDeptId(accountInfo);
	}
	
	@Override
	public String readSecId(AccountVO accountInfo) {
		return this.accountdao.readSecId(accountInfo);
	}
	
	@Override
	public String readSecNm(AccountVO accountInfo) {
		return this.accountdao.readSecNm(accountInfo);
	}
	
	@Override
	public String readName(AccountVO accountInfo) {
		return this.accountdao.readName(accountInfo);
	}
	
	@Override
	public int checkMainManager(AccountVO accountInfo) {
		return this.accountdao.checkMainManager(accountInfo);
	}
	
	@Override
	public int checkSubManager(AccountVO accountInfo) {
		return this.accountdao.checkSubManager(accountInfo);
	}
	
	@Override
	public String readManagerSecId(AccountVO accountInfo) {
		return this.accountdao.readManagerSecId(accountInfo);
	}
	
	@Override
	public String readManagerSecNm(AccountVO accountInfo) {
		return this.accountdao.readManagerSecNm(accountInfo);
	}
}
