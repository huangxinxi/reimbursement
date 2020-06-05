package model;

import java.util.Date;
import java.util.UUID;

/**
 * @author 锟斤拷锟斤拷锟斤拷
 *锟斤拷锟斤拷锟斤拷锟斤拷
 *javabean
 */
public class Reimbursement {
	public static final String KEY = "R_uuid";
	public static String[] FIELD={"Rstate","Rid","Rcostall","Rdate","Ruser_T","Rstate_T"};//页锟斤拷展示state为锟斤拷锟�
	public static String[] FIELD2={"Rstate","Rid","Rcostall","Rdate"};//页面展示state为填充
	private String r_uuid;//报销申请主键
	private int rid;//报销申请编号
	private Date rdate;//报销申请时间
	private int rcostall;//报销申请合计费用
	private String rstate;//报销申请状态
	private Project project;//所属项目
	private User ruser;// 审核人
	
	public String getRuser_T() {//转换审核人
		if(this.rstate.equals("W")){
			return "无";
		}else if(this.rstate.equals("N")){
			return "财务人员";
		}else{
			return "财务人员";
		}
			
	}
	public String getRstate_T() {//转换状态
		if(this.rstate.equals("W")){
			return "待审核";
		}else if(this.rstate.equals("N")){
			return "审核未通过";
		}else{
			return "已审核通过";
		}
	}
	
	public String getR_uuid() {
		return r_uuid;
	}
	public void setR_uuid(String r_uuid) {
		this.r_uuid = r_uuid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public int getRcostall() {
		return rcostall;
	}
	public void setRcostall(int rcostall) {
		this.rcostall = rcostall;
	}
	public String getRstate() {
		return rstate;
	}
	public void setRstate(String rstate) {
		this.rstate = rstate;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public User getRuser() {
		return ruser;
	}
	public void setRuser(User ruser) {
		this.ruser = ruser;
	}
	public Reimbursement(){
		
	}
	public Reimbursement(String r_uuid, int rid, Date rdate, int rcostall, String rstate, Project project, User ruser) {
		super();
		this.r_uuid = r_uuid;
		this.rid = rid;
		this.rdate = rdate;
		this.rcostall = rcostall;
		this.rstate = rstate;
		this.project = project;
		this.ruser = ruser;
	}
	@Override
	public String toString() {
		return "Reimbursement [r_uuid=" + r_uuid + ", rid=" + rid + ", rdate=" + rdate + ", rcostall=" + rcostall
				+ ", rstate=" + rstate + ", project=" + project + ", ruser=" + ruser + "]";
	}
	
	
	
}
