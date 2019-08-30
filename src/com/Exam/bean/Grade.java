package com.Exam.bean;

public class Grade {
	private int id;
	private String UserName;
	private int radioResult;
	private int fullResule;
	private int esitResult;
	private int batsisResult;
	private int skillResult;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBatsisResult() {
		return batsisResult;
	}
	public void setBatsisResult(int batsisResult) {
		this.batsisResult = batsisResult;
	}
	public int getEsitResult() {
		return esitResult;
	}
	public void setEsitResult(int esitResult) {
		this.esitResult = esitResult;
	}
	public int getFullResule() {
		return fullResule;
	}
	public void setFullResule(int fullResule) {
		this.fullResule = fullResule;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRadioResult() {
		return radioResult;
	}
	public void setRadioResult(int radioResult) {
		this.radioResult = radioResult;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getSkillResult() {
		return skillResult;
	}
	public void setSkillResult(int skillResult) {
		this.skillResult = skillResult;
	}
}
