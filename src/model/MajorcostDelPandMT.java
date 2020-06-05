package model;

public class MajorcostDelPandMT {
	private String m_uuid;//�����������
	private String project;//��Ŀ
	private String mt_uuid;
	private String majorcosttype;//����������
	private int mcost;//������
	private String mstate;//������״̬
	
	public MajorcostDelPandMT()
	{}
	public MajorcostDelPandMT(Majorcost m)
	{
		this.m_uuid = m.getM_uuid();
		this.project = m.getProject().getP_name();
		this.mt_uuid = m.getMajorcosttype().getMt_uuid();
		this.majorcosttype = m.getMajorcosttype().getMttype();
		this.mcost = m.getMcost();
		this.mstate = m.getMstate();
	}
	
	
	
	public String getMt_uuid() {
		return mt_uuid;
	}
	public void setMt_uuid(String mt_uuid) {
		this.mt_uuid = mt_uuid;
	}
	public String getM_uuid() {
		return m_uuid;
	}
	public void setM_uuid(String m_uuid) {
		this.m_uuid = m_uuid;
	}
	
	
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getMajorcosttype() {
		return majorcosttype;
	}
	public void setMajorcosttype(String majorcosttype) {
		this.majorcosttype = majorcosttype;
	}
	public int getMcost() {
		return mcost;
	}
	public void setMcost(int mcost) {
		this.mcost = mcost;
	}
	public String getMstate() {
		return mstate;
	}
	public void setMstate(String mstate) {
		this.mstate = mstate;
	}
	
}
