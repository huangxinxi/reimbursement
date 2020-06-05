 package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import model.Majorcosttype;
import service.MajorcosttypeService;

/**
 * @author 作者 :王家南
 * @version 创建时间：2017年7月7日 上午10:16:22 类说明
 */
public class MajorcosttypeAction extends SuperAction implements ModelDriven<Majorcosttype> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Majorcosttype majorcosttype;
	private MajorcosttypeService majorcosttypeService;
	private List<Majorcosttype> majorcosttypes=new java.util.ArrayList<Majorcosttype>();
	private String[] checkbox_child;// 页面的checkbox值

	public String[] getCheckbox_child() {
		return checkbox_child;
	}

	public void setCheckbox_child(String[] checkbox_child) {
		this.checkbox_child = checkbox_child;
	}

	public void setMajorcosttype(Majorcosttype majorcosttype) {
		this.majorcosttype = majorcosttype;
	}

	public void setMajorcosttypeService(MajorcosttypeService majorcosttypeService) {
		this.majorcosttypeService = majorcosttypeService;
	}

	public List<Majorcosttype> getMajorcosttypes() {
		return majorcosttypes;
	}

	public void setMajorcosttypes(List<Majorcosttype> majorcosttypes) {
		this.majorcosttypes = majorcosttypes;
	}

	public Majorcosttype getMajorcosttype() {
		return majorcosttype;
	}

	/**
	 * 添加主要费用类
	 * 
	 * @return
	 */
	public String addMajorcosttype() {
		if (this.majorcosttypeService.save(majorcosttype)) {
			System.out.println(majorcosttype.getMttype());
			return "addMajorcosttype_success";
		} else {
			return "addMajorcosttype_fauile";
		}
	}

	/**
	 * 根据UUID删除主要费用类
	 */
	public String deleteMajorcosttype() {
		System.out.println("delete前" + majorcosttype.getMt_uuid());
		if (this.majorcosttypeService.delete(majorcosttype)) {
			return "deleteMajorcosttype_success";
		} else {
			return "deleteMajorcosttype_fauile";
		}
	}

	/**
	 * 批量删除主要费用类
	 * 
	 * @return
	 */
	public String deleteSelectonMajorcosttype() {
		boolean statue = true;
		for (String id : this.checkbox_child) {
			if (this.majorcosttypeService.deleteByID(id)) {
				statue = true;
			} else {
				statue = false;
				break;
			}
		}
		if (statue) {
			return "deleteMajorcosttype_success";
		} else {
			return "deleteMajorcosttype_fauile";
		}
	}

	/**
	 * 查询所有主要费用类
	 */
	public String findAllMajorcosttype() {
		majorcosttypes = this.majorcosttypeService.findAll();
		for (Majorcosttype m : majorcosttypes) {
			System.out.println(m.getMt_uuid() + m.getMttype() + m.getMtid());
		}
		return "findAllMajorcosttype_success";

	}
	
	/**
	 * 根据uuid查询主要费用类
	 */
	public String findMajorcosttype() {
		majorcosttype=this.majorcosttypeService.findByID(majorcosttype.getMt_uuid());
		if(majorcosttype!=null){
			System.out.println("find"+majorcosttype.getMt_uuid() + majorcosttype.getMttype() + majorcosttype.getMtid());
			return "findMajorcosttype_notnull";
		}else{
			return "findMajorcosttype_null";
		}
	}
	/**
	 * 修改查询主要费用类
	 */
	public String updateMajorcosttype(){
		
		if(this.majorcosttypeService.update(majorcosttype)){
			return "updateMajorcosttype_success";
		}else{
			return "updateMajorcosttype_fauile";
		}
	}
	public Majorcosttype getModel() {
		return this.majorcosttype;
	}
	/**
	 * 根据传入的值刷新table
	 * @return
	 */
	public String refreshMajorcosttypeTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String select=request.getParameter("select");
		String checkbox=request.getParameter("checkbox");
		this.majorcosttypes=this.majorcosttypeService.refreshMajorcosttypeTable(select,checkbox);
		request.setAttribute("majorcosttypes", majorcosttypes);
		return "refreshMajorcosttypeTable_success";
	}

}
