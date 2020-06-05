package action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;


import model.Majorcosttype;
import model.Subcosttype;
import service.MajorcosttypeService;
import service.SubcosttypeService;

/**
 * Url事务处理
 * 
 * @author 王家南
 */
public class SubcosttypeAction extends SuperAction implements ModelDriven<Subcosttype> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Subcosttype subcosttype;
	private SubcosttypeService subcosttypeService;
	private MajorcosttypeService majorcosttypeService;//
	private List<Subcosttype> subcosttypes = new ArrayList<Subcosttype>();// jsp页面取值
	private List<Majorcosttype> majorcosttypes=new java.util.ArrayList<Majorcosttype>();
	private String[] checkbox_child;// 页面的checkbox值
	
	public Subcosttype getSubcosttype() {
		return subcosttype;
	}

	public void setSubcosttype(Subcosttype subcosttype) {
		this.subcosttype = subcosttype;
	}

	public SubcosttypeService getSubcosttypeService() {
		return subcosttypeService;
	}

	public void setSubcosttypeService(SubcosttypeService subcosttypeService) {
		this.subcosttypeService = subcosttypeService;
	}

	public MajorcosttypeService getMajorcosttypeService() {
		return majorcosttypeService;
	}

	public void setMajorcosttypeService(MajorcosttypeService majorcosttypeService) {
		this.majorcosttypeService = majorcosttypeService;
	}

	public List<Subcosttype> getSubcosttypes() {
		return subcosttypes;
	}

	public void setSubcosttypes(List<Subcosttype> subcosttypes) {
		this.subcosttypes = subcosttypes;
	}

	public List<Majorcosttype> getMajorcosttypes() {
		return majorcosttypes;
	}

	public void setMajorcosttypes(List<Majorcosttype> majorcosttypes) {
		this.majorcosttypes = majorcosttypes;
	}

	public String[] getCheckbox_child() {
		return checkbox_child;
	}

	public void setCheckbox_child(String[] checkbox_child) {
		this.checkbox_child = checkbox_child;
	}

	/**
	 * 添加次费用类型时寻找主费用类型
	 * 
	 * @return
	 */
	public String findAllMajorcosttype() {
		this.majorcosttypes=this.majorcosttypeService.findAll();	
		return "findAllMajorcosttype_sub_success";
	}

	/**
	 * 保存次费用类型
	 */
	/*
	
	System.out.println("name"+name);
	String description=request.getParameter("description");
	String permissionIDs=result[0];
	for(String permissionID: permissionIDs.split(",")){
		Permission p=new Permission(permissionID);
		this.permissions.add(p);
	}
	for(Permission p:this.permissions){
		System.out.println("piD:"+p.getId());
	}
	this.role.setName(name);
	this.role.setDescription(description);
	this.role.setPermissions(new HashSet<Permission>(this.permissions));
	if(this.roleService.saveRole(role)){
		response.setContentType("application/json");
		return "addRole_success";
	}else{
		return "addRole_fauile";
	}*/
	public String addSubcosttype() {
		String mainCosttype =request.getParameter("mainCosttype");
		String stid=request.getParameter("stid");
		String sttype=request.getParameter("sttype");
		subcosttype.setStsid(stid);
		subcosttype.setSttype(sttype);
		subcosttype.setMajorcosttype(this.majorcosttypeService.findByID(mainCosttype));
		if (this.subcosttypeService.save(subcosttype)) {
			return "addSubcosttype_success";
		} else {
			return "addSubcosttype_fauile";
		}
	}

	/**
	 * 修改次费用类型
	 */
	public String updateSubcosttype() {
		String st_uuid=request.getParameter("st_uuid");
		String mainCosttype =request.getParameter("mainCosttype");
		String stid=request.getParameter("stid");
		String sttype=request.getParameter("sttype");
		subcosttype.setSt_uuid(st_uuid);
		subcosttype.setStsid(stid);
		subcosttype.setSttype(sttype);
		subcosttype.setMajorcosttype(this.majorcosttypeService.findByID(mainCosttype));
		if (this.subcosttypeService.update(subcosttype)) {
			return "updateSubcosttype_success";
		} else {
			return "updateSubcosttype_fauile";
		}
	}

	/**
	 * 删除次费用类型
	 */
	public String deleteSubcosttype() {
		if (this.subcosttypeService.deleteByID(subcosttype.getSt_uuid())) {
			return "deleteSubcosttype_success";
		} else {
			return "deleteSubcosttype_fauile";
		}
	}

	/**
	 * 批量删除次费用类型
	 * 
	 * @return
	 */
	public String deleteSelectonSubcosttype() {
		boolean statue = true;
		for (String id : this.checkbox_child) {
			if (this.subcosttypeService.deleteByID(id)) {
				statue = true;
			} else {
				statue = false;
				break;
			}
		}
		if (statue) {
			return "deleteSelectonSubcosttype_success";
		} else {
			return "deleteSelectonSubcosttype_fauile";
		}
	}

	/**
	 * 查询子类费用类型
	 */
	public String findAllSubcosttype() {
		subcosttypes = this.subcosttypeService.findAll();
		for (Subcosttype s : subcosttypes) {
			s.setMajorcosttype(this.majorcosttypeService.findByID(s.getMajorcosttype().getMt_uuid()));			
			
		}
		return "findAllSubcosttype_success";

	}

	/**
	 * 根据id查询车系
	 */
	public String findSubcosttype() {
		subcosttype = this.subcosttypeService.findByID(subcosttype.getSt_uuid());
		majorcosttypes=this.majorcosttypeService.findAll();
		if (subcosttype != null) {
			return "findSubcosttype_notnull";
		} else {
			return "findSubcosttype_null";
		}
	}
	
	/**
	 * 根据传入的值刷新table
	 * @return
	 */
	public String refreshSubcosttypeTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String select=request.getParameter("select");
		String checkbox=request.getParameter("checkbox");
		this.subcosttypes=this.subcosttypeService.refreshSubcosttypeTable(select,checkbox);
		request.setAttribute("subcosttypes", subcosttypes);
		return "refreshSubcosttypesTable_success";
	}
	public Subcosttype getModel() {
		// TODO Auto-generated method stub
		return this.subcosttype;
	}

}
