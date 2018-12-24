package water.ustc.interceptor;

import java.text.DateFormat;
import java.util.Date;

import org.dom4j.DocumentException;

import entity.ActionLog;
import entity.LogXml;
import entity.SingleActionLog;
import sc.ustc.controller.SimpleController;
import util.LogUtil;

public class LogInterceptor {

	DateFormat dateFormat = DateFormat.getDateTimeInstance();
	
	//创建某个action的单例
	SingleActionLog singleActionLog = SingleActionLog.INSTANCE;
	//创建log.xml对象 ,通过单例模式实现，所有的对象维护同一个文件
	LogXml logXml = LogXml.INSTANCE;

	public void preAction() {
		String startTime = dateFormat.format(new Date());
		singleActionLog.setStime(startTime);   //记录访问开始时间
		System.out.println("Action被拦截器拦截前LogInterceptor preAction:" + startTime);
	}

	public void afterAction() throws DocumentException {
		String endTime = dateFormat.format(new Date());
		singleActionLog.setEtime(endTime);   //记录访问结束时间
		System.out.println("Action被拦截器拦截后LogInterceptor afterAction:" + endTime);		
		//获取log.xml 文件路径
		String logXmlPath = LogInterceptor.class.getClassLoader().getResource("log.xml").getPath();						
		System.out.println(logXmlPath);
		// 先获取到历史的日志信息所封装的对象					
		LogUtil logUtil = new LogUtil(logXmlPath);
		logUtil.readLog();
		// 将单个action记录到日志中
		ActionLog actionLog = new ActionLog(singleActionLog);
		logXml.addAction(actionLog);
		// 显示日志信息
		logXml.showLog();
		// 将日志写入log.xml文件
		logUtil.writeLog();
	}
}
