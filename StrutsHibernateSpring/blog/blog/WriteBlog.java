package blog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

public class WriteBlog {
	/*
	 * �������������xml��ʽ�Ĵ洢
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
		//���ı�д��һ��txt�ļ��������ļ���·�����ظ�bloginfo����
		//�½�һ���ļ������������
//		HttpServletRequest request = ServletActionContext.getRequest();ServletActionContext.getRequest().getRealPath("/")+
		File blogs = new File("blogSource\\"+userName);
		System.out.println("=============="+blogs.getAbsolutePath());
		if(!blogs.exists()){
			blogs.mkdirs();
		}
		System.out.println("=============="+blogs.getAbsolutePath());
		System.out.println("=============="+blogs.getPath());
		//����һ���µ��ļ����������������
		File artical = new File("blogSource\\"+userName+"\\"+new Date().getTime()+"650.txt");
		if(!artical.exists()){
			try {
				artical.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�ļ��ľ���·��======="+artical.getAbsolutePath());
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(artical);
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�������������������ַ�����<p>��</p>�������У������ı��ļ�
		StringTokenizer st = new StringTokenizer(context, "<p>|</p>|<br />");
		String temp = null;
		while(st.hasMoreTokens()){
			try {
				temp = st.nextToken();
				//ȥ������
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
