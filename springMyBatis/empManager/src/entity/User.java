package entity;

public class User {
	private int id;
	private String username;
	private String realname;
	private String password;
	private String sex;
	
	public User() {
		super();
	}
	
	public User(String username, String realname, String password, String sex) {
		super();
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.sex = sex;
	}

	public User(int id, String username, String realname, String password,
			String sex) {
		super();
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
