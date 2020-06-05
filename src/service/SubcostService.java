package service;

import java.util.List;

import dao.SubcostDAO;
import model.Subcost;

/** 
* @author 作者 :王家南
* @version 创建时间：2017年7月12日 上午9:09:33 
* 类说明 
*/
public class SubcostService {
	private SubcostDAO subcostDao;

	public SubcostDAO getSubcostDao() {
		return subcostDao;
	}

	public void setSubcostDao(SubcostDAO subcostDao) {
		this.subcostDao = subcostDao;
	}
	/**
	 * 添加次要费用
	 * @param mct
	 * @return
	 */
	public boolean save(Subcost T){
		return this.subcostDao.save(T);
	}
	/**
	 * 删除次要费用
	 * @param mct
	 * @return
	 */
	public boolean delete(Subcost T){
		return this.subcostDao.delete(T);
	}
	/**
	 * 根据UUID删除次要费用类型
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID){
		return this.subcostDao.deleteByID(UUID);
		}
	/**
	 * 修改次要费用
	 * @param mct
	 * @return
	 */
	public boolean update(Subcost T){
		return this.subcostDao.update(T);
	}
	/**
	 * 查找所有次要费用类型
	 * @return
	 */
	public List<Subcost> findAll(){
		return this.subcostDao.findAll();
	}
	/**
	 * 根据UUIDID查找次要费用类型
	 * @return
	 */
	public Subcost findByID(String UUID){
		return this.subcostDao.findByID(UUID);
	}
	
	/**
	 * 根据报销单的uuid查询报销项
	 * @param UUID
	 * @return
	 */
	public List<Subcost> findAllByRUUID(String UUID){
		return this.subcostDao.findAllByRUUID(UUID);
	}
	
}
 