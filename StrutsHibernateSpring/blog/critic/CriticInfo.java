package critic;

import java.util.Date;

public class CriticInfo {
	private int id;       //���۵�id
	private int criticorId;     //�����ߵ�id
	private Date criticTime;    //����ʱ��
	private int responseid;    //�Ƿ�Ϊ�ظ�ĳ���ظ��������ֱ���������¸�ֵΪ��
	private String content;         //���۵�����
	private int blogId;         //���۵����µ�id
	public int getResponseid() {
		return responseid;
	}
	public void setResponseid(int responseid) {
		this.responseid = responseid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCriticTime() {
		return criticTime;
	}
	public void setCriticTime(Date criticTime) {
		this.criticTime = criticTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCriticorId() {
		return criticorId;
	}
	public void setCriticorId(int criticorId) {
		this.criticorId = criticorId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
}
