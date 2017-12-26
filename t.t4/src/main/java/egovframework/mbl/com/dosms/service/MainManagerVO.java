package egovframework.mbl.com.dosms.service;

import java.sql.Date;

public class MainManagerVO {
	
	/* 제출 날짜 */
	private Date date;
	
	/* 사원 id */
	private int empid;
	
	/* 결제 */
	private Boolean chk;
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public Boolean getChk() {
		return chk;
	}

	public void setChk(Boolean chk) {
		this.chk = chk;
	}
	
	
}
