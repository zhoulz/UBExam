/*
 * SkillExamPage.java
 *
 * Created on 2008年8月2日, 下午12:59
 */

package com.Exam.student;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Date;
import javax.swing.*;

import com.Exam.Index.MySudentExamJPanel;
import com.Exam.bean.*;
import com.Exam.dao.*;
//import com.sun.media.sound.Toolkit;
import com.sun.org.apache.xml.internal.serialize.XHTMLSerializer;
/**
 *
 * @author  Administrator
 */
public class SkillExamPage extends javax.swing.JFrame implements Runnable {

	private javax.swing.JTabbedPane ExamTabbedPane;
	private javax.swing.JPanel contentPanel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JButton referjButton;
    private javax.swing.JLabel spareLabel;
    private javax.swing.JLabel sparejLabel;
    private javax.swing.JLabel studentNamejLabel;
    private Thread runner = new Thread(this);   

    private  int countid = 0;				//保存题库行数
    private  int colid = 0;				//保存题库列数

    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timejLabel;
    
    private javax.swing.JLabel LH_Label1;
    
    private javax.swing.JLabel userNameJLabel;
    private javax.swing.JTextField UserjTextField;
//    private javax.swing.JTextArea UserjTextField;
    
    
    
    private javax.swing.JLabel QuesJLabel;
    private javax.swing.JLabel QuesJLabelA;
    private javax.swing.JLabel QuesJLabelB;
    private javax.swing.JLabel QuesJLabelC;
    private javax.swing.JLabel QuesJLabelD;
    
