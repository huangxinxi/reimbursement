package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Usertype;
import service.impl.UsertypeServiceImpl;
import util.SpringUtil;

public class UsertypeAction extends ActionSupport{
	private UsertypeServiceImpl usertypeServiceImpl = (UsertypeServiceImpl) SpringUtil.getBean("UsertypeServiceImpl");
	private Usertype usertype = (Usertype) SpringUtil.getBean("Usertype");
	private String id;   //ͨ��id��ɾ��
	public UsertypeServiceImpl getUsertypeServiceImpl() {
		return usertypeServiceImpl;
	}
	public void setUsertypeServiceImpl(UsertypeServiceImpl usertypeServiceImpl) {
		this.usertypeServiceImpl = usertypeServiceImpl;
	}
	public Usertype getUsertype() {
		return usertype;
	}
	public void setUsertype(Usertype usertype) {
		this.usertype = usertype;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * ����û�����
	 * @return
	 */
	public String addUsertype(){
		usertypeServiceImpl.save(usertype);
		List<Usertype> utlist = usertypeServiceImpl.findAll();
		ActionContext.getContext().getSession().put("allusertype",utlist);
		return "addUsertype_success";
	}
	
	public String deleteUsertype(){
		Usertype usertype = new Usertype();
		usertype.setUt_uuid(id);
		usertypeServiceImpl.delete(usertype);
		List<Usertype> utlist = usertypeServiceImpl.findAll();
		ActionContext.getContext().getSession().put("allusertype",utlist);
		return "deleteUsertype_success";
	}
	/**
	 * ���������û�����
	 * @return
	 */
	public String findAllUsertype(){
		List<Usertype> utlist = usertypeServiceImpl.findAll();
		ActionContext.getContext().getSession().put("allusertype",utlist);
		return "findAllUsertype_success";
	}
	/**
	 * �û������б�(ע��)
	 * @return
	 */
	public String Usertypelist(){
		List<Usertype> utlist = usertypeServiceImpl.findAll();
		ActionContext.getContext().getSession().put("allusertype",utlist);
		return "Usertypelist_success";
	}
	/**
	 * �û������б���¼��
	 * @return
	 */
	public String Usertypelist2(){
		List<Usertype> utlist = usertypeServiceImpl.findAll();
		ActionContext.getContext().getSession().put("allusertype",utlist);
		return "Usertypelist_success2";
	}
	/**
	 * �û������б������û���
	 * @return
	 */
	public String Usertypelist3(){
		List<Usertype> utlist = usertypeServiceImpl.findAll();
		ActionContext.getContext().getSession().put("allusertype",utlist);
		return "Usertypelist_success3";
	}
}
