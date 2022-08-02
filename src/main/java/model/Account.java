package model;

public class Account {
	private String mail,pass,name,address,phone;
	private int role;
	public Account() {
		
	}
	public Account(String mail, String pass, String name, String address, String phone, int role) {
	
		this.mail = mail;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.role = role;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Acount [mail=" + mail + ", pass=" + pass + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", role=" + role + "]";
	}
	
}
