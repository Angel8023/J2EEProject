package water.ustc.interceptor;

import java.text.DateFormat;
import java.util.Date;

public class LogInterceptor {
	
	DateFormat dateFormat = DateFormat.getDateTimeInstance();
	
	public void preAction(){
		String startTime = dateFormat.format(new Date());
		//LogPrinter.printXmlLog("log.xml", "s-time",startTime);
		System.out.println("Action被拦截器拦截LogInterceptor preAction:"+startTime);							
	}
	
	public void afterAction(){
		String endTime = dateFormat.format(new Date());
		//LogPrinter.printXmlLog("log.xml", "e-time",endTime);
		System.out.println("Action被拦截器拦截LogInterceptor afterAction:"+endTime);		
	}
}
