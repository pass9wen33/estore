package cn.estore.entity;
//����ʵ����
public class OrderEntity {
	private String orderId;    			//������ϸ���
	private String name;       			//�����Ļ�Ա��
	private String realName;  			//�û��� 
	private String address;   			//�ͻ���ַ 
	private String mobile;    			//�û��ֻ���
	private float totalPrice; 			// �����ܽ�� 
	private String deliveryMethod;		//���ͷ�ʽ
	private String memo; 				//��ע
	private Boolean deliverySign=false; //�Ƿ��Ѿ�������Ĭ�������ɶ���û����
	private String createTime;   		//���֧����ʽ,�ı�����
	private String paymentmode;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Boolean getDeliverySign() {
		return deliverySign;
	}
	public void setDeliverySign(Boolean deliverySign) {
		this.deliverySign = deliverySign;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

}
