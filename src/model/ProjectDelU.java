package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectDelU {
	private String p_uuid;
	private int pid;
	private String p_name;
	
	private String ptype;
	private String pfield;
	private String psource;
	private String puser;
	private int pcostidp;
	private int pcostpub;
	private String pbegintime;
	private String pendtime;
	private String pstate;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public ProjectDelU(){}
	
	public ProjectDelU(Project p)
	{
		this.p_uuid = p.getP_uuid();
		this.pid = p.getPid();
		this.p_name = p.getP_name();
		this.ptype = p.getPtype();
		this.pfield = p.getPfield();
		this.psource = p.getPsource();
		this.pcostidp = p.getPcostidp();
		this.pcostpub = p.getPcostpub();
		this.pbegintime =sdf.format(p.getPbegintime());
		this.pendtime = sdf.format(p.getPendtime());
		this.pstate = p.getPstate();
		if(p.getPresuser()!=null)
			this.puser = p.getPresuser().getUname();
	}

	
	
	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}

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

	public String getPbegintime() {
		return pbegintime;
	}

	public void setPbegintime(String pbegintime) {
		this.pbegintime = pbegintime;
	}

	public String getPendtime() {
		return pendtime;
	}

	public void setPendtime(String pendtime) {
		this.pendtime = pendtime;
	}

	public String getPstate() {
		return pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate;
	}
	
	
	
	
}
