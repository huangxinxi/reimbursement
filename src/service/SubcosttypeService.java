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
* @author 作者 :王家南
* @version 创建时间：2017年7月7日 上午10:32:58 
* 类说明 
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
	 * 保存次费用类型
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
	 * 修改次费用类型
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
	 * 根据对象次费用类型
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
	 * 查询所有次费用类型
	 * @return
	 */
	public List<Subcosttype> findAll(){
		return this.subcosttypeDao.findAll();
	}
		
	/**
	 * 根据UUID查询次费用类型
	 * @return
	 */
	public Subcosttype findByID(String UUID){
		return this.subcosttypeDao.findByID(UUID);
	}
	/**
	 * 根据输入的查询参数更新列表
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
 