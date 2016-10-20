package users;

public class UserDetailInfo {
	/*
	 * 用户详细信息，id为用户的唯一识别id同用户信息中的id相同
	 * realName为用户的真实姓名
	 * gender为用户的性别
	 * company为用户所在的公司
	 * position为用户所处的职位
	 * introduce为用户的文字简介
	 */
	private int id;
	private String userName;
	private String realName;
	private String gender;
	private String company;
	private String position;
	private String introduce;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
