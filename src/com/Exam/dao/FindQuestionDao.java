package com.Exam.dao;

import java.sql.*;
import java.util.*;
import com.Exam.bean.*;
import com.Exam.sql.GetConn;

public class FindQuestionDao {
	GetConn getConn = new GetConn();
	private Connection conn = getConn.getConnection();

	// 查找所有试题方法
	public List findQuestion() {
		String strSql = "select * from tb_question";
		Statement pstmt = null;
		ResultSet rs = null;
		List lstList = new ArrayList();
		try {
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(strSql);
			while (rs.next()) {
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setTypeid(rs.getInt("typeid"));
				question.setQ_subject(rs.getString("q_subject"));
				question.setQ_answer(rs.getString("q_answer"));
				question.setOptionA(rs.getString("optionA"));
				question.setOptionB(rs.getString("optionB"));
				question.setOptionC(rs.getString("optionC"));
				question.setOptionD(rs.getString("optionD"));
				question.setNote(rs.getString("note"));
				lstList.add(question);
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
		return lstList;
	}

	// 添加考题方法
	public boolean setQuestionDBbean(Question question) {
		boolean blnrec = true;
		String strSql = "insert into tb_question"
				+ " values(?,?,?,?,?,?,?,?,?)";
		System.out.println(strSql);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setInt(1, question.getId());
			pstmt.setInt(2, question.getTypeid());
			pstmt.setString(3, question.getQ_subject());
			pstmt.setString(4, question.getQ_answer());
			pstmt.setString(5, question.getOptionA());
			pstmt.setString(6, question.getOptionB());
			pstmt.setString(7, question.getOptionC());
			pstmt.setString(8, question.getOptionD());
			pstmt.setString(9, question.getNote());
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

	// 修改试题方法
	/**
	 * @param question
	 *            于试题表tb_question对应的java bean类Question对象
	 * @return 成功修改将返回true，否则返回false
	 */
	public boolean updateQuestionDBbean(Question question) {
		boolean blnrec = true;
		String strSql = "update tb_question set q_subject =?,q_answer=?,optionA=?,optionB=? "
				+ ",optionC = ?,optionD = ?, note = ? where id = ?";
		System.out.println(strSql);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setString(1, question.getQ_subject());
			pstmt.setString(2, question.getQ_answer());
			pstmt.setString(3, question.getOptionA());
			pstmt.setString(4, question.getOptionB());
			pstmt.setString(5, question.getOptionC());
			pstmt.setString(6, question.getOptionD());
			pstmt.setString(7, question.getNote());
			pstmt.setInt(8, question.getId());
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

	// 根据套题类型检索套题类型表中套题编号
	public QuestionType getQuestionTypeID(QuestionType qtype) {
		String strSql = "select * from tb_questiontype where qName=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setString(1, qtype.getQName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				qtype.setId(rs.getInt("id"));
				qtype.setQName(rs.getString("qName"));
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
		return qtype;
	}
	public int findQMid() {
		String strSql = "select max(id) as id from tb_question";
		PreparedStatement pstmt = null;
		List list = new ArrayList();
		ResultSet rs = null;
		int id =0;
		try {
			pstmt = conn.prepareStatement(strSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 id = rs.getInt("id");
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
		return id;
	}
	// 夺取不同类型的套题方法
	/**
	 * @param tid
	 *            用于指定试题类型编号的int型变量
	 * @return 返回指定类型的试题集合
	 */
	public List findRadio(int tid) {
		String strSql = "select * from tb_question where typeid = " + tid + "";
		PreparedStatement pstmt = null;
		List list = new ArrayList();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				list.add(id);
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
		return list;
	}

	// 查找题目
	public QuestionType getQuestionType(QuestionType questionType) {
		String strSql = "select * from tb_questionType where qName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setString(1, questionType.getQName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				questionType.setId(rs.getInt("id"));
				questionType.setQName(rs.getString("qName"));
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
		return questionType;
	}

	// 随机获取套题
	/**
	 * @param countid
	 *            要随机抽取试题的个数
	 * @param typeName
	 *            试题类型名称
	 * @return int型数组
	 */
	public int[] radowId(int countid, String typeName) {
		String SQL = "select * from tb_questionType where qName = '" + typeName
				+ "'";
		System.out.println(SQL);
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		int typeid = 0;
		int[] idCount = null;
		try {
			pstmt = conn.prepareStatement(SQL);
			rss = pstmt.executeQuery();
			while (rss.next()) {
				typeid = rss.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List list = findRadio(typeid);
		Set set = new HashSet();
		if (countid <= list.size()) {
			for (int i = 0; i < list.size(); i++) {
				int random = (int) ((Math.random() * list.size()));
				set.add(Integer.parseInt(list.get(random).toString()));
			}
			System.out.println(set.size());
			if ((set.size() == countid)) {
				idCount = new int[countid];
				Iterator it = set.iterator();
				int k = 0;
				while ((it.hasNext())) {
					idCount[k] = Integer.parseInt(it.next().toString());
					k++;
				}
			} else {
				idCount = radowId(countid, typeName);
			}
			return idCount;
		}
		else{
		
			for(int i = 0;i< list.size();i++){
				set.add(Integer.parseInt(list.get(i).toString()));
			}		
			Iterator it = set.iterator();
		
			int k = 0;
			System.out.println(set.size());
			idCount = new int[set.size()];
     		while ((it.hasNext())) {	
				
				idCount[k] = Integer.parseInt(it.next().toString());
				k++;
			}
						return idCount;
		}
	
		
	}


	// 根据id号查找问题
	public Question getQuestion(Question question) {
		String strSql = "select * from tb_question where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setInt(1, question.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				question.setId(rs.getInt("Id"));
				question.setTypeid(rs.getInt("typeid"));
				question.setQ_subject(rs.getString("q_subject"));
				question.setQ_answer(rs.getString("q_answer"));
				question.setOptionA(rs.getString("optionA"));
				question.setOptionB(rs.getString("optionB"));
				question.setOptionC(rs.getString("optionC"));
				question.setOptionD(rs.getString("optionD"));
				question.setNote(rs.getString("note"));
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
		return question;
	}

	// 删除试题方法
	/**
	 * @param lybId
	 *            要进行删除试题的id编号
	 * @return 删除成功将返回true，删除试题失败将返回false
	 */
	public boolean delQuestion(int lybId) {
		boolean blnrec = true;
		String strSql = "delete from tb_question where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(strSql);
			pstmt.setInt(1, lybId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			blnrec = false;
			e.printStackTrace();
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
		FindQuestionDao din = new FindQuestionDao();
		System.out.println(din.findQMid());
	}
}
