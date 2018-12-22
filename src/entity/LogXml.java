package entity;

import java.util.ArrayList;
import java.util.List;

/*
 * 使用单例模式来实现对日志文件的同步
 * 使用枚举写法实现单例模式
 * 使用枚举除了线程安全和防止反射强行调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。
 * 因此，Effective Java推荐尽可能地使用枚举来实现单例。
 * */

public enum LogXml {
	INSTANCE;

	public static List<ActionLog> actionList = new ArrayList<ActionLog>();

	public List<ActionLog> getActionList() {
		return this.actionList;
	}

	public void setActionList(List<ActionLog> actionLogList) {
		for (ActionLog actionLog : actionLogList) {
			this.actionList.add(actionLog);
		}
	}

}
