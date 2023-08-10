package db;

public class User {
	private String userName;
	private String tel;
	public User(String userName, String tel) {
		super();
		this.userName = userName;
		this.tel = tel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
