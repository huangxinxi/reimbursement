package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.SpringUtil;
import dao.MajorcostDao;
import dao.ProjectDao;
import dao.UserDao;
import model.Majorcost;
import model.Majorcosttype;
import model.Project;
import model.User;

public class MajorcostDaoImpl extends HibernateDaoSupport implements MajorcostDao{

	@Override
	public boolean save(Majorcost mc) {
		try{
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(mc);
			tx.commit();
			return true;
		}catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
	}

	@Override
	public boolean delete(Majorcost mc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Majorcost mc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Majorcost> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Majorcost> findByPUID(String puid) {
		try{
			String hql = "from Majorcost where project = ? and mstate='A'";
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query qry = session.createQuery(hql);
			qry.setString(0,puid);
			ArrayList<Majorcost> result = (ArrayList<Majorcost>)qry.list();
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteByPUID(String puid) {
		try{
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			String hql = "update Majorcost set mstate='d' where project=?";
			Query qry = session.createQuery(hql);
			qry.setString(0,puid);
			qry.executeUpdate();
			tx.commit();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	/**王家南
	 * 根据uuid查找
	 * @param puid
	 * @return
	 */
	public Majorcost findByUUID(String uuid) {
		try{
			Majorcost m =this.getHibernateTemplate().get(Majorcost.class, uuid);
			return m;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
