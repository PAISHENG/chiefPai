package tw.com.pai.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tw.com.pai.service.IStockService;

@Component
@EnableScheduling
public class TWSEDailyJobs {

	
	@Autowired
	private IStockService iStockService;
	/**
	* 
	* 
	*/
	@Scheduled(cron = "0 27 12 * * ?")
//	@Scheduled(cron = "*/10 * * * * ?")
	public void executeDailyZipFile() {
		System.out.println("testSchedule");
	}
	
	
}
