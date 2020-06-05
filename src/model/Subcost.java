package model;

/**
 * @author ������
 *�������
 *javabean
 */
public class Subcost {
	public static final String KEY = "S_uuid";
	public static String[] FIELD={"Sstate","Subcosttype_s","Scost"};//ҳ��չʾstateΪ���
	
	private String s_uuid;//�����������
	private Reimbursement reimbursement;// ��������
	private Subcosttype subcosttype;//�����������
	private int scost;//�������
	private String sstate;//�������״̬
	public String getSubcosttype_s(){
		return subcosttype.getSttype();
	}
	public String getS_uuid() {
		return s_uuid;
	}
	public void setS_uuid(String s_uuid) {
		this.s_uuid = s_uuid;
	}
	public Reimbursement getReimbursement() {
		return reimbursement;
	}
	public void setReimbursement(Reimbursement reimbursement) {
		this.reimbursement = reimbursement;
	}
	public Subcosttype getSubcosttype() {
		return subcosttype;
	}
	public void setSubcosttype(Subcosttype subcosttype) {
		this.subcosttype = subcosttype;
	}
	public int getScost() {
		return scost;
	}
	public void setScost(int scost) {
		this.scost = scost;
	}
	public String getSstate() {
		return sstate;
	}
	public void setSstate(String sstate) {
		this.sstate = sstate;
	}
	public Subcost(){
		
	}
	public Subcost(String s_uuid, Reimbursement reimbursement, Subcosttype subcosttype, int scost, String sstate) {
		super();
		this.s_uuid = s_uuid;
		this.reimbursement = reimbursement;
		this.subcosttype = subcosttype;
		this.scost = scost;
		this.sstate = sstate;
	}
	@Override
	public String toString() {
		return "Subcost [s_uuid=" + s_uuid + ", reimbursement=" + reimbursement + ", subcosttype=" + subcosttype
				+ ", scost=" + scost + ", sstate=" + sstate + "]";
	}
	
}
