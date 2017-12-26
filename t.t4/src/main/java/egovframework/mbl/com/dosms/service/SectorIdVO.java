package egovframework.mbl.com.dosms.service;

import java.sql.Date;

public class SectorIdVO {
	
	/* 오늘날짜 */
	private Date today;
	
	/* 섹터 id */
	private String stid;
	
	/**
	 * Getter : today
	 * @return today(Date)
	 */
	public Date getToday() {
		return today;
	}

	/**
	 * Setter : today
	 * @param today(Date)
	 */
	public void setToday(Date today) {
		this.today = today;
	}
	
	/**
	 * Getter : stid
	 * @return stid(String)
	 */
	public String getStid() {
		return stid;
	}

	/**
	 * Setter : enid
	 * @param enid(String)
	 */
	public void setStid(String stid) {
		this.stid = stid;
	}

}
