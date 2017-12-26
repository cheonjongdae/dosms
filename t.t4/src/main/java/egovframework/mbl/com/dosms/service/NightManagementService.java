package egovframework.mbl.com.dosms.service;

public interface NightManagementService {
	public int selectNWCount();
	
	public void updateNWDate(NightManagementVO nightmanagementvo);
	
	public java.sql.Date maxNWDate();
}
