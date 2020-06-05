package dao;

import java.util.List;

import model.Subcost;

/** 
* @author 作者 :王家南
* @version 创建时间：2017年7月12日 上午9:04:07 
* 类说明 
* 次要费用
*/
public interface SubcostDAO {
	/**
	 * 添加次要费用
	 * @param mct
	 * @return
	 */
	public boolean save(Subcost T);
	/**
	 * 删除次要费用
	 * @param mct
	 * @return
	 */
	public boolean delete(Subcost T);
	/**
	 * 根据UUID删除次要费用类型
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID);
	/**
	 * 修改次要费用
	 * @param mct
	 * @return
	 */
	public boolean update(Subcost T);
	/**
	 * 查找所有次要费用类型
	 * @return
	 */
	public List<Subcost> findAll();
	/**
	 * 根据UUIDID查找次要费用类型
	 * @return
	 */
	public Subcost findByID(String UUID);
	/**
	 * 根据报销单的UUID查找所有次要费用类型
	 * @return
	 */
	public List<Subcost> findAllByRUUID(String UUID);
}
 