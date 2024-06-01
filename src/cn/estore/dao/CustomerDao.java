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
	  private Connection connection = null; //�������ӵĶ���
	  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
	  private DBConnection jdbc = null; //�������ݿ����Ӷ���
	  public CustomerDao() {
	    jdbc = new DBConnection();
	    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
	  }

	  //ȫ����ѯ�Ĳ��������û�����Ϊ������ѯ��Ϣ
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
	  
	  
	//�һ�����֮��
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

	//�����ݿ���ˮ��Ϊ�����޸��û�������
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


	//����û�ע����Ϣ
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
	  
	  //ɾ������
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


	  //�û���Ϣ��Ϣ
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



	//ȫ����ѯ��Ϣ����
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

	//�����ݿ���ˮ��Ϊ������ѯ��Ϣ
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

	  
	    //��ѯ���ݿ��Ƿ������ͬ��Ϣ
	   public  boolean hasSameValue(String name, String value) {
	        boolean result = false;  //��������
	        try {	    	
	        	ps= connection.prepareStatement("select * from tb_customer where " + name + " = ?");
	            ps.setString(1, value);          //���ò���
	            ResultSet rs = ps.executeQuery(); //ִ�в�ѯ�����ؽ����
	            //���ݽ�����Ƿ���ھ�����ѯ���
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

