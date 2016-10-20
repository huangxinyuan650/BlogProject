package login;

import com.opensymphony.xwork2.Action;

public class RegisterAction implements Action{
	private String userName;
	private String password;
	private String password2;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public String execute() throws Exception
	{
		if(getPassword().equals(getPassword2())){
			UserInfoValid valid = new UserInfoValid(getUserName(), getPassword());
			if(valid.doRegisterValid()){
				return "success";
			}else{
				return "error";
			}
			
		}else{
			return "error";
		}
	}
}
