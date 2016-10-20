package test;

import com.opensymphony.xwork2.Action;

public class TestTwoAction implements Action{

	private String arid;
	
	public String getArid() {
		return arid;
	}

	public void setArid(String arid) {
		this.arid = arid;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=============="+arid);
		return "success";
	}

}
