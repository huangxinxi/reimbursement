package dao;

import java.util.List;

import model.Majorcosttype;

public interface MajorcosttypeDao {
	/**
	 * 添加主要费用类型
	 * @param mct
	 * @return
	 */
	public boolean save(Majorcosttype T);
	/**
	 * 删除主要费用类型
	 * @param mct
	 * @return
	 */
	public boolean delete(Majorcosttype T);
	/**
	 * 根据UUID删除主要费用类型
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID);
	/**
	 * 修改主要费用类型
	 * @param mct
	 * @return
	 */
	public boolean update(Majorcosttype T);
	/**
	 * 查找所有主要费用类型
	 * @return
	 */
	public List<Majorcosttype> findAll();
	/**
	 * 根据UUIDID查找主要费用类型
	 * @return
	 */
	public Majorcosttype findByID(String UUID);
	
	/**
	 * 全字段搜索
	 * @param values
	 * @return
	 */
	public List<Majorcosttype> findMajorcosttypeBydim(String values);
}
