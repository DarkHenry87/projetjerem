package Servlets;

public class UserInfo {

	public String login;
	private int post;
	private String pass;

	public UserInfo() {
		super();
	}

	public UserInfo(String login, String pass, int post) {
		this.login = login;
		this.pass = pass;
		this.post = post;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserInfo [login=" + login + ", pass=" + pass + "]";
	}
}
