package blog;

import java.util.Date;

public class BlogInfo {
	private int id;        //编号id
	private String title;  //文章标题
	private String author;    //文章作者的id
	private Date writeTime;    //文章的发布时间
	private String contextPath;    //文章的存储路径
	
	public int getId() {
		return id;
	}
	//id的设置一般是自增的所以设置为受保护的变量
	protected void setId(int id) {
		this.id = id;
	}
	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
