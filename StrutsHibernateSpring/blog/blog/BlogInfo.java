package blog;

import java.util.Date;

public class BlogInfo {
	private int id;        //���id
	private String title;  //���±���
	private String author;    //�������ߵ�id
	private Date writeTime;    //���µķ���ʱ��
	private String contextPath;    //���µĴ洢·��
	
	public int getId() {
		return id;
	}
	//id������һ������������������Ϊ�ܱ����ı���
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
