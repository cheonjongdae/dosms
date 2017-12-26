package egovframework.mbl.com.dosms.service;

import java.sql.Date;

public class SubManagerVO {
	
	/* 제출 날짜 */
	private Date datee;
	
	/* 섹터 id */
	private String sectorid;
	
	/* 사원 id */
	private int empid;
	
	/* 코멘트 */
	private String cmnt;
	
	/* 이슈 */
	private Boolean issue;
	

	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}

	public String getSectorid() {
		return sectorid;
	}

	public void setSectorid(String sectorid) {
		this.sectorid = sectorid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}

	public Boolean getIssue() {
		return issue;
	}

	public void setIssue(Boolean issue) {
		this.issue = issue;
	}

	
	
}
