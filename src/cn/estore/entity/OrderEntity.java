package cn.estore.entity;
//订单实体类
public class OrderEntity {
	private String orderId;    			//订单详细编号
	private String name;       			//订单的会员名
	private String realName;  			//用户名 
	private String address;   			//送货地址 
	private String mobile;    			//用户手机号
	private float totalPrice; 			// 订单总金额 
	private String deliveryMethod;		//寄送方式
	private String memo; 				//备注
	private Boolean deliverySign=false; //是否已经发货，默认新生成订单没发货
	private String createTime;   		//存放支付方式,文本类型
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
