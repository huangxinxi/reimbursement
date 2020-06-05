package dao;

import model.Jurisdiction;

public interface JurisdictionDAO {

	/**
	 * 添加权限
	 * @param T
	 * @return
	 */
	public boolean save(Jurisdiction T);
	/**
	 * 删除权限
	 * @param T
	 * @return
	 */
	public boolean delete(Jurisdiction T);
	
	/**
	 * 更新权限
	 * @param T
	 * @return
	 */
	public boolean update(Jurisdiction T);
	
	/**
	 * 查找所有权限
	 * @return
	 */
	public java.util.ArrayList<Jurisdiction> findAll();
	
	/**
	 * 根据查找一个权限
	 * @param ID
	 * @return
	 */
	public Jurisdiction findByID(String ID);
}
