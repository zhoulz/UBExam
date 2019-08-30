package com.Exam.dao;

import java.sql.*;
import java.util.*;

import com.Exam.bean.*;
import com.Exam.sql.GetConn;

public class InsertUserDao {
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
	//�����û�
	public boolean setUserInfoToDBbean(User userinfo) {
		boolean blnrec = true;
		String strSql = "insert into tb_user"
				+ " values(?,?,?,?,?)";
		System.out.println(strSql);
		PreparedStatement pstmt = null;
//		MyMD5 md = new MyMD5();
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setInt(1, userinfo.getId());
			pstmt.setInt(2, userinfo.getUserType());
			pstmt.setString(3, userinfo.getUserName());
//			pstmt.setString(4, md.createPassWord(userinfo.getPassWord()));
			pstmt.setString(4, userinfo.getPassWord());
			pstmt.setInt(5, userinfo.getHaveIn());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			blnrec = false;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return blnrec;
	} 
	//�޸��û��������ж��û��Ƿ��Ѳμӿ���
/**
 * @param userinfo ���û���tb_use��Ӧ��Java bean
 * @return �ɹ��޸�havaInֵ����true�����򷵻�false
 */
public boolean setUserHaveIn(User userinfo) {
	boolean blnrec = true;
	String strSql = "update tb_User set havaIn = ? where username =?";
	PreparedStatement pstmt = null;
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setInt(1, userinfo.getHaveIn());
		pstmt.setString(2, userinfo.getUserName());
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
		blnrec = false;
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	return blnrec;
} 
	//�޸��û���Ϣ
	public boolean updateUserHaveIn(User userinfo) {
		boolean blnrec = true;
		String strSql = "update tb_user set userType =?,UserName=?,passWord=?,havaIn=? " +
				"where Id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setInt(1, userinfo.getUserType());
			pstmt.setString(2, userinfo.getUserName());
			pstmt.setString(3, userinfo.getPassWord());
			pstmt.setInt(4,userinfo.getHaveIn());
			pstmt.setInt(5, userinfo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			blnrec = false;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return blnrec;
	} 
//	�޸��û�������Ϣ
	public boolean updateUserPassWord(User userinfo) {
		boolean blnrec = true;
		String strSql = "update tb_user set passWord=? " +
				"where Id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(strSql);		
			MyMD5 mymd5 = new MyMD5();
			pstmt.setString(1, mymd5.createPassWord(userinfo.getPassWord()));
			pstmt.setInt(2,userinfo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			blnrec = false;
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return blnrec;
	} 
	
	public static void main(String[] args) {
		User user = new User();
		user.setId(5);
		user.setUserName("kk");
		user.setPassWord("111");
		user.setHaveIn(0);
		user.setUserType(0);
		InsertUserDao id = new InsertUserDao();
		boolean bool = id.setUserInfoToDBbean(user);
		System.out.println(bool);
	}
}
