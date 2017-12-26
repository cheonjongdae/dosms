package egovframework.mbl.com.dosms.service;

import java.util.HashMap;
import java.util.List;

import egovframework.mbl.com.dosms.service.AccountVO;
import egovframework.mbl.com.dosms.service.NightIdVO;

public interface AccountService {
	public HashMap<String, Object> addAccount(AccountVO accountInfo);	
	
	public HashMap<String, Object> removeAccount(AccountVO accountInfo);	
	
	public List<?> selectServiceList();
	
	public int checkId(AccountVO accountInfo);

	public int checkIdPassword(AccountVO accountInfo);
	
	public int readNWId(NightIdVO nightid);
	
	public int readNWIdTotal(NightIdVO nightid);

	public int readDeptId(AccountVO accountInfo);

	public String readSecId(AccountVO accountInfo);
	
	public String readSecNm(AccountVO accountInfo);
	
	public String readName(AccountVO accountInfo);
	
	public int checkMainManager(AccountVO accountInfo);
	
	public int checkSubManager(AccountVO accountInfo);
	
	public String readManagerSecId(AccountVO accountInfo);
	
	public String readManagerSecNm(AccountVO accountInfo);
}
