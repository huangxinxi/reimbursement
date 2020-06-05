package dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import dao.SubcosttypeDao;
import model.Majorcosttype;
import model.Subcosttype;

/**
 * @author 作者 :王家南
 * @version 创建时间：2017年7月7日 上午10:19:50 类说明
 */
public class SubcosttypeDAOImpl extends HibernateDaoSupport implements SubcosttypeDao {

	public boolean save(Subcosttype T) {

		try {
			T.setState("A");
			this.getHibernateTemplate().save(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(Subcosttype T) {
		T.setState("D");
		try {
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteByID(String UUID) {
		Subcosttype T = this.findByID(UUID);
		T.setState("D");
		try {
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean update(Subcosttype T) {
		try {
			T.setState("A");
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public List<Subcosttype> findAll() {
		String hql="";
		try{
			hql="from Subcosttype where state!='D'";
			@SuppressWarnings("unchecked")
			List<Subcosttype> list=(List<Subcosttype>)this.getHibernateTemplate().find(hql);		
			
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}


	public Subcosttype findByID(String UUID) {
		String hql="";
		try{
			hql="from Subcosttype where mt_uuid=? and"
					+ "state!='D'";
			Subcosttype Subcosttype=(Subcosttype)this.getHibernateTemplate().get(Subcosttype.class, UUID);
			return Subcosttype;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public List<Subcosttype> findSubcosttypeBydim(String values) {
		String hql="";
		values="%"+values+"%";
		try{
			hql="from Subcosttype where state!='D' and (stsid like ?  or "
					+ "sttype like ? or majorcosttype.mttype  like ?)";
			@SuppressWarnings("unchecked")
			List<Subcosttype> list=(List<Subcosttype>)this.getHibernateTemplate().find(hql,values,values,values);
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
