package cn.estore.entity;
//订单明细实体类
public class OrderItemEntity {
	private int id;  					//自增编号
	private String orderId; 			//所属订单编号
	private int productId; 				//订单中商品的编号
	private String productName; 		//商品名
	private float productPrice; 		//订购的商品价格
	private int amount;  				//订购商品数量
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
