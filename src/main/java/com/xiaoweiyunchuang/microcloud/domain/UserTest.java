package com.xiaoweiyunchuang.microcloud.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserTest implements Serializable {

	private static final long serialVersionUID = 8809101560720973267L;

	private int id;

	private String name;

	private int age;

	private String password;

	private BigDecimal salary;
	
	private Date createTime;

	public UserTest() {

	}

	public UserTest(int id, String name, int age, BigDecimal salary, String password) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTest other = (UserTest) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", salary=" + salary
				+ "]";
	}

}