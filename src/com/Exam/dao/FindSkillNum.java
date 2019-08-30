package com.Exam.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Exam.bean.*;
import com.Exam.sql.GetConn;
public class FindSkillNum {
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();
//	按id号查询成绩方法
/**
 * @param SkillNum	该方法以与系统参数表tb_skillnumbers对应的Java bean为SkillNum对象作为参数
 * @return		返回SkillNum对象
 */

public SkillNum getSkillNum(SkillNum skillnum){
	String strSql = "select * from tb_skillnumbers where id=?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String note = null;
	
//	List lstList = new ArrayList();
	try {
		pstmt = conn.prepareStatement(strSql);
		pstmt.setInt(1, skillnum.getId());
		System.out.println(pstmt);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			skillnum.setId(rs.getInt("id"));
			skillnum.setOptionA(rs.getString("optionA"));
			skillnum.setOptionB(rs.getString("optionB"));
			skillnum.setOptionC(rs.getString("optionC"));
			skillnum.setOptionD(rs.getString("optionD"));
			skillnum.setNote(rs.getString("note"));
			note = rs.getString("optionA");
//			lstList.add(skillnum);
		}
		System.out.println("rs is:" +rs);
		System.out.println("optionA is:" +note);
		System.out.println("optionA is:" +note);
		System.out.println("rs.getRow is:" +rs.getRow());
		
		if (note == null || note.isEmpty()){
//		if (rs.getRow()<1){
			skillnum.setNote("F"); //*无数据*
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null) {
				rs.close();
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return skillnum;
}
 
}
