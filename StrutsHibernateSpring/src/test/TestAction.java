package test;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String textbox1;

	public String getTextbox1() {
		return textbox1;
	}

	public void setTextbox1(String textbox1) {
		this.textbox1 = textbox1;
	}
	
	public String execute() throws Exception{
		System.out.println("已进入后台处理程序");
		String text = getTextbox1();
		System.out.println("========="+text);
//		HttpServletRequest request = ServletActionContext.getRequest();
//		System.out.println("Request================"+request.getParameter("textbox1"));
////		ActionContext ac = ActionContext.getContext();
////		System.out.println("==============="+getTextbox1()+ac.get("textbox1").toString());
//		String text = request.getParameter("textbox1");
		if(text!=null){
			return "success";
		}else{
			return "error";
		}
	}
}
