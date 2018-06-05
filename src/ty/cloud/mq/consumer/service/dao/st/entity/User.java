package ty.cloud.mq.consumer.service.dao.st.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7164509513035169022L;
	private String userId;
	private String wxId;
	private String userName;
	private String realName;
	private String passWord;
	private String passwordSalt;
	private String tel;
	private String gender;
	private String email;
	private String birthDate;
	private String address;
	private String department;
	private String job;
	private String shortTel;
	private String departmentID;
	private String userType;
	
	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getShortTel() {
		return shortTel;
	}
	public void setShortTel(String shortTel) {
		this.shortTel = shortTel;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	
	
	
	
}