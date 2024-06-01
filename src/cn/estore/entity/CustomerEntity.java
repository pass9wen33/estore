package cn.estore.entity;

public class CustomerEntity {
	private int id;//自增编号
	private String userName;//客户帐号name->user_name
	private String password;//客户密码
	private String realName;//客户姓名reallyName->real_name
	private String mobile;//新增客户手机字段
	private String email;//客户email
	private String passwordQuestion;//客户密码提示问题question->password_question
	private String passwordHintAnswer;//客户密码提示答案 result->password_hint_answer
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordQuestion() {
		return passwordQuestion;
	}
	public void setPasswordQuestion(String passwordQuestion) {
		this.passwordQuestion = passwordQuestion;
	}
	public String getPasswordHintAnswer() {
		return passwordHintAnswer;
	}
	public void setPasswordHintAnswer(String passwordHintAnswer) {
		this.passwordHintAnswer = passwordHintAnswer;
	}
	
}
