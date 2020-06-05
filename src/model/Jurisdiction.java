package model;

/**
 * @author 王家南
 *权限
 *javabean
 */
public class Jurisdiction {
	private String i_uuid;//权限主键
	private String jtype;//权限类型名
	private String jstate;//权限状态
	private Usertype usertype; //用户类型
	public String getI_uuid() {
		return i_uuid;
	}
	public void setI_uuid(String i_uuid) {
		this.i_uuid = i_uuid;
	}
	public String getJtype() {
		return jtype;
	}
	public void setJtype(String jtype) {
		this.jtype = jtype;
	}
	public String getJstate() {
		return jstate;
	}
	public void setJstate(String jstate) {
		this.jstate = jstate;
	}
	public Usertype getUsertype() {
		return usertype;
	}
	public void setUsertype(Usertype usertype) {
		this.usertype = usertype;
	}
	public Jurisdiction(){}
	public Jurisdiction(String i_uuid, String jtype, String jstate, Usertype usertype) {
		super();
		this.i_uuid = i_uuid;
		this.jtype = jtype;
		this.jstate = jstate;
		this.usertype = usertype;
	}
	@Override
	public String toString() {
		return "Jurisdiction [i_uuid=" + i_uuid + ", jtype=" + jtype + ", jstate=" + jstate + ", usertype=" + usertype
				+ "]";
	}
	
	
	
}
