package com.mxq.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Users {
	@NotBlank(message = "名字不能为空！")//非空校验
	@Length(max = 6,min = 2,message = "超出长度范围")
	private String name;
	@NotEmpty(message = "密码不能为空！")//密码非空校验
	private String password;
	@Min(value = 15,message = "最小年龄不能小于15岁")
	@Max(value = 30,message = "最大年龄不能大于30岁")
	private Integer age;
	
	@Email(message = "不合法")
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
