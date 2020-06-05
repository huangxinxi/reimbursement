 package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import model.Majorcosttype;
import service.MajorcosttypeService;

/**
 * @author ���� :������
 * @version ����ʱ�䣺2017��7��7�� ����10:16:22 ��˵��
 */
public class MajorcosttypeAction extends SuperAction implements ModelDriven<Majorcosttype> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Majorcosttype majorcosttype;
	private MajorcosttypeService majorcosttypeService;
	private List<Majorcosttype> majorcosttypes=new java.util.ArrayList<Majorcosttype>();
	private String[] checkbox_child;// ҳ���checkboxֵ

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
	 * �����Ҫ������
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
	 * ����UUIDɾ����Ҫ������
	 */
	public String deleteMajorcosttype() {
		System.out.println("deleteǰ" + majorcosttype.getMt_uuid());
		if (this.majorcosttypeService.delete(majorcosttype)) {
			return "deleteMajorcosttype_success";
		} else {
			return "deleteMajorcosttype_fauile";
		}
	}

	/**
	 * ����ɾ����Ҫ������
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
	 * ��ѯ������Ҫ������
	 */
	public String findAllMajorcosttype() {
		majorcosttypes = this.majorcosttypeService.findAll();
		for (Majorcosttype m : majorcosttypes) {
			System.out.println(m.getMt_uuid() + m.getMttype() + m.getMtid());
		}
		return "findAllMajorcosttype_success";

	}
	
	/**
	 * ����uuid��ѯ��Ҫ������
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
	 * �޸Ĳ�ѯ��Ҫ������
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
	 * ���ݴ����ֵˢ��table
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
