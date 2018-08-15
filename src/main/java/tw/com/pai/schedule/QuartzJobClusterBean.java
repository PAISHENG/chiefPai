package tw.com.pai.schedule;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import tw.com.pai.service.ScheduleClusterServer;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution// 不允許併發執行
public class QuartzJobClusterBean extends QuartzJobBean{
	
	private static final Logger logger = LoggerFactory.getLogger(QuartzJobClusterBean.class);
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		ScheduleClusterServer simpleService = getApplicationContext(arg0).getBean("scheduleClusterServer",
				ScheduleClusterServer.class);
        simpleService.testMethod1();
		
	}

	private ApplicationContext getApplicationContext(final JobExecutionContext jobexecutioncontext) {
        try {
            return (ApplicationContext) jobexecutioncontext.getScheduler().getContext().get("applicationContextKey");
        } catch (SchedulerException e) {
            logger.error("jobexecutioncontext.getScheduler().getContext() error!", e);
            throw new RuntimeException(e);
        }
    }
}
