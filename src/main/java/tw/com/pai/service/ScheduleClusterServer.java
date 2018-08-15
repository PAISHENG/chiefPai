package tw.com.pai.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("scheduleClusterServer") 
public class ScheduleClusterServer {
	
	private static final long serialVersionUID = 122323233244334343L;
    private static final Logger logger = LoggerFactory.getLogger(ScheduleClusterServer.class);
    
    public void testMethod1(){
        //執行定时調度業務
        logger.info("testMethod1.......1");
        System.out.println("2--testMethod1......."+System.currentTimeMillis()/1000);
    }
    
    public void testMethod2(){
        logger.info("testMethod2.......2");    
    }
}
