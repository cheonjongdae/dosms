package egovframework.mbl.com.dosms.service;

import java.util.List;

public interface AdminService {
	public List<?> readAdminNightCalender(NightIdVO nightid);
	
	public void changeNightDate(AdminVO adminInfo);
}
