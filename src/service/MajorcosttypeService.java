package service;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dao.MajorcosttypeDao;
import dao.QueryTableDAO;
import model.Majorcosttype;


/** 
* @author ���� :������
* @version ����ʱ�䣺2017��7��7�� ����10:32:58 
* ��˵�� 
*/
public class MajorcosttypeService {
	private MajorcosttypeDao majorcosttypeDao;
	private QueryTableDAO queryTableDAO;
	
	public void setMajorcosttypeDao(MajorcosttypeDao majorcosttypeDao) {
		this.majorcosttypeDao = majorcosttypeDao;
	}
	
	public void setQueryTableDAO(QueryTableDAO queryTableDAO) {
		this.queryTableDAO = queryTableDAO;
	}

	/**
	 * ������Ҫ��������
	 * @param Majorcosttype
	 * @return
	 */
	public boolean save(Majorcosttype T){
		if(this.majorcosttypeDao.save(T)){
			return true;
		}else{
			return false;
		}
	}
	
	

	/**
	 * �޸���Ҫ��������
	 * @param Majorcosttype
	 * @return
	 */
	public boolean update(Majorcosttype T){
		if(this.majorcosttypeDao.update(T)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * ���ݶ�����Ҫ��������
	 * @param Majorcosttype
	 * @return
	 */
	public boolean delete(Majorcosttype T){
		if(this.majorcosttypeDao.delete(T)){
			return true;
		}else{
			return false;
		}
	}
	public boolean deleteByID(String UUID){
		if(this.majorcosttypeDao.deleteByID(UUID)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * ��ѯ������Ҫ��������
	 * @return
	 */
	public List<Majorcosttype> findAll(){
		return this.majorcosttypeDao.findAll();
	}
		
	/**
	 * ����UUID��ѯ��Ҫ��������
	 * @return
	 */
	public Majorcosttype findByID(String UUID){
		return this.majorcosttypeDao.findByID(UUID);
	}
	/**
	 * ��������Ĳ�ѯ���������б�
	 * @param select
	 * @param checkbox
	 * @return
	 */
	public List<Majorcosttype> refreshMajorcosttypeTable(String select,String checkbox){
		Map<String,Object> varables=new HashMap<String,Object>();
		if(checkbox.equals("all")){		
			List<Majorcosttype> list=this.majorcosttypeDao.findMajorcosttypeBydim(select);	
			return list;
		}else{
			varables.put(checkbox,select);
			List<Majorcosttype> list=(List<Majorcosttype>)queryTableDAO.queryResultList(Majorcosttype.class, varables);	
			Iterator<Majorcosttype> it = list.iterator();
			list=new java.util.ArrayList<>();
			while(it.hasNext()){
				Majorcosttype x = it.next();
			    if(x.getMtstate().equals("D")){
			        it.remove();
			    }else{
			    	list.add(x);
			    }
			}		
			return list;
		}
	}
}
 