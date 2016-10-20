package critic;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class SaveCriticAction implements Action{
	private String criticEditor;
	public String getCriticEditor() {
		return criticEditor;
	}
	public void setCriticEditor(String criticEditor) {
		this.criticEditor = criticEditor;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("进入后台程序");
		System.out.println("==============="+criticEditor);
		CriticInfo criticInfo = new CriticInfo();
		ActionContext ac = ActionContext.getContext();
		String criticor = (String)ac.getSession().get("userName");
		return SUCCESS;
	}

}
