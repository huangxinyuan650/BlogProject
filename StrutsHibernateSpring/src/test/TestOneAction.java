package test;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class TestOneAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Huang huang = new Huang();
	private List<Huang> reList = new ArrayList<Huang>();
	public List<Huang> getReList() {
		return reList;
	}
	public void setReList(List<Huang> reList) {
		this.reList = reList;
	}
	public Huang getHuang() {
		return huang;
	}
	public void setHuang(Huang huang) {
		this.huang = huang;
	}
	
	public String execute() throws Exception{
		System.out.println("==========="+huang.getUserName());
		reList.add(huang);
		Huang hhh = new Huang();
		hhh.setUserName("huangxin");
		reList.add(hhh);
		return "success";
	}
	
//	public Object getModel(){
//		System.out.println("============Ö´ÐÐ");
//		return reList;
//	}
}
