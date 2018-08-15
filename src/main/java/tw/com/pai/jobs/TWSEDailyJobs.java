package tw.com.pai.jobs;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TWSEDailyJobs {

	/**
	* 
	* 
	*/
//	@Scheduled(cron = "0 27 12 * * ?")
	@Scheduled(cron = "*/10 * * * * ?")
	public void executeDailyZipFile() {
		System.out.println("testSchedule");
	}
	
	
}
