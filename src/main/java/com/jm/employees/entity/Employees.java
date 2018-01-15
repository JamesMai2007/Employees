package com.jm.employees.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 
 * 
 * @author James.Mai
 * @email mjl_workhard@163.com
 * @date 2018-01-15 12:12:29
 */
public class Employees implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer empNo;
	//
	private Date birthDate;
	//
	private String firstName;
	//
	private String lastName;
	//
	private String gender;
	//
	private Date hireDate;

	/**
	 * 设置：
	 */
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	/**
	 * 获取：
	 */
	public Integer getEmpNo() {
		return empNo;
	}
	/**
	 * 设置：
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * 获取：
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * 设置：
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * 获取：
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 设置：
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 获取：
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 设置：
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 获取：
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 设置：
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	/**
	 * 获取：
	 */
	public Date getHireDate() {
		return hireDate;
	}




@Override
	public String toString() {
		return "employees{" +
											", empNo=" + empNo +
														", birthDate=" + birthDate +
														", firstName=" + firstName +
														", lastName=" + lastName +
														", gender=" + gender +
														", hireDate=" + hireDate +
								"}";
	}

}