    private javax.swing.JLabel NameJLabel;
    private javax.swing.JLabel ResultJLabel_suc;
    private javax.swing.JLabel ResultJLabel_fail;
    private javax.swing.JLabel TotalJLabel;
    private int TotalNum = 0;
    private int SucNum = 0;
    private int FailNum = 0;
    private String strbuff;
    private String strbuffA;
    private String strbuffB;
    private String strbuffC;
    private String strbuffD;
    
 
    /** Creates new form ExamPage */
    public SkillExamPage() {
 //   	this.setVisible(true);
 //   	this.setSize(900, 1000);
    	this.setVisible(true);
    	this.setLocation(400, 150);




        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
        contentPanel = new javax.swing.JPanel();
//        contentPanel = new MySudentExamJPanel();
        studentNamejLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timejLabel = new javax.swing.JLabel();     
        sparejLabel = new javax.swing.JLabel();
        spareLabel = new javax.swing.JLabel(); 
        
        LH_Label1 = new javax.swing.JLabel();
        
        
        userNameJLabel = new javax.swing.JLabel();
        UserjTextField = new javax.swing.JTextField();
//        UserjTextField = new javax.swing.JTextArea(410,30);
        
        ResultJLabel_suc = new javax.swing.JLabel();
        ResultJLabel_fail = new javax.swing.JLabel();
        QuesJLabel = new javax.swing.JLabel();
        QuesJLabelA = new javax.swing.JLabel();
        QuesJLabelB = new javax.swing.JLabel();
        QuesJLabelC = new javax.swing.JLabel();
        QuesJLabelD = new javax.swing.JLabel();
        
        NameJLabel = new javax.swing.JLabel();
        TotalJLabel = new javax.swing.JLabel();
        

        referjButton = new javax.swing.JButton();
        
        
        Image img=Toolkit.getDefaultToolkit().getImage("/image/a.gif"); 

        setIconImage(img);//获得图片
        
        setTitle("技能考试模块");
//        setBounds(31, 31, 600, 900);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        studentNamejLabel.setText("考生姓名：");
    	java.io.File file = new java.io.File("save.txt");
    	java.io.FileInputStream in;
		try {
			in = new java.io.FileInputStream(file);
			byte byt[] = new byte[1024];					
			int len = in.read(byt);						
			String strid = new String(byt,0,len);	
			int id = Integer.parseInt(strid);
			MyFindUserDao findUser = new MyFindUserDao();
			User user = new User();
			user.setId(id);
			User use = findUser.getUserID(user);
		    jLabel1.setText(ChDeal.toChinese(use.getUserName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
        timeLabel.setText("考试时间：");
        Stat stat = new Stat();
        stat.setId(2);
        FindStat findStat = new FindStat();
        Stat st = findStat.getStat(stat);
        int time = st.getExam_time();
        timejLabel.setText(time+"分钟");
                
        sparejLabel.setText("剩余时间：");
        if (runner != null)
			runner.start(); 
        
        LH_Label1.setText("携手创业,共同成长;持续学习,拥抱变化");
        LH_Label1.setFont(new java.awt.Font("楷体", 1, 30));
        LH_Label1.setForeground(Color.blue);
        
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh ");
        
        
        

         
        referjButton.setText("提交考卷");
        referjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referjButtonActionPerformed(evt);
            }
        });
        
    
        
        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(studentNamejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(timejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(sparejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(referjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(31, 31, 31)
                  	.addComponent(QuesJLabel)
                  .addGap(11, 11, 11)
                  	.addComponent(QuesJLabelA)
                  .addGap(11, 11, 11)
                  	.addComponent(QuesJLabelB)
                  .addGap(11, 11, 11)
                  	.addComponent(QuesJLabelC)
                  .addGap(11, 11, 11)
                  	.addComponent(QuesJLabelD)                  
                  .addGap(31, 31, 31)
                  	.addComponent(NameJLabel)                  	
                  .addGap(31, 31, 31)
                   .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                       .addGap(31, 31, 31)
                        .addComponent(userNameJLabel)
 //                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(UserjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                   .addGap(28, 28, 28)
                    .addComponent(ResultJLabel_suc)
                   .addGap(28, 28, 28)
                     .addComponent(ResultJLabel_fail)
                   .addGap(28, 28, 28)
                      .addComponent(TotalJLabel)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
//                        .addComponent(TotalJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                   .addGap(90, 90, 90)  //45
                      .addComponent(LH_Label1))
                		
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNamejLabel)
                    .addComponent(jLabel1)
                    .addComponent(timeLabel)
                    .addComponent(timejLabel)
                    .addComponent(sparejLabel)
                    .addComponent(spareLabel)
                    .addComponent(referjButton))
                .addGap(22, 22, 22)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(QuesJLabel))
                .addGap(11, 11, 11)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(QuesJLabelA))
                .addGap(11, 11, 11)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(QuesJLabelB))
                .addGap(11, 11, 11)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(QuesJLabelC))
                .addGap(11, 11, 11)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(QuesJLabelD))
                .addGap(22, 22, 22)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(NameJLabel))
                .addGap(22, 22, 22)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(userNameJLabel)
                	.addComponent(UserjTextField))
                .addGap(22, 35, 35)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(ResultJLabel_suc))
                .addGap(22, 22, 22)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(ResultJLabel_fail))
                .addGap(22, 22, 22)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(TotalJLabel))
                .addGap(100, 100, 100)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(LH_Label1))	
                .addGap(300, 300, 300)  //18
                .addContainerGap())
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        
        /*取技能试题*/

        	SkillNum SkillNum = new SkillNum();
        	SkillNum.setId(1);
        	FindSkillNum FindSkillNum = new FindSkillNum();
        	SkillNum skillnumbers = FindSkillNum.getSkillNum(SkillNum);
        	countid = countid + 1;
        	colid = colid + 1;
        	strbuffA = skillnumbers.getOptionA();
        	strbuffB = skillnumbers.getOptionB();
        	strbuffC = skillnumbers.getOptionC();
        	strbuffD = skillnumbers.getOptionD();
        	
        	System.out.println("第一道题内容: " + strbuffA);
        	
        	System.out.println("第  "+countid+"组试题:"+"   " + strbuffA.trim()+"   " +strbuffB.trim()+"   " +strbuffC.trim()+"   " +strbuffD.trim());
           	
