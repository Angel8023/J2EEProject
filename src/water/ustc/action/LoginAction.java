package water.ustc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import service.UserInterface;
import service.UserService;

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
		userBean = new UserBean();
		userBean.setUserId(name);   //把输入的name当作id来进行查询
		userBean.setUserPass(pwd);	
		UserInterface user = new UserService(userBean);
		boolean isSuccess = user.signIn();
		if (isSuccess) {
			return "success";
		} else	return "failure";
	}
}
