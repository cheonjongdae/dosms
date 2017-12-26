package egovframework.mbl.com.dosms.service;

import java.sql.Date;

public class NightIdVO {
	
	/* 당직날짜 */
	private Date date;
	
	/* 당직 id */
	private int enid;
	
	/**
	 * Getter : date
	 * @return date(Date)
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter : date
	 * @param date(Date)
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Getter : enid
	 * @return enid(int)
	 */
	public int getEnid() {
		return enid;
	}

	/**
	 * Setter : enid
	 * @param enid(int)
	 */
	public void setEnid(int enid) {
		this.enid = enid;
	}

}