//        	QuesJLabel.setText("第  "+countid+" 组试题:" +"   "+ strbuffA.trim()+"   " +strbuffB.trim()+"   " +strbuffC.trim()+"   " +strbuffD.trim());
        	
        	QuesJLabel.setText("第  "+countid+" 组试题:" );        	
        	QuesJLabel.setFont(new java.awt.Font("楷体", 1, 20));
        	QuesJLabel.setForeground(Color.red); 
        	
        	QuesJLabelA.setText("第  1 列试题:" +"   "+ strbuffA.trim());  
        	QuesJLabelA.setFont(new java.awt.Font("楷体", 1, 20));
        	QuesJLabelA.setForeground(Color.red); 
        	
        	QuesJLabelB.setText("第  2 列试题:" +"   "+ strbuffB.trim());  
        	QuesJLabelB.setFont(new java.awt.Font("楷体", 1, 20));
        	QuesJLabelB.setForeground(Color.black);
        	
        	QuesJLabelC.setText("第  3 列试题:" +"   "+ strbuffC.trim());  
        	QuesJLabelC.setFont(new java.awt.Font("楷体", 1, 20));
        	QuesJLabelC.setForeground(Color.black); 
        	
        	QuesJLabelD.setText("第  4 试题:" +"   "+  strbuffD.trim());  
        	QuesJLabelD.setFont(new java.awt.Font("楷体", 1, 20));
        	QuesJLabelD.setForeground(Color.black);
        	
        	
        	
        	
        	      	
        	NameJLabel.setText("应输入内容:" + strbuffA.trim());
        	NameJLabel.setFont(new java.awt.Font("楷体", 1, 30));
        	NameJLabel.setForeground(Color.blue);
        
        	userNameJLabel.setText("数据录入: ");
        	UserjTextField.grabFocus();
        	UserjTextField.setFont(new Font("楷体",Font.BOLD,30));
        	UserjTextField.setText("");
        
        
        	       

        	TotalJLabel.setText("完成总数: " + TotalNum  );
        	ResultJLabel_suc.setText("录入正确数: " + SucNum  );
        	ResultJLabel_fail.setText("录入失败数: "+FailNum ); 
        	
        	
        	UserjTextField.addKeyListener(new KeyListener() {
				@Override
				public void  keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					if (e.getKeyCode() == KeyEvent.VK_ENTER){
						System.out.println("Enter输入的内容为: " + UserjTextField.getText());
						System.out.println("题库第  " + countid + " 行,第  "+colid+ " 列数据,总数为:"+ TotalNum);

						switch(colid) {
							case 1 :
								if (strbuffA.trim().equals(UserjTextField.getText().trim())){
								//if (strbuffA.trim().equals(String.valueOf(Double.valueOf(UserjTextField.getText().trim().toString())))){	
									
									SucNum = SucNum +1;
								}
								else {
									FailNum = FailNum + 1; 
								}
								colid = colid + 1;
								strbuff = strbuffB.trim();
								System.out.println("colid 1  " );
								break;

								
							case 2 :
								if (strbuffB.trim().equals(UserjTextField.getText().trim())){
								//if (strbuffB.trim().equals(String.valueOf(Double.valueOf(UserjTextField.getText().trim().toString())))){	
									SucNum = SucNum +1;
								}
								else {
									FailNum = FailNum + 1; 
								}
								colid = colid + 1;
								strbuff = strbuffC.trim();
								System.out.println("colid 2  " );
								break;


							case 3 :
								if (strbuffC.trim().equals(UserjTextField.getText().trim())){
							//	if (strbuffC.trim().equals(String.valueOf(Double.valueOf(UserjTextField.getText().trim().toString())))){	
									SucNum = SucNum +1;
								}
								else {
									FailNum = FailNum + 1; 
								}
								colid = colid + 1;
								strbuff = strbuffD.trim();
								System.out.println("colid 3  " );
								break;

								
							case 4 :
								System.out.println("colid 4  " );
								if (strbuffD.trim().equals(UserjTextField.getText().trim())){
							//	if (strbuffD.trim().equals(String.valueOf(Double.valueOf(UserjTextField.getText().trim().toString())))){	
									SucNum = SucNum +1;
								}
								else {
									FailNum = FailNum + 1; 
								}
								
								if (countid <= 1000){
									
									colid =  1;
									countid = countid + 1;
									
									System.out.println("处理下条题库数据,id  is:   "  + countid);
									
									SkillNum SkillNum = new SkillNum();
						        	SkillNum.setId(countid);
						        	FindSkillNum FindSkillNum = new FindSkillNum();
						        	SkillNum skillnumbers = FindSkillNum.getSkillNum(SkillNum);
						        	
						        									
					        	
									strbuffA = skillnumbers.getOptionA();
									strbuffB = skillnumbers.getOptionB();
									strbuffC = skillnumbers.getOptionC();
									strbuffD = skillnumbers.getOptionD();
									
									System.out.println("note  is:   "  + skillnumbers.getNote());
									
									if (skillnumbers.getNote().equals("F")){
										
										NameJLabel.setText("应输入内容:" + strbuff.trim());
							        	NameJLabel.setFont(new java.awt.Font("楷体", 1, 30));
							        	NameJLabel.setForeground(Color.blue);
							        	UserjTextField.setFont(new Font("楷体",Font.BOLD,30));
							        	UserjTextField.setText("");
							        	TotalNum = TotalNum +1; 
							        	
							        	//TotalJLabel.setText("完成数/总  数: " + TotalNum +"/"+"100" );
							        	TotalJLabel.setText("完成总数: " + TotalNum  );
							        	ResultJLabel_suc.setText("录入正确数: " + SucNum  );
							        	ResultJLabel_fail.setText("录入失败数: "+FailNum ); 
										
										
										
										System.err.println("答题结束，请提交试卷!");	
										JOptionPane.showMessageDialog(null, "答题结束，已自动提交试卷!");
										
										
										
										getGread();
										
										
										
										return;
									}
					        	
									strbuff = strbuffA.trim();
								}
								else{
									System.err.println("答题结束，请提交试卷!");										
									
								}
								break;


						}
						
						System.out.println("第  "+countid+"组数据:"+"       " + strbuffA.trim()+"       " +strbuffB.trim()+"       " +strbuffC.trim()+"       " +strbuffD.trim());
						/*	                   	
						QuesJLabel.setText("第  "+countid+" 组试题:" +"   "+ strbuffA.trim()+"   " +strbuffB.trim()+"   " +strbuffC.trim()+"   " +strbuffD.trim());
			        	QuesJLabel.setFont(new java.awt.Font("楷体", 1, 15));
			        	QuesJLabel.setForeground(Color.red); 	
						*/			        	
			        	
			        	QuesJLabel.setText("第  "+countid+" 组试题:" );        	
			        	QuesJLabel.setFont(new java.awt.Font("楷体", 1, 20));
			        	QuesJLabel.setForeground(Color.red); 
			        	
			        	QuesJLabelA.setText("第  1 列试题:" +"   "+ strbuffA.trim());  
			        	QuesJLabelA.setFont(new java.awt.Font("楷体", 1, 20));
			        	QuesJLabelA.setForeground(Color.black);
			        	 
			        	
			        	QuesJLabelB.setText("第  2 列试题:" +"   "+ strbuffB.trim());  
			        	QuesJLabelB.setFont(new java.awt.Font("楷体", 1, 20));
			        	QuesJLabelB.setForeground(Color.black);
			        	
			        	QuesJLabelC.setText("第  3 列试题:" +"   "+ strbuffC.trim());  
			        	QuesJLabelC.setFont(new java.awt.Font("楷体", 1, 20));
			        	QuesJLabelC.setForeground(Color.black); 
			        	
			        	QuesJLabelD.setText("第  4 试题:" +"   "+  strbuffD.trim());  
			        	QuesJLabelD.setFont(new java.awt.Font("楷体", 1, 20));
			        	QuesJLabelD.setForeground(Color.black);
			        	
			        	switch(colid) {
						case 1 :
							QuesJLabelA.setForeground(Color.red);
							break;
						case 2 :
							QuesJLabelB.setForeground(Color.red);
							break;
						case 3 :
							QuesJLabelC.setForeground(Color.red);
							break;
						case 4 :
							QuesJLabelD.setForeground(Color.red);
							break;
			        	}
			        	
						
						NameJLabel.setText("应输入内容:" + strbuff.trim());
			        	NameJLabel.setFont(new java.awt.Font("楷体", 1, 30));
			        	NameJLabel.setForeground(Color.blue);
			        	UserjTextField.setFont(new Font("楷体",Font.BOLD,30));
			        	UserjTextField.setText("");
			        	TotalNum = TotalNum +1; 
			        	
			        	TotalJLabel.setText("完成总数: " + TotalNum  );
			        	ResultJLabel_suc.setText("录入正确数: " + SucNum  );
			        	ResultJLabel_fail.setText("录入失败数: "+FailNum ); 
			        	
			        	
					}
				}
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
        		
        	});     
}

