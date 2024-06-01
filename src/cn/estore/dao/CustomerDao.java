package cn.estore.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.estore.entity.CustomerEntity;
import cn.estore.util.DBConnection;

public class CustomerDao {
	  private Connection connection = null; //定义连接的对象
	  private PreparedStatement ps = null; //定义预准备的对象
	  private DBConnection jdbc = null; //定义数据库连接对象
	  public CustomerDao() {
	    jdbc = new DBConnection();
	    connection = jdbc.connection; //利用构造方法取得数据库连接
	  }

	  //全部查询的操作或以用户名称为条件查询信息
	  public CustomerEntity selectCustomerEntity(String name) {
	    CustomerEntity user = null;
	    try {
	      ps = connection.prepareStatement("select * from tb_customer where user_name=?");
	      ps.setString(1, name);
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	        user = new CustomerEntity();
	        user.setId(Integer.valueOf(rs.getString(1)));
	        user.setUserName(rs.getString(2));
	        user.setPassword(rs.getString(3));
	        user.setRealName(rs.getString(4));
	        user.setMobile(rs.getString(5));
	        user.setEmail(rs.getString(6));
	        user.setPasswordQuestion(rs.getString(7));
	        user.setPasswordHintAnswer(rs.getString(8));
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return user;
	  }
	  
	  
	//找回密码之用
	  public CustomerEntity selectFind(String name, String result) {
	    CustomerEntity user = null;
	    try {
	      ps = connection.prepareStatement("select * from tb_customer where user_name=? and password_hint_answer=?");
	      ps.setString(1, name);
	      ps.setString(2, result);
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	        user = new CustomerEntity();
	        user.setId(Integer.valueOf(rs.getString(1)));
	        user.setUserName(rs.getString(2));
	        user.setPassword(rs.getString(3));
	        user.setRealName(rs.getString(4));
	        user.setMobile(rs.getString(5));
	        user.setEmail(rs.getString(6));
	        user.setPasswordQuestion(rs.getString(7));
	        user.setPasswordHintAnswer(rs.getString(8));
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return user;
	  }

	//以数据库流水号为条件修改用户的密码
	  public boolean updatePassword(String password, Integer id) {
	    try {
	      ps = connection.prepareStatement("update tb_customer set password=? where id=?");
	      ps.setString(1, password);
	      ps.setInt(2, id.intValue());
	      ps.executeUpdate();
	      ps.close();
	      return true;
	    }
	    catch (SQLException ex) {
	      return false;
	    }
	  }


	//添加用户注册信息
	  public boolean insertCustomer(CustomerEntity user) {
	    try {
	      ps = connection.prepareStatement("insert into tb_customer(user_name,password,real_name,mobile,email,password_question,password_hint_answer) values(?,?,?,?,?,?,?)");
//	      ps.setString(1, String.valueOf(user.getId()));
		      ps.setString(1, user.getUserName());
		      ps.setString(2, user.getPassword());
		      ps.setString(3, user.getRealName());
		      ps.setString(4, user.getMobile());
		      ps.setString(5, user.getEmail());
		      ps.setString(6, user.getPasswordQuestion());
		      ps.setString(7, user.getPasswordHintAnswer());
		      ps.executeUpdate();
		      ps.close();
		      return true;
	    }
	    catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	    	return false;
	    }
	  }
	  
	  //删除操作
	  public boolean deleteCustomer(Integer id) {
	    try {
	      ps = connection.prepareStatement("delete from tb_customer where id=?");
	      ps.setString(1, id.toString());
	      ps.executeUpdate();
	      ps.close();
	      return true;
	    }
	    catch (SQLException ex) {
	      return false;
	    }
	  }


	  //用户信息信息
	  public boolean updateCustomer(CustomerEntity user) {
	    try {
	      ps = connection.prepareStatement("update tb_customer set user_name=?,password=?,real_name=?,mobile=?,email=?,password_question=?,password_hint_answer=? where id=?");

	      ps.setString(1, user.getUserName());
	      ps.setString(2, user.getPassword());
	      ps.setString(3, user.getRealName());
	      ps.setString(4, user.getMobile());
	      ps.setString(5, user.getEmail());
	      ps.setString(6, user.getPasswordQuestion());
	      ps.setString(7, user.getPasswordHintAnswer());
	      
	      ps.setString(8, String.valueOf(user.getId()));
	      
	      System.out.print(user.getUserName()+String.valueOf(user.getId()));
	      ps.executeUpdate();
	      ps.close();
	      return true;
	    }
	    catch (SQLException ex) {
	    	
	      return false;
	    }
	  }



	//全部查询信息操作
	  public List selectCustomer() {
	    List list = new ArrayList();
	    CustomerEntity user = null;
	    try {
	      ps = connection.prepareStatement("select * from tb_customer order by id DESC");
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	        user = new CustomerEntity();
	        user.setId(Integer.valueOf(rs.getString(1)));
	        user.setUserName(rs.getString(2));
	        user.setPassword(rs.getString(3));
	        user.setRealName(rs.getString(4));
	        user.setMobile(rs.getString(5));
	        user.setEmail(rs.getString(6));
	        user.setPasswordQuestion(rs.getString(7));
	        user.setPasswordHintAnswer(rs.getString(8));
	        list.add(user);
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return list;
	  }

	//以数据库流水号为条件查询信息
	  public CustomerEntity selectOneCustomer(Integer id) {
	    CustomerEntity user = null;
	    try {
	      ps = connection.prepareStatement("select * from tb_customer where id=?");
	      ps.setInt(1, id.intValue());
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	        user = new CustomerEntity();
	        user.setId(Integer.valueOf(rs.getString(1)));
	        user.setUserName(rs.getString(2));
	        user.setPassword(rs.getString(3));
	        user.setRealName(rs.getString(4));
	        user.setMobile(rs.getString(5));
	        user.setEmail(rs.getString(6));
	        user.setPasswordQuestion(rs.getString(7));
	        user.setPasswordHintAnswer(rs.getString(8));
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return user;
	  }

	  
	    //查询数据库是否存在相同信息
	   public  boolean hasSameValue(String name, String value) {
	        boolean result = false;  //保存检测结果
	        try {	    	
	        	ps= connection.prepareStatement("select * from tb_customer where " + name + " = ?");
	            ps.setString(1, value);          //设置参数
	            ResultSet rs = ps.executeQuery(); //执行查询，返回结果集
	            //根据结果集是否存在决定查询结果
	            if (rs.next()) {
	                result = true;
	            } else {
	                result = false;
	            }
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	        } finally {

	        }
	        return result;
	    }	  
}

