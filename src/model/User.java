package model;

/**
 * @author 王家南
 * 用户
 *Javabean
 */
public class User {
	private String u_uuid;//用户主键
	private int uid;//用户编号
	private String uname;//用户姓名
	private String upassword;//用户密码
	private String ustate;//用户状态
	private Usertype usertype;  //用户类型
	public String getU_uuid() {
		return u_uuid;
	}
	public void setU_uuid(String u_uuid) {
		this.u_uuid = u_uuid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUstate() {
		return ustate;
	}
	public void setUstate(String ustate) {
		this.ustate = ustate;
	}
	public Usertype getUsertype() {
		return usertype;
	}
	public void setUsertype(Usertype usertype) {
		this.usertype = usertype;
	}
	public User(){
		
	}
	public User(String u_uuid, int uid, String uname, String upassword, String ustate, Usertype usertype) {
		super();
		this.u_uuid = u_uuid;
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.ustate = ustate;
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "User [u_uuid=" + u_uuid + ", uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", ustate="
				+ ustate + ", usertype=" + usertype + "]";
	}
	
}
