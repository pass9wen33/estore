package cn.estore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cn.estore.entity.ProductEntity;

import cn.estore.util.DBConnection;


public class ProductDao {
	private Connection connection = null; // 定义连接的对象
	private PreparedStatement ps = null; // 定义预准备的对象
	private DBConnection jdbc = null; // 定义数据库连接对象

	public ProductDao() {
		jdbc = new DBConnection();
		connection = jdbc.connection; // 利用构造方法取得数据库连接
	}

	// 全部查询
	public List selectAllProducts() {
		List list = new ArrayList();
		ProductEntity e = null;
		try {
			ps = connection
					.prepareStatement("select * from tb_product order by id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new ProductEntity();
				e.setId(rs.getInt(1));
				e.setCategoryMainId(rs.getInt(2));
				e.setCategoryBranchId(rs.getInt(3));
				e.setName(rs.getString(4));
				e.setProducingArea(rs.getString(5));
				e.setDescription(rs.getString(6));
				e.setCreateTime(rs.getString(7));
				e.setMarketPrice(rs.getFloat(8));
				e.setSellPrice(rs.getFloat(9));
				e.setProductAmount(rs.getInt(10));
				e.setPicture(rs.getString(11));
				e.setDiscount(rs.getInt(12));
				list.add(e);
			}
		} catch (SQLException ex) {
			System.out.println("数据库访问失败");
		}
		return list;
	}

	// 以商品的是否新品/特价为条件查询信息
	public List selectProductsDiscount(Integer discount) {// discount为1:特价商品
		// 0:新品
		List list = new ArrayList();
		try {
			ps = connection.prepareStatement("select * from tb_product where discount=? order by id DESC");
			ps.setInt(1, discount.intValue());
			ResultSet rs = ps.executeQuery();
			list = Rs2List(rs);
		} catch (SQLException ex) {
			System.out.println("数据库访问失败");
		}
		return list;
	}

	// 以商品的名称为搜索条件查询所有商品
	public List selectProductsSearch(String search) {
		List list = new ArrayList();
		try {
			String strSql = "select * from tb_product where name like  '%"+ search.trim() + "%' order by id DESC";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(strSql);
			list = Rs2List(rs);
		} catch (SQLException ex) {
		}
		return list;
	}

	// 以商品的编号为条件查询单个商品 信息
	public ProductEntity selectOneProducts(int id) {
		ProductEntity e = new ProductEntity();
		try {
			ps = connection.prepareStatement("select * from tb_product where id=? order by id DESC");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e.setId(rs.getInt(1));
				e.setCategoryMainId(rs.getInt(2));
				e.setCategoryBranchId(rs.getInt(3));
				e.setName(rs.getString(4));
				e.setProducingArea(rs.getString(5));
				e.setDescription(rs.getString(6));
				e.setCreateTime(rs.getString(7));
				e.setMarketPrice(rs.getFloat(8));
				e.setSellPrice(rs.getFloat(9));
				e.setProductAmount(rs.getInt(10));
				e.setPicture(rs.getString(11));
				e.setDiscount(rs.getInt(12));
			}
		} catch (SQLException ex) {
		}
		return e;
	}

	// 以商品编号查询商品名称
	public String selectOneNameByProductId(int id) {
		String name = null;
		try {
			ps = connection
					.prepareStatement("select * from tb_product where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString(4);
			}
		} catch (SQLException ex) {
		}
		return name;
	}
	
	// 根据商品的ID修改商品的销售数量
	public boolean updateAProductSoldNumber(int productAmount, int id) {
		try {
			ps = connection
					.prepareStatement("update tb_product set product_amount=product_amount+? where id=?");
			ps.setInt(1, productAmount);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException ex) {
			System.out.println("更新数据表商品销量失败！");
			return false;
		}
	}
	
	// 以商品的大类别的编号为条件查询信息
	public List selectProductByCatagoryMain(int big) {
		List list = new ArrayList();
		try {
			if (big == 0 || big == -1) {
				ps = connection
						.prepareStatement("select * from tb_product order by id DESC");
			} else {
				ps = connection
						.prepareStatement("select * from tb_product where category_main_id=? order by id DESC");
				ps.setInt(1, big);
			}
			ResultSet rs = ps.executeQuery();
			list = Rs2List(rs);

		} catch (SQLException ex) {
		}
		return list;
	}

	// 查询销售排行
	public List selectProductsRank() {
		List list = new ArrayList();
		try {
			// 查询商品销量前七位的相关商品资料
			ps = connection
					.prepareStatement("select top 7 * from tb_product order by product_amount DESC");
			ResultSet rs = ps.executeQuery();
			list = Rs2List(rs);
		} catch (SQLException ex) {
		}
		return list;
	}

	// ResultSet类型数据转制为List,其中元素为 ProductEntity
	public List Rs2List(ResultSet rs) {
		List list = new ArrayList();
		ProductEntity e = null;
		try {
			while (rs.next()) {
				e = new ProductEntity();
				e.setId(rs.getInt(1));
				e.setCategoryMainId(rs.getInt(2));
				e.setCategoryBranchId(rs.getInt(3));
				e.setName(rs.getString(4));
				e.setProducingArea(rs.getString(5));
				e.setDescription(rs.getString(6));
				e.setCreateTime(rs.getString(7));
				e.setMarketPrice(rs.getFloat(8));
				e.setSellPrice(rs.getFloat(9));
				e.setProductAmount(rs.getInt(10));
				e.setPicture(rs.getString(11));
				e.setDiscount(rs.getInt(12));
				list.add(e);
			}
		} catch (SQLException ex) {
			System.out.println("Rs转换为List失败！");
		}
		return list;
	}

}
