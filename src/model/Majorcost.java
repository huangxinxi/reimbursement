package model;

/**
 * @author ������
 *�������
 *javaBean
 */
public class Majorcost {
	public static final String KEY = "M_uuid";
	public static String[] FIELD={"Mstate","Majorcosttype_T","Mcost"};
	private String m_uuid;//�����������
	private Project project;//��Ŀ
	private Majorcosttype majorcosttype;//����������
	private int mcost;//������
	private String mstate;//������
	public String getMajorcosttype_T() {
		return majorcosttype.getMttype();
	}
		public String getM_uuid() {
		return m_uuid;
	}
	public void setM_uuid(String m_uuid) {
		this.m_uuid = m_uuid;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Majorcosttype getMajorcosttype() {
		return majorcosttype;
	}
	public void setMajorcosttype(Majorcosttype majorcosttype) {
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
	public Majorcost(){
	}
	public Majorcost(String m_uuid, Project project, Majorcosttype majorcosttype, int mcost, String mstate) {
		super();
		this.m_uuid = m_uuid;
		this.project = project;
		this.majorcosttype = majorcosttype;
		this.mcost = mcost;
		this.mstate = mstate;
	}
	@Override
	public String toString() {
		return "Majorcost [m_uuid=" + m_uuid + ", project=" + project + ", majorcosttype=" + majorcosttype + ", mcost="
				+ mcost + ", mstate=" + mstate + "]";
	}
	
}
