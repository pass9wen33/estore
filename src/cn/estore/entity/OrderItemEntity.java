package cn.estore.entity;
//������ϸʵ����
public class OrderItemEntity {
	private int id;  					//�������
	private String orderId; 			//�����������
	private int productId; 				//��������Ʒ�ı��
	private String productName; 		//��Ʒ��
	private float productPrice; 		//��������Ʒ�۸�
	private int amount;  				//������Ʒ����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
