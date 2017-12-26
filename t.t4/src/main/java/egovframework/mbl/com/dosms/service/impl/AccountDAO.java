package egovframework.mbl.com.dosms.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.mbl.com.dosms.service.AccountVO;
import egovframework.mbl.com.dosms.service.NightIdVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository
public class AccountDAO extends EgovAbstractDAO {
	
	public void addAccount(AccountVO accountInfo) {

		super.insert("Account.addAccount", accountInfo);
	}
	
	public void removeAccount(AccountVO accountInfo) {

		super.delete("Account.removeAccount", accountInfo);
	}
	
	public List<?> selectServiceList() {
		return list("Account.readAccount");
	}
	
	public int checkId(AccountVO accountInfo) {
		return (Integer) super.select("Account.readIdCount",accountInfo);
	}
	
	public int checkIdPassword(AccountVO accountInfo) {
		return (Integer) super.select("Account.readIdPasswordCount",accountInfo);
	}

	public int readNWId(NightIdVO nightid) {
		return (Integer) super.select("Account.readNight", nightid);
	}
	
	public int readNWIdTotal(NightIdVO nightid) {
		return (Integer) super.select("Account.readNightTotal", nightid);
	}
	
	public int readDeptId(AccountVO accountInfo) {
		return (Integer) super.select("Account.readDeptId", accountInfo);
	}
	
	public String readSecId(AccountVO accountInfo) {
		return (String) super.select("Account.readSectorId", accountInfo);
	}
	
	public String readSecNm(AccountVO accountInfo) {
		return (String) super.select("Account.readSecNm", accountInfo);
	}
	
	public String readName(AccountVO accountInfo) {
		return (String) super.select("Account.readName", accountInfo);
	}
	
	public int checkMainManager(AccountVO accountInfo) {
		return (Integer) super.select("Account.checkMainManager",accountInfo);
	}
	
	public int checkSubManager(AccountVO accountInfo) {
		return (Integer) super.select("Account.checkSubManager",accountInfo);
	}
	
	public String readManagerSecId(AccountVO accountInfo) {
		return (String) super.select("Account.readManagerSecId", accountInfo);
	}
	
	public String readManagerSecNm(AccountVO accountInfo) {
		return (String) super.select("Account.readManagerSecNm", accountInfo);
	}
}
