package egovframework.mbl.com.dosms.service;

import java.sql.Date;

public class AdminVO {

	/* 날짜 */
	private Date changedate;
	
	/* 계정 */
	private int changeid;

	
	public Date getChangedate() {
		return changedate;
	}

	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}

	public int getChangeid() {
		return changeid;
	}

	public void setChangeid(int changeid) {
		this.changeid = changeid;
	}


	
}
