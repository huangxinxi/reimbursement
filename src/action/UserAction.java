package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Majorcosttype;
import model.User;
import model.Usertype;
import service.impl.UserServiceImpl;
import service.impl.UsertypeServiceImpl;
import util.SpringUtil;

public class UserAction extends ActionSupport{
	private UserServiceImpl userServiceImpl= (UserServiceImpl) SpringUtil.getBean("UserServiceImpl");
	private User user = (User) SpringUtil.getBean("User");
	private UsertypeServiceImpl usertypeServiceImpl = (UsertypeServiceImpl) SpringUtil.getBean("UsertypeServiceImpl");
	private Usertype usertype = (Usertype) SpringUtil.getBean("Usertype");
	private String id;   //ͨ��id��ɾ��
	private String uid;   //ͨ��uid����ѯ
	private List<User> users=new java.util.ArrayList<User>();
	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}
	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * ����û�(ע��)
	 * @return
	 */
	public String addUser(){
		userServiceImpl.save(user) ;
		return "register_success";
	}
	/**
	 * ����û�����̨��
	 * @return
	 */
	public String addUser2(){
		userServiceImpl.save(user) ;
		List<User> ulist = userServiceImpl.findAll();
		ActionContext.getContext().getSession().put("alluser",ulist);
		return "addUser2_success";
	}
	/**
	 * ɾ���û�
	 * @return
	 */
	public String deleteUser(){
		User user = new User();
		user.setU_uuid(id);
		userServiceImpl.delete(user);
		List<User> ulist = userServiceImpl.findAll();
		ActionContext.getContext().getSession().put("alluser",ulist);
		return "deleteUser_success";
	}
	/**
	 * �޸��û�
	 * @return
	 */
	public String updateUser(){
		userServiceImpl.update(user);
		List<User> ulist = userServiceImpl.findAll();
		ActionContext.getContext().getSession().put("alluser",ulist);
		return "updateUser_success";
	}
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public String findAllUser(){
		List<User> ulist = userServiceImpl.findAll();
		ActionContext.getContext().getSession().put("alluser",ulist);
		return "findAllUser_success";
	}
	/**
	 * ���ID�����û�
	 * @return
	 */
	public String finduserbyid(){
		/*System.out.println("1111111111");*/
		User u = userServiceImpl.findByID(uid);
		ActionContext.getContext().getSession().put("user", u);
		List<Usertype> utlist = usertypeServiceImpl.findAll();
		ActionContext.getContext().getSession().put("allusertype",utlist);
		return "finduserbyid_success";
	}
	/**
	 * ��¼��֤
	 * @return
	 */
	public String checklogin(){
		User user = userServiceImpl.checklogin(this.user);
		if(user!=null&&user.getUsertype().getUt_uuid().equals("8ac2a6435d3edbd7015d3edd33960003")) 
		{
			ActionContext.getContext().getSession().put("user",user);
			return "login_success_a";
		}
		else if(user!=null&&user.getUsertype().getUt_uuid().equals("1")){
			ActionContext.getContext().getSession().put("user",user);
			return "login_success_t";
		}
		else  
			return "login_failure";
	}
	/**
	 * ��ݴ����ֵˢ��table
	 * @return
	 */
	public String refreshUserTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String select=request.getParameter("select");
		String checkbox=request.getParameter("checkbox");
		users=userServiceImpl.refreshUserTable(select, checkbox);
		request.setAttribute("users", users);
		return "refreshUserTable_success";
	}
	
}
