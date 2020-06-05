package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dao.QueryTableDAO;
import dao.impl.UserDaoImpl;
import model.Majorcosttype;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	private UserDaoImpl UserDaoImpl;
	private QueryTableDAO queryTableDAO;

	public UserDaoImpl getUserDaoImpl() {
		return UserDaoImpl;
	}

	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		UserDaoImpl = userDaoImpl;
	}

	public QueryTableDAO getQueryTableDAO() {
		return queryTableDAO;
	}

	public void setQueryTableDAO(QueryTableDAO queryTableDAO) {
		this.queryTableDAO = queryTableDAO;
	}

	@Override
	public boolean save(User u) {
		// TODO �Զ���ɵķ������
		return UserDaoImpl.save(u);
	}

	@Override
	public boolean delete(User u) {
		// TODO �Զ���ɵķ������
		return UserDaoImpl.delete(u);
	}

	@Override
	public boolean update(User u) {
		// TODO �Զ���ɵķ������
		return UserDaoImpl.update(u);
	}

	@Override
	public ArrayList<User> findAll() {
		// TODO �Զ���ɵķ������
		return UserDaoImpl.findAll();
	}

	@Override
	public User findByID(String u_uuid) {
		// TODO �Զ���ɵķ������
		return UserDaoImpl.findByID(u_uuid);
	}

	@Override
	public User checklogin(User user) {
		// TODO �Զ���ɵķ������
		return UserDaoImpl.checklogin(user);
	}


	@Override
	public List<User> refreshUserTable(String select, String checkbox) {
		// TODO �Զ���ɵķ������
		Map<String,Object> varables=new HashMap<String,Object>();
		if(checkbox.equals("all")){		
			List<User> list=(List<User>) UserDaoImpl.findByID(select);	
			return list;
		}else{
			varables.put(checkbox,select);
			List<User> list=(List<User>)queryTableDAO.queryResultList(User.class, varables);	
			//Iterator<User> it = list.iterator();
			//list=new java.util.ArrayList<>();
			/*while(it.hasNext()){
				User x = it.next();
			    if(x.getUstate().equals("d")){
			        it.remove();
			    }else{
			    	list.add(x);
			    }
			}		*/
			return list;
		}
	}

}
