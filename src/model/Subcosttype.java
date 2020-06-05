package model;

/**
 * @author 王家南
 *次费用类型
 *javabean
 */
public class Subcosttype {
	private String st_uuid;//次费用类型主键
	private Majorcosttype majorcosttype;//主费用类型
	private String stsid;//次费用类型编号
	private String sttype;//次费用类型名
	private String state;//次费用类型状态
	public String getSt_uuid() {
		return st_uuid;
	}
	public void setSt_uuid(String st_uuid) {
		this.st_uuid = st_uuid;
	}
	public Majorcosttype getMajorcosttype() {
		return majorcosttype;
	}
	public void setMajorcosttype(Majorcosttype majorcosttype) {
		this.majorcosttype = majorcosttype;
	}
	public String getStsid() {
		return stsid;
	}
	public void setStsid(String stsid) {
		this.stsid = stsid;
	}
	public String getSttype() {
		return sttype;
	}
	public void setSttype(String sttype) {
		this.sttype = sttype;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Subcosttype(){
		
	}
	public Subcosttype(String st_uuid, Majorcosttype majorcosttype, String stsid, String sttype, String state) {
		super();
		this.st_uuid = st_uuid;
		this.majorcosttype = majorcosttype;
		this.stsid = stsid;
		this.sttype = sttype;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Subcosttype [st_uuid=" + st_uuid + ", majorcosttype=" + majorcosttype + ", stsid=" + stsid + ", sttype="
				+ sttype + ", state=" + state + "]";
	}
	
}
