package egovframework.mbl.com.dosms.service;

import java.util.Calendar;

import javax.annotation.Resource;

public class NightManagementMethod {
	
	@Resource
	private NightManagementService nightmanagementservice;
	
	

	public void generateNightWorker() {
		int count = this.nightmanagementservice.selectNWCount();
		java.sql.Date lastDate = this.nightmanagementservice.maxNWDate();
		
		NightManagementVO nightmanagementvo = new NightManagementVO();
		
		int nextCount = 0;
		
		//미리 생성시킬 인원수 : 40
		while(count < 40) {
			System.out.println("당직 자동 생성(count) : " + count);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(lastDate);
			cal.add(Calendar.DATE, nextCount);
			System.out.println("당직 자동 생성(cal) : " + cal.getTime());
			
			if(cal.get(Calendar.DAY_OF_WEEK) != 1 && cal.get(Calendar.DAY_OF_WEEK) != 7) {
				nightmanagementvo.setAddCount(nextCount);
				
				this.nightmanagementservice.updateNWDate(nightmanagementvo);
				count++;
			}
			
			nextCount++;
		}
	}
}
