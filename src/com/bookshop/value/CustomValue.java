package com.bookshop.value;

import java.io.InputStream;

import com.sun.corba.se.impl.io.IIOPInputStream;

public class CustomValue {
	private long userid ; 
	private String username ;
	private String truename ;
	private String passwd ;
	private String email	;
	private String phone ;
	private String address ;
	private String postcode ;
	private int grade;
	private boolean Checklogin=false;
	private String Nameexist;
    private String Passerror;
    private String Emailerror;
    private boolean Checkusername=false;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isChecklogin() {
		return Checklogin;
	}
	public void setChecklogin(boolean checklogin) {
		Checklogin = checklogin;
	}
	
	public String getNameexist() {
		return Nameexist;
	}
	public void setNameexist(String nameexist) {
		Nameexist = nameexist;
	}
	public String getPasserror() {
		return Passerror;
	}
	public void setPasserror(String passerror) {
		Passerror = passerror;
	}
	public String getEmailerror() {
		return Emailerror;
	}
	public void setEmailerror(String emailerror) {
		Emailerror = emailerror;
	}
	public boolean isCheckusername() {
		return Checkusername;
	}
	public void setCheckusername(boolean checkusername) {
		Checkusername = checkusername;
	}
	
}

