package cn.estore.util;
/*�������ݿ�������*/
import java.sql.*;
public class DBConnection {
   /*�������ݿ�����*/
private String dbDriver = DatabaseConfig.getDriverClassName();
   /*ָ�����ݿ������ַ���*/
   private String url = DatabaseConfig.getUrl();
//private String url = "jdbc:mysql://rm-cn-jia3mxrdy0009cco.rwlb.rds.aliyuncs.com:3306/estore?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
   public Connection connection = null;
   public DBConnection() {
      try {
         Class.forName(dbDriver).newInstance();
         //connection = DriverManager.getConnection(url, "root", "CloudRds!");
          connection = DriverManager.getConnection(url, DatabaseConfig.getUsername(), DatabaseConfig.getPassword());
       } catch (Exception ex) {
         System.out.println("connect to db mysql fail.");
         System.out.println(ex.getMessage());
       }
   }
}

