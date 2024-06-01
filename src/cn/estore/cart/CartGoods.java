package cn.estore.cart;


public class CartGoods {
	//购物车中的商品
	public int ID;    //商品ID
	public float price;    //价格
	public int number;     //数量

	public CartGoods(int goodsId,float goodsPrice,int goodsNumber ){
		this.ID=goodsId;
		this.price=goodsPrice;
		this.number=goodsNumber;
	}

}
