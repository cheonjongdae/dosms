package egovframework.mbl.com.dosms.service;

public class AccountVO {

	/* 사용자가 사용할 계정 */
	private int account;

	/* 사용자가 신청한 계정의 암호 */
	private String password = null;
	
	/* 사용자 이름 */
	private String name = null;

	/* 사용자 부서 id */
	private int deptid;
	
	/* 사용자 섹터 id */
	private String sectorid;
	

	/**
	 * 사용자 정보에서 '계정'을 얻을 수 있습니다.
	 * @return 계정(int)
	 */
	public int getAccount() {
		return account;
	}

	/**
	 * 사용자 정보객체에 '계정'을 설정할 수 있습니다.
	 * @param account 계정(int)
	 */
	public void setAccount(int account) {
		this.account = account;
	}


	/**
	 * 사용자 정보 객체에서 '암호'를 얻을 수 있습니다.
	 * @return 암호(String)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 사용자 정보 객체에 '암호'를 설정할 수 있습니다.
	 * @param password 암호(String)
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Getter : name
	 * @return name(String)
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter : name
	 * @param name(String)
	 */
	public void setName(String name) {
		this.name = name;
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


	/**
	* 디버그를 위한 메소드입니다. 실행 및 기능에는 아무런 연관을 갖지 않습니다.
	*/
	public void printInfo() {
		StringBuilder sb = new StringBuilder();

		sb.append("계정: " + account + "\n");
		sb.append("암호: " + password + "\n");
		sb.append("이름: " + name + "\n");
		sb.append("부서id: " + deptid + "\n");
		sb.append("sectorid: " + sectorid + "\n");
		
		System.out.println("계정생성정보 : \n" + sb.toString());
	}
	
	public void printInfo2() {
		StringBuilder sb = new StringBuilder();

		sb.append("계정: " + account + "\n");
		sb.append("암호: " + password + "\n");
		sb.append("이름: " + name + "\n");
		sb.append("부서id: " + deptid + "\n");
		sb.append("sectorid: " + sectorid + "\n");
		
		System.out.println("계정삭제정보 : \n" + sb.toString());
	}
}
