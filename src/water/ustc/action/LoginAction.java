package water.ustc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.db.glassfish.BridgeWrapper;

import bean.UserBean;

public class LoginAction {
	private UserBean userBean;

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String handleLogin(HttpServletRequest request, HttpServletResponse reponse) {
		String name = request.getParameter("userName");
		String pwd = request.getParameter("userPassword");
		System.out.println("’À∫≈∫Õ√‹¬Î£∫"+name + pwd);
		userBean = new UserBean();
		userBean.setUserName(name);
		userBean.setUserPass(pwd);		
		boolean isSuccess = userBean.signIn();
		if (isSuccess) {
			return "success";
		} else	return "failure";
	}
}
