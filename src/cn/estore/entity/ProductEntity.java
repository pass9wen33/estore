package cn.estore.entity;

/*�������ݿ���Ʒ��Ϣʵ����*/
public class ProductEntity {
	private int id; /* ������� */
	private int categoryMainId; /* ������ */
	private int categoryBranchId; /* С���� */
	private String name; /* ��Ʒ���� */
	private String producingArea; /* ��Ʒ���� */
	private String description; /* ��Ʒ���� */
	private String createTime; /* ��Ʒ����ʱ�� */
	private float marketPrice; /* ��Ʒԭ�� */
	private float sellPrice; /* ��Ʒ�ּ� */
	private int productAmount; /* ��Ʒ������ */
	private String picture; /* ��ƷͼƬ */
	private int discount; /* �Ƿ����ۿ� 1���ۿۣ�0���ۿ� */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryMainId() {
		return categoryMainId;
	}

	public void setCategoryMainId(int categoryMainId) {
		this.categoryMainId = categoryMainId;
	}

	public int getCategoryBranchId() {
		return categoryBranchId;
	}

	public void setCategoryBranchId(int categoryBranchId) {
		this.categoryBranchId = categoryBranchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducingArea() {
		return producingArea;
	}

	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public float getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}

	public float getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}



	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
