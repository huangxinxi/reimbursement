package dao;

import java.util.List;

import model.Majorcosttype;
import model.Subcosttype;

public interface SubcosttypeDao {
	/**
	 * 添加次要费用类型
	 * @param mct
	 * @return
	 */
	public boolean save(Subcosttype T);
	/**
	 * 删除次要费用类型
	 * @param mct
	 * @return
	 */
	public boolean delete(Subcosttype T);
	/**
	 * 根据UUID删除次要费用类型
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID);
	/**
	 * 修改次要费用类型
	 * @param mct
	 * @return
	 */
	public boolean update(Subcosttype T);
	/**
	 * 查找所有次要费用类型
	 * @return
	 */
	public List<Subcosttype> findAll();
	/**
	 * 根据UUIDID查找次要费用类型
	 * @return
	 */
	public Subcosttype findByID(String UUID);
	
	/**
	 * 全表模糊查询
	 * @param values
	 * @return
	 */
	public List<Subcosttype> findSubcosttypeBydim(String values);
}
