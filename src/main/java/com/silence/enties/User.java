package com.silence.enties;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// 用户id
	private int id;
	// 用户姓名
	@Column(length=32)
	private String name;
	// 用户电话
	private String telephone;
	// 用户出生日期
	@DateTimeFormat(pattern="MM-dd-yyyy")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public User(int id, String name, String telephone, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.birthday = birthday;
	}
	public User() {
		super();
	}
	public User(String telephone) {
		super();
		this.telephone = telephone;
	}

}
