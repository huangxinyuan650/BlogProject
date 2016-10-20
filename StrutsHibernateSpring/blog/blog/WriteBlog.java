package blog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

public class WriteBlog {
	/*
	 * 将输入的文章以xml格式的存储
	 */
	private String context;
	private String userName;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public WriteBlog(String context,String userName){
		this.context = context;
		this.userName = userName;
	}
	
	public String doWrite(){   
		//将文本写到一个txt文件并将该文件的路径返回给bloginfo对象
		//新建一个文件夹来存放文章
//		HttpServletRequest request = ServletActionContext.getRequest();ServletActionContext.getRequest().getRealPath("/")+
		File blogs = new File("blogSource\\"+userName);
		System.out.println("=============="+blogs.getAbsolutePath());
		if(!blogs.exists()){
			blogs.mkdirs();
		}
		System.out.println("=============="+blogs.getAbsolutePath());
		System.out.println("=============="+blogs.getPath());
		//创建一个新的文件用来存放文章内容
		File artical = new File("blogSource\\"+userName+"\\"+new Date().getTime()+"650.txt");
		if(!artical.exists()){
			try {
				artical.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("文件的绝对路径======="+artical.getAbsolutePath());
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(artical);
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//将传进来的文章内容字符串以<p>和</p>解析分行，存入文本文件
		StringTokenizer st = new StringTokenizer(context, "<p>|</p>|<br />");
		String temp = null;
		while(st.hasMoreTokens()){
			try {
				temp = st.nextToken();
				//去掉空行
				if(!"".equals(temp.trim())){
					bw.write(temp);
					bw.newLine();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return artical.getPath();
	}
}
