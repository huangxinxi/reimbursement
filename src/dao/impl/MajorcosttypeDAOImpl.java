package dao.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import dao.MajorcosttypeDao;
import model.Majorcosttype;

/**
 * @author 作者 :王家南
 * @version 创建时间：2017年7月7日 上午10:19:50 类说明
 */
public class MajorcosttypeDAOImpl extends HibernateDaoSupport implements MajorcosttypeDao {

	public boolean save(Majorcosttype T) {
		T.setMtstate("A");
		try {
			this.getHibernateTemplate().save(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(Majorcosttype T) {
		T.setMtstate("D");
		try {
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteByID(String UUID) {
		Majorcosttype T = this.findByID(UUID);
		T.setMtstate("D");
		try {
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean update(Majorcosttype T) {
		try {
			T.setMtstate("A");
			this.getHibernateTemplate().update(T);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public List<Majorcosttype> findAll() {
		String hql="";
		try{
			hql="from Majorcosttype where Mtstate!='D'";
			@SuppressWarnings("unchecked")
			List<Majorcosttype> list=(List<Majorcosttype>)this.getHibernateTemplate().find(hql);		
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}


	public Majorcosttype findByID(String UUID) {
		String hql="";
		try{
			hql="from Majorcosttype where mt_uuid=? and"
					+ "Mtstate!='D'";
			Majorcosttype majorcosttype=(Majorcosttype)this.getHibernateTemplate().get(Majorcosttype.class, UUID);
			return majorcosttype;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public List<Majorcosttype> findMajorcosttypeBydim(String values) {
		String hql="";
		values="%"+values+"%";
		try{
			hql="from Majorcosttype where mtstate!='D' and (mtid like ?  or "
					+ "mttype like ? )";
			@SuppressWarnings("unchecked")
			List<Majorcosttype> list=(List<Majorcosttype>)this.getHibernateTemplate().find(hql,values,values);
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
