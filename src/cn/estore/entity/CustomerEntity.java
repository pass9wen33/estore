package cn.estore.entity;

public class CustomerEntity {
	private int id;//�������
	private String userName;//�ͻ��ʺ�name->user_name
	private String password;//�ͻ�����
	private String realName;//�ͻ�����reallyName->real_name
	private String mobile;//�����ͻ��ֻ��ֶ�
	private String email;//�ͻ�email
	private String passwordQuestion;//�ͻ�������ʾ����question->password_question
	private String passwordHintAnswer;//�ͻ�������ʾ�� result->password_hint_answer
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
