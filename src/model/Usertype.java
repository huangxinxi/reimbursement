package model;

import java.util.Set;

/**
 * @author ������
 *�û�����
 *javabean
 */
public class Usertype {
	private String ut_uuid;//�û���������
	private String uttype;//�û�������
	private String ustate;//�û�����״̬
	public String getUt_uuid() {
		return ut_uuid;
	}
	public void setUt_uuid(String ut_uuid) {
		this.ut_uuid = ut_uuid;
	}
	public String getUttype() {
		return uttype;
	}
	public void setUttype(String uttype) {
		this.uttype = uttype;
	}
	public String getUstate() {
		return ustate;
	}
	public void setUstate(String ustate) {
		this.ustate = ustate;
	}
	@Override
	public String toString() {
		return "Usertype [ut_uuid=" + ut_uuid + ", uttype=" + uttype + ", ustate=" + ustate + "]";
	}
	public Usertype(){
	}
	public Usertype(String ut_uuid, String uttype, String ustate) {
		super();
		this.ut_uuid = ut_uuid;
		this.uttype = uttype;
		this.ustate = ustate;
	}
	
	
}
