package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.xml.internal.stream.Entity;

import dao.ReimbursementDAO;
import model.Reimbursement;

/** 
* @author 作者 :王家南
* @version 创建时间：2017年7月10日 下午1:10:41 
* 类说明 
*/
public class ReimbursementDAOImpl extends HibernateDaoSupport implements ReimbursementDAO {


	public boolean save(Reimbursement T) {

		try {
			T.setRstate("W");
			this.getHibernateTemplate().save(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(Reimbursement T) {
		T.setRstate("D");
		try {
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteByID(String UUID) {
		Reimbursement T = this.findByID(UUID);
		T.setRstate("D");
		try {
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean update(Reimbursement T) {
		try {
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public List<Reimbursement> findAll() {
		String hql="";
		try{
			hql="from Reimbursement where Rstate!='D'";
			@SuppressWarnings("unchecked")
			List<Reimbursement> list=(List<Reimbursement>)this.getHibernateTemplate().find(hql);		
			
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	

	public List<Reimbursement> findAll_check() {
		String hql="";
		try{
			hql="from Reimbursement where Rstate!='D' and"
					+ " Rstate!='A' ";
			@SuppressWarnings("unchecked")
			List<Reimbursement> list=(List<Reimbursement>)this.getHibernateTemplate().find(hql);		
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public Reimbursement findByID(String UUID) {
		String hql="";
		try{
			hql="from Reimbursement where r_uuid=? and"
					+ "Rstate!='D'";
			Reimbursement Reimbursement=(Reimbursement)this.getHibernateTemplate().get(Reimbursement.class, UUID);
			return Reimbursement;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	public List<Reimbursement> findAllByPID(String UUID) {
		String hql="";
		try{
			hql="from Reimbursement where Rstate!='D' and "
					+ " project.p_uuid =?";
			@SuppressWarnings("unchecked")
			List<Reimbursement> list=(List<Reimbursement>)this.getHibernateTemplate().find(hql,UUID);		
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
 