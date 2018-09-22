package entity;

public class User {
	private int icqno;
	private String user_name;
	private String password;
	private byte status;
	private String ip;
	private String info;
	private int pic_no;
	private String sex;
	private String email;
	private String address;
	public User() {
		super();
	}
	public int getIcqno() {
		return icqno;
	}
	public void setIcqno(int icqno) {
		this.icqno = icqno;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPic_no() {
		return pic_no;
	}
	public void setPic_no(int picNo) {
		pic_no = picNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
