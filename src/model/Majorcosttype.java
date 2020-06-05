package model;

import java.util.List;

/**
 * @author ������
 *��Ҫ��������
 *javabean
 */
public class Majorcosttype {
	private String mt_uuid;//��������������
	private String mtid;//���������ͱ��
	private String mttype;//������������
	private String mtstate;//����������״̬
	
	private List<Subcosttype> subcosttypes;//���Ĵη���
	
	public List<Subcosttype> getSubcosttypes() {
		return subcosttypes;
	}
	public void setSubcosttypes(List<Subcosttype> subcosttypes) {
		this.subcosttypes = subcosttypes;
	}

	public String getMt_uuid() {
		return mt_uuid;
	}

	public void setMt_uuid(String mt_uuid) {
		this.mt_uuid = mt_uuid;
	}

	public String getMtid() {
		return mtid;
	}

	public void setMtid(String mtid) {
		this.mtid = mtid;
	}

	public String getMttype() {
		return mttype;
	}

	public void setMttype(String mttype) {
		this.mttype = mttype;
	}

	public String getMtstate() {
		return mtstate;
	}

	public void setMtstate(String mtstate) {
		this.mtstate = mtstate;
	}
	public Majorcosttype(){
		
	}
	public Majorcosttype(String mt_uuid, String mtid, String mttype, String mtstate) {
		super();
		this.mt_uuid = mt_uuid;
		this.mtid = mtid;
		this.mttype = mttype;
		this.mtstate = mtstate;
	}

	@Override
	public String toString() {
		return "Majorcosttype [mt_uuid=" + mt_uuid + ", mtid=" + mtid + ", mttype=" + mttype + ", mtstate=" + mtstate
				+ "]";
	}
	
}
