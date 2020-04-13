package letter.model.vo;

import java.sql.Date;

public class Letter {
	private int msgNo;
	private String userId;
	private String msg_Title;
	private String msg_Content;
	private Date msg_Date;
	private char state;
	private String userName;
	
	
	public Letter() {
		super();
	}
	
	// 쪽지 전달 생성자
	public Letter(String userId, String msg_Title, String msg_Content, String userName) {
		super();
		this.userId = userId;
		this.msg_Title = msg_Title;
		this.msg_Content = msg_Content;
		this.userName = userName;
	}


	//전체 생성자
	public Letter(int msgNo, String userId, String msg_Title, String msg_Content, Date msg_Date, char state,
			String userName) {
		super();
		this.msgNo = msgNo;
		this.userId = userId;
		this.msg_Title = msg_Title;
		this.msg_Content = msg_Content;
		this.msg_Date = msg_Date;
		this.state = state;
		this.userName = userName;
	}
	public int getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMsg_Title() {
		return msg_Title;
	}
	public void setMsg_Title(String msg_Title) {
		this.msg_Title = msg_Title;
	}
	public String getMsg_Content() {
		return msg_Content;
	}
	public void setMsg_Content(String msg_Content) {
		this.msg_Content = msg_Content;
	}
	public Date getMsg_Date() {
		return msg_Date;
	}
	public void setMsg_Date(Date msg_Date) {
		this.msg_Date = msg_Date;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Letter [msgNo=" + msgNo + ", userId=" + userId + ", msg_Title=" + msg_Title + ", msg_Content="
				+ msg_Content + ", msg_Date=" + msg_Date + ", state=" + state + ", userName=" + userName + "]";
	}
	

}