private void referjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referjButtonActionPerformed
	int n = JOptionPane.showConfirmDialog(this, "确定要提交考卷吗？","确认对话框", JOptionPane.YES_NO_OPTION);
	
	if(n == JOptionPane.YES_OPTION){
		getGread();
	}
	if(n == JOptionPane.NO_OPTION){
		
	}	
}






//获取考分方法
private void getGread(){
	int radioGrage = 0;
	int examGrade = 0;
	int moreGrade = 0;
	int randow = 0;
	
	Stat stat = new Stat();
	stat.setId(2);
	FindStat findStat = new FindStat();
	Stat sta = findStat.getStat(stat);
	randow = (int)(1+Math.random()*(1000-1+1));
	
	System.out.println("总成绩  is:   "  + SucNum);
	
	int sum = radioGrage+examGrade+moreGrade+SucNum;
	
	
	Grade grade = new Grade();
	File file = new File("save.txt");
	try{
		FileInputStream in = new FileInputStream(file);		
		byte byt[] = new byte[1024];					
		int len = in.read(byt) ;	
		
		System.out.println("总成绩  is:   "  + SucNum);
		
		String strbyte = new String(byt,0,len);
		int strid = Integer.parseInt(strbyte);
		User user = new User();
		user.setId(strid);
		MyFindUserDao findUserdao = new MyFindUserDao();
		User uid = findUserdao.getUserID(user);
		if (user.getFlag().trim().equals("0")){
			grade.setId(strid + randow);
		}
		else{
			grade.setId(strid);
		}
		
		
		System.out.println("grade.setId  is:   "  + strid + " 随机数：" + randow + "grade.getId():"+grade.getId());
		
		grade.setUserName(uid.getUserName());
		grade.setRadioResult(radioGrage);
		grade.setFullResule(examGrade);
		grade.setEsitResult(moreGrade);
		grade.setSkillResult(SucNum);
		grade.setBatsisResult(sum);
		grade.setDate(ChDeal.getDateTime());
		InsertGrade inserGrade = new InsertGrade();
		inserGrade.setGradeDBbean(grade);
		in.close();			
		grade.setId(Integer.parseInt(strbyte));
		
		System.out.println("grade 更新成功   "); 
		
	}catch (Exception e) {
		e.printStackTrace();							
	}
	JOptionPane.showMessageDialog(this,"技能总分为："+SucNum,"消息对话框", JOptionPane.WARNING_MESSAGE);
	this.dispose();
}

	
public void run() {
	int grade = 0;
	FindStat findStat = new FindStat();
	Stat stat = new Stat();
	stat.setId(2);
	Stat st = findStat.getStat(stat);
	int examtime = st.getExam_time();
	long time = (long) (examtime * 60 * 1000L);
	Date date = new Date();
	StringWriter swer = new StringWriter();
	StringBuffer sbf = swer.getBuffer();
	PrintWriter pw = new PrintWriter(swer);
	long cur = 0L;
	long end = System.currentTimeMillis() + time;
	while ((cur = end - System.currentTimeMillis()) > 0) {
		date.setTime(cur);
		pw.format("%1$tM:%1$tS", date);
		pw.flush();
		spareLabel.setText(sbf.toString());
		sbf.setLength(0);
		try {
			Thread.sleep(6L);
		} catch (InterruptedException e) {
		}
	}
	spareLabel.setText("00:00");
	try {
		Thread.sleep(1200L);
	} catch (InterruptedException e) {

	}
	spareLabel.setText("时间到!!!");
	JOptionPane.showMessageDialog(this, "强制交卷!", "消息对话框",
			JOptionPane.WARNING_MESSAGE);
	getGread();
}

 }
