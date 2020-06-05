package service;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dao.MajorcosttypeDao;
import dao.QueryTableDAO;
import dao.SubcosttypeDao;
import model.Majorcosttype;
import model.Subcosttype;


/** 
* @author ���� :������
* @version ����ʱ�䣺2017��7��7�� ����10:32:58 
* ��˵�� 
*/
public class SubcosttypeService {
	private SubcosttypeDao subcosttypeDao;
	private QueryTableDAO queryTableDAO;
	private MajorcosttypeDao majorcosttypeDao;
	
	public void setMajorcosttypeDao(MajorcosttypeDao majorcosttypeDao) {
		this.majorcosttypeDao = majorcosttypeDao;
	}
	public void setSubcosttypeDao(SubcosttypeDao subcosttypeDao) {
		this.subcosttypeDao = subcosttypeDao;		
	}
	public void setQueryTableDAO(QueryTableDAO queryTableDAO) {
		this.queryTableDAO = queryTableDAO;
	}
	/**
	 * ����η�������
	 * @param Subcosttype
	 * @return
	 */
	public boolean save(Subcosttype T){
		if(this.subcosttypeDao.save(T)){
			return true;
		}else{
			return false;
		}
	}
	
	

	/**
	 * �޸Ĵη�������
	 * @param Subcosttype
	 * @return
	 */
	public boolean update(Subcosttype T){
		if(this.subcosttypeDao.update(T)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * ���ݶ���η�������
	 * @param Subcosttype
	 * @return
	 */
	public boolean delete(Subcosttype T){
		if(this.subcosttypeDao.delete(T)){
			return true;
		}else{
			return false;
		}
	}
	public boolean deleteByID(String UUID){
		if(this.subcosttypeDao.deleteByID(UUID)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * ��ѯ���дη�������
	 * @return
	 */
	public List<Subcosttype> findAll(){
		return this.subcosttypeDao.findAll();
	}
		
	/**
	 * ����UUID��ѯ�η�������
	 * @return
	 */
	public Subcosttype findByID(String UUID){
		return this.subcosttypeDao.findByID(UUID);
	}
	/**
	 * ��������Ĳ�ѯ���������б�
	 * @param select
	 * @param checkbox
	 * @return
	 */
	public List<Subcosttype> refreshSubcosttypeTable(String select,String checkbox){
		Map<String,Object> varables=new HashMap<String,Object>();
		if(checkbox.equals("all")){		
			List<Subcosttype> list=this.subcosttypeDao.findSubcosttypeBydim(select);
			for (Subcosttype s : list) {
				s.setMajorcosttype(this.majorcosttypeDao.findByID(s.getMajorcosttype().getMt_uuid()));			
				
			}
			return list;
		}else{
			varables.put(checkbox,select);
			List<Subcosttype> list=(List<Subcosttype>)queryTableDAO.queryResultList(Subcosttype.class, varables);	
			Iterator<Subcosttype> it = list.iterator();
			list=new java.util.ArrayList<>();
			while(it.hasNext()){
				Subcosttype x = it.next();
			    if(x.getState().equals("D")){
			        it.remove();
			    }else{
			    	list.add(x);
			    }
			}		
			return list;
		}
	}
}
 