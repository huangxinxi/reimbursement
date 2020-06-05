package service;

import model.Usertype;

public interface UsertypeService {
	/**
	 * 添加用户类型
	 * @param ut
	 * @return
	 */
	public boolean save(Usertype ut);
	/**
	 * 删除用户类型
	 * @param ut
	 * @return
	 */
	public boolean delete(Usertype ut);
	/**
	 * 修改用户类型
	 * @param ut
	 * @return
	 */
	public boolean update(Usertype ut);
	/**
	 * 查找所有用户类型
	 * @return
	 */
	public java.util.ArrayList<Usertype> findAll();
	
	/**
	 * 根据ID查找用户类型
	 * @return
	 */
	public Usertype findByID(String ut_uuid);
}
