package model;

/**
 * @author ������
 *Ȩ��
 *javabean
 */
public class Jurisdiction {
	private String i_uuid;//Ȩ������
	private String jtype;//Ȩ��������
	private String jstate;//Ȩ��״̬
	private Usertype usertype; //�û�����
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
