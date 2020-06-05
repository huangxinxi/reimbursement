package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserDao;
import model.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public boolean save(User u) {
		// TODO �Զ���ɵķ������
		try{
			u.setUstate("A");
			this.getHibernateTemplate().save(u);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(User u) {
		// TODO �Զ���ɵķ������
		try{
			this.getHibernateTemplate().delete(u);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User u) {
		// TODO �Զ���ɵķ������
		try{
			this.getHibernateTemplate().update(u);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<User> findAll() {
		// TODO �Զ���ɵķ������
		try{
			String hql = "from User";
			@SuppressWarnings("unchecked")
			ArrayList<User> alist = (ArrayList<User>) this.getHibernateTemplate().find(hql);
			return alist;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByID(String u_uuid) {
		// TODO �Զ���ɵķ������
		try{
			String hql = "from User where u_uuid = ?";
			@SuppressWarnings("unchecked")
			ArrayList<User> alist = (ArrayList<User>) this.getHibernateTemplate().find(hql, u_uuid);
			User u = null;
			u = alist.get(0);
			return u;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public User checklogin(User user) {
		// TODO �Զ���ɵķ������
		try{
			User u = null;
			String hql = "from User where uname = ? and upassword = ?";
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query qry = session.createQuery(hql);
			qry.setString(0,user.getUname());
			qry.setString(1,user.getUpassword());
			u = (User)qry.uniqueResult();
			return u;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	
	
}
