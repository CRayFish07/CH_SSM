package com.po;

import java.io.Serializable;
import java.lang.reflect.Field;

@SuppressWarnings("serial")
public class User extends BasePo implements Serializable {

	public static void main(String[] args) {
		Field[] fields = User.class.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}

	private String deptId;// 机构id
	private String loginName;// 登录名
	private String password;// 密码
	private String name;// 姓名
	private String sex;// 性别
	private String idcard;// 身份证
	private String phone;// 电话
	private String photoId;// 图片id
	private String state;// 状态：有效、无效
	private String fingerId;// 指纹id
	private String address;// 地址

	public User() {
		super();
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFingerId() {
		return fingerId;
	}

	public void setFingerId(String fingerId) {
		this.fingerId = fingerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
