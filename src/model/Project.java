package model;

import java.util.Date;

/**
 * @author ������
 *��Ŀ
 *bean
 */
public class Project {
	public static final String KEY = "P_uuid";
	public static String[] FIELD={"Pstate","Pid","P_name","Ptype"};
	private String p_uuid;//��Ŀ����
	private int pid;//��Ŀ���
	private String p_name;//��Ŀ���
	private User presuser;//��Ŀ������
	private String ptype;//��Ŀ����
	private String pfield;//��Ŀ����
	private String psource;//��Ŀ��Դ
	private int pcostidp;//��Ŀ�Գ����
	private int pcostpub;//��Ŀ���ѷ���
	private Date pbegintime;//��Ŀ��ʼʱ��
	private Date pendtime;//��Ŀ����ʱ��
	private String pstate;//��Ŀ״̬
	public String getP_uuid() {
		return p_uuid;
	}
	public void setP_uuid(String p_uuid) {
		this.p_uuid = p_uuid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public User getPresuser() {
		return presuser;
	}
	public void setPresuser(User presuser) {
		this.presuser = presuser;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getPfield() {
		return pfield;
	}
	public void setPfield(String pfield) {
		this.pfield = pfield;
	}
	public String getPsource() {
		return psource;
	}
	public void setPsource(String psource) {
		this.psource = psource;
	}
	public int getPcostidp() {
		return pcostidp;
	}
	public void setPcostidp(int pcostidp) {
		this.pcostidp = pcostidp;
	}
	public int getPcostpub() {
		return pcostpub;
	}
	public void setPcostpub(int pcostpub) {
		this.pcostpub = pcostpub;
	}
	public Date getPbegintime() {
		return pbegintime;
	}
	public void setPbegintime(Date pbegintime) {
		this.pbegintime = pbegintime;
	}
	public Date getPendtime() {
		return pendtime;
	}
	public void setPendtime(Date pendtime) {
		this.pendtime = pendtime;
	}
	public String getPstate() {
		return pstate;
	}
	public void setPstate(String pstate) {
		this.pstate = pstate;
	}
	public Project(){
		
	}
	public Project(String p_uuid, int pid, String p_name, User presuser, String ptype, String pfield, String psource,
			int pcostidp, int pcostpub, Date pbegintime, Date pendtime, String pstate) {
		super();
		this.p_uuid = p_uuid;
		this.pid = pid;
		this.p_name = p_name;
		this.presuser = presuser;
		this.ptype = ptype;
		this.pfield = pfield;
		this.psource = psource;
		this.pcostidp = pcostidp;
		this.pcostpub = pcostpub;
		this.pbegintime = pbegintime;
		this.pendtime = pendtime;
		this.pstate = pstate;
	}
	@Override
	public String toString() {
		return "project [p_uuid=" + p_uuid + ", pid=" + pid + ", p_name=" + p_name + ", presuser=" + presuser
				+ ", ptype=" + ptype + ", pfield=" + pfield + ", psource=" + psource + ", pcostidp=" + pcostidp
				+ ", pcostpub=" + pcostpub + ", pbegintime=" + pbegintime + ", pendtime=" + pendtime + ", pstate="
				+ pstate + "]";
	}
	
}
