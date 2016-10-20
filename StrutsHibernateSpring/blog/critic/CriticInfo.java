package critic;

import java.util.Date;

public class CriticInfo {
	private int id;       //评论的id
	private int criticorId;     //评论者的id
	private Date criticTime;    //评论时间
	private int responseid;    //是否为回复某条回复，如果是直接评论文章该值为空
	private String content;         //评论的内容
	private int blogId;         //评论的文章的id
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
