package users;

public class UserDetailInfo {
	/*
	 * �û���ϸ��Ϣ��idΪ�û���Ψһʶ��idͬ�û���Ϣ�е�id��ͬ
	 * realNameΪ�û�����ʵ����
	 * genderΪ�û����Ա�
	 * companyΪ�û����ڵĹ�˾
	 * positionΪ�û�������ְλ
	 * introduceΪ�û������ּ��
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
