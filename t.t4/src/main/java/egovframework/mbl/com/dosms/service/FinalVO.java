package egovframework.mbl.com.dosms.service;

import java.sql.Date;

public class FinalVO {
	
	/* 점검요소 첫번째 */
	private Boolean first = false;
	
	/* 점검요소 두번째 */
	private Boolean second = false;
	
	/* 점검요소 세번째 */
	private Boolean third = false;
	
	/* 점검요소 네번째 */
	private Boolean forth = false;
	
	/* 점검요소 다섯번째 */
	private Boolean fifth = false;
	
	/* 이미지 이름 */
	private String imgname;
	
	/* 제출날짜 */
	private Date date;
	
	/* 제출시간 */
	private int inspecttime;
	
	/* 코멘트 */
	private String cmnt;
	
	/* 부서 id */
	private int deptid;

	/* 사원 id */
	private int empid;
	
	/* 섹터 id */
	private String sectorid;

	/**
	 * Getter : first
	 * @return 첫번째요소(Boolean)
	 */
	public Boolean getFirst() {
		return first;
	}

	/**
	 * Setter : first
	 * @param first 첫번째요소(Boolean)
	 */
	public void setFirst(Boolean first) {
		this.first = first;
	}
		
	/**
	 * Getter : second
	 * @return second(Boolean)
	 */
	public Boolean getSecond() {
		return second;
	}

	/**
	 * Setter : second
	 * @param second(Boolean)
	 */
	public void setSecond(Boolean second) {
		this.second = second;
	}

	/**
	 * Getter : third
	 * @return third(Boolean)
	 */
	public Boolean getThird() {
		return third;
	}

	/**
	 * Setter : third
	 * @param third(Boolean)
	 */
	public void setThird(Boolean third) {
		this.third = third;
	}
	
	/**
	 * Getter : forth
	 * @return forth(Boolean)
	 */
	public Boolean getForth() {
		return forth;
	}

	/**
	 * Setter : forth
	 * @param forth(Boolean)
	 */
	public void setForth(Boolean forth) {
		this.forth = forth;
	}
	
	/**
	 * Getter : fifth
	 * @return fifth(Boolean)
	 */
	public Boolean getFifth() {
		return fifth;
	}

	/**
	 * Setter : fifth
	 * @param fifth(Boolean)
	 */
	public void setFifth(Boolean fifth) {
		this.fifth = fifth;
	}
	
	/**
	 * Getter : imgname
	 * @return imgname(String)
	 */
	
	public String getImgname() {
		return imgname;
	}
	
	
	/**
	 * Setter : imgname
	 * @param imgname(String)
	 */
	
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	
	
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
	 * Getter : inspecttime
	 * @return inspecttime(int)
	 */
	public int getInspecttime() {
		return inspecttime;
	}

	/**
	 * Setter : inspecttime
	 * @param inspecttime(int)
	 */
	public void setInspecttime(int inspecttime) {
		this.inspecttime = inspecttime;
	}
	
	/**
	 * Getter : cmnt
	 * @return cmnt(String)
	 */
	public String getCmnt() {
		return cmnt;
	}

	/**
	 * Setter : cmnt
	 * @param cmnt(String)
	 */
	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}
	
	/**
	 * Getter : deptid
	 * @return deptid(int)
	 */
	public int getDeptid() {
		return deptid;
	}

	/**
	 * Setter : deptid
	 * @param deptid(int)
	 */
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
	/**
	 * Getter : empid
	 * @return empid(int)
	 */
	public int getEmpid() {
		return empid;
	}

	/**
	 * Setter : empid
	 * @param empid(int)
	 */
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	/**
	 * Getter : sectorid
	 * @return sectorid(String)
	 */
	public String getSectorid() {
		return sectorid;
	}

	/**
	 * Setter : sectorid
	 * @param sectorid(String)
	 */
	public void setSectorid(String sectorid) {
		this.sectorid = sectorid;
	}
}
