package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.SubcostDAO;
import model.Subcost;


/** 
* @author 作者 :王家南
* @version 创建时间：2017年7月12日 上午9:06:11 
* 类说明 
*/
public class SubcostDAOImpl extends HibernateDaoSupport implements SubcostDAO {

	public boolean save(Subcost T) {

		try {
			T.setSstate("A");
			this.getHibernateTemplate().save(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(Subcost T) {
		T.setSstate("D");
		try {
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteByID(String UUID) {
		Subcost T = this.findByID(UUID);
		T.setSstate("D");
		try {
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean update(Subcost T) {
		try {
			T.setSstate("A");
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public List<Subcost> findAll() {
		String hql="";
		try{
			hql="from Subcost where sstate!='D'";
			@SuppressWarnings("unchecked")
			List<Subcost> list=(List<Subcost>)this.getHibernateTemplate().find(hql);		
			
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}


	public Subcost findByID(String UUID) {
		String hql="";
		try{
			hql="from Subcost where s_uuid=? and"
					+ "sstate!='D'";
			Subcost Subcosttype=(Subcost)this.getHibernateTemplate().get(Subcost.class, UUID);
			return Subcosttype;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	public List<Subcost> findAllByRUUID(String UUID) {
		String hql="";
		try{
			hql="from Subcost where reimbursement.r_uuid=? and "
					+ "sstate!='D'";
			@SuppressWarnings("unchecked")
			List<Subcost> subcosts=(List<Subcost>)this.getHibernateTemplate().find(hql,UUID);
			return subcosts;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
 