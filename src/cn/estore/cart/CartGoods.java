package cn.estore.cart;


public class CartGoods {
	//���ﳵ�е���Ʒ
	public int ID;    //��ƷID
	public float price;    //�۸�
	public int number;     //����

	public CartGoods(int goodsId,float goodsPrice,int goodsNumber ){
		this.ID=goodsId;
		this.price=goodsPrice;
		this.number=goodsNumber;
	}

}
