package dao.impl;

import java.util.ArrayList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dao.UsertypeDao;
import model.Usertype;

public class UsertypeDaoImpl extends HibernateDaoSupport implements UsertypeDao{

	@Override
	public boolean save(Usertype ut) {
		// TODO �Զ����ɵķ������
		try{
			this.getHibernateTemplate().save(ut);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Usertype ut) {
		// TODO �Զ����ɵķ������
		try{
			this.getHibernateTemplate().delete(ut);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Usertype ut) {
		// TODO �Զ����ɵķ������
		try{
			this.getHibernateTemplate().update(ut);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Usertype> findAll() {
		// TODO �Զ����ɵķ������
		try{
			String hql = "from Usertype";
			@SuppressWarnings("unchecked")
			ArrayList<Usertype> alist = (ArrayList<Usertype>) this.getHibernateTemplate().find(hql);
			return alist;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usertype findByID(String ut_uuid) {
		// TODO �Զ����ɵķ������
		try{
			String hql = "from Usertype where ut_uuid = ?";
			ArrayList<Usertype> alist = (ArrayList<Usertype>) this.getHibernateTemplate().find(hql,ut_uuid);
			return alist.get(0);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
