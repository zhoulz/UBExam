package com.Exam.sql;
import java.security.*;
import java.sql.*;

public class GetConn {
	public Connection conn=null;
    public ResultSet rs=null;
    public Statement stmt=null;    
    public GetConn() {   //���췽��
    }
    //��ȡ���ݿ����ӷ���
    public Connection getConnection() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
//			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_Exam?useUnicode=true&characterEncoding=gbk","root","root123");
			/*�����Ի���-�Ǿ�����˰*/
			conn=DriverManager.getConnection("jdbc:mysql://10.91.130.249:3307/db_Exam?useUnicode=true&characterEncoding=gbk","root","admin");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�쳣����
		return conn;//������Ҫ�󷵻ظ�Connection����
    }
    
    /*
     *���ܣ�ִ�в�ѯ���
     */
    public ResultSet executeQuery(String sql) {
      try {
        conn = getConnection();
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery(sql);
      }
      catch (SQLException ex) {
        System.err.println(ex.getMessage());
      }
      return rs;
    }

    /*
     *����:ִ�и��²���
     */
    public int executeUpdate(String sql) {
      int result = 0;
      try {
        conn = getConnection();
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY);
        result = stmt.executeUpdate(sql);
      }
      catch (SQLException ex) {
        result = 0;
      }
      try {
        stmt.close();
      }
      catch (SQLException ex1) {
      }
      return result;
    }

        /*
         *����:�ر����ݿ������
         */
        public void close() {
          try {
            if (rs != null) {
              rs.close();
            }
          }
          catch (Exception e) {
            e.printStackTrace(System.err);
          }
          try {
            if (stmt != null) {
              stmt.close();
            }
          }
          catch (Exception e) {
            e.printStackTrace(System.err);
          }
          try {
            if (conn != null) {
              conn.close();
            }
          }
          catch (Exception e) {
            e.printStackTrace(System.err);
          }
      }
       
}
