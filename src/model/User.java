package model;

/**
 * @author ������
 * �û�
 *Javabean
 */
public class User {
	private String u_uuid;//�û�����
	private int uid;//�û����
	private String uname;//�û�����
	private String upassword;//�û�����
	private String ustate;//�û�״̬
	private Usertype usertype;  //�û�����
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
