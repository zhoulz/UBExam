package com.Exam.bean;

public class User {
  private int id;
  private int UserType;
  private String  UserName;
  private String PassWord;
  private int haveIn;
  private String Flag;
public int getHaveIn() {
	return haveIn;
}
public void setHaveIn(int haveIn) {
	this.haveIn = haveIn;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassWord() {
	return PassWord;
}
public void setPassWord(String passWord) {
	PassWord = passWord;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public int getUserType() {
	return UserType;
}
public void setUserType(int userType) {
	UserType = userType;
}
public String getFlag() {
	return Flag;
}
public void setFlag(String flag) {
	 Flag = flag;
}
  
}
