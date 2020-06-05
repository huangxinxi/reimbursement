package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ProjectDao;
import dao.UserDao;
import model.Majorcosttype;
import model.Project;
import model.User;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao{

	@Override
	public boolean save(Project p) {
		// TODO Auto-generated method stub
		try{
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
	/*		if(p.getP_uuid() == null)
				p.setP_uuid(p_uuid);*/
			session.save(p);
			tx.commit();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean delete(Project p) {
		try{
			String hql = "update Project set pstate='D' where p_uuid=?";
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query qry = session.createQuery(hql);
			qry.setString(0,p.getP_uuid());
			qry.executeUpdate();
			tx.commit();
		//	System.out.println("111111111111111111111111111111111111111111111111111111111111111111111");
			hql = "update Majorcost set mstate='D' where project=?";
			qry = session.createQuery(hql);
			qry.setString(0,p.getP_uuid());
			qry.executeUpdate();
			tx.commit();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean update(Project p) {
		try{
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			String hql = "update Project set p_name=?,ptype=?,pfield=?,"
					+ "psource=?,pcostidp=?,pcostpub=?,pbegintime=?,pendtime=? where p_uuid=?";
			Transaction tx = session.beginTransaction();
			Query qry = session.createQuery(hql);
			qry.setString(0,p.getP_name());
			qry.setString(1,p.getPtype());
			qry.setString(2,p.getPfield());
			qry.setString(3,p.getPsource());
			qry.setInteger(4,p.getPcostidp());
			qry.setInteger(5,p.getPcostpub());
			qry.setDate(6,p.getPbegintime());
			qry.setDate(7,p.getPendtime());
			qry.setString(8,p.getP_uuid());
			qry.executeUpdate();
			tx.commit();
			return true;
		}catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
	}

	@Override
	public ArrayList<Project> findAll(String u_uuid) {
		try{
			String hql = "from Project where pstate!='D' and presuser = ?";
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query qry = session.createQuery(hql);
			qry.setString(0, u_uuid);
			ArrayList<Project> result = (ArrayList<Project>)qry.list();
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Project> loadAllWait() {
		try{
			String hql = "from Project where pstate='W'";
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query qry = session.createQuery(hql);
			ArrayList<Project> result = (ArrayList<Project>)qry.list();
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public Project findByID(int id) {
		String hql = "from Project where pid=?";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query qry = session.createQuery(hql);
		qry.setInteger(0,id);
		Project result = (Project)qry.uniqueResult();
		return result;
	}

	@Override
	public ArrayList<Majorcosttype> loadMajorCostType() {
		String hql = "from Majorcosttype where mtstate='A'";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query qry = session.createQuery(hql);
		ArrayList<Majorcosttype> result = (ArrayList<Majorcosttype>)qry.list();
		return result;
	}

	@Override
	public boolean pass(Project p) {
		try{
			String hql = "update Project set pstate='A' where p_uuid=?";
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query qry = session.createQuery(hql);
			qry.setString(0,p.getP_uuid());
			qry.executeUpdate();
			tx.commit();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean reject(Project p) {
		try{
			String hql = "update Project set pstate='N' where p_uuid=?";
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query qry = session.createQuery(hql);
			qry.setString(0,p.getP_uuid());
			qry.executeUpdate();
			tx.commit();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public ArrayList<Project> loadReviewed() {
		try{
			String hql = "from Project where pstate ='A' or pstate ='N'";
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query qry = session.createQuery(hql);
			ArrayList<Project> result = (ArrayList<Project>)qry.list();
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}


	public Project findByUUID(String uuid) {
		String hql = "from Project where p_uuid=?";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query qry = session.createQuery(hql);
		qry.setString(0,uuid);
		Project result = (Project)qry.uniqueResult();
		return result;
	}
}
