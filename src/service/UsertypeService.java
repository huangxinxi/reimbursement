package service;

import model.Usertype;

public interface UsertypeService {
	/**
	 * ����û�����
	 * @param ut
	 * @return
	 */
	public boolean save(Usertype ut);
	/**
	 * ɾ���û�����
	 * @param ut
	 * @return
	 */
	public boolean delete(Usertype ut);
	/**
	 * �޸��û�����
	 * @param ut
	 * @return
	 */
	public boolean update(Usertype ut);
	/**
	 * ���������û�����
	 * @return
	 */
	public java.util.ArrayList<Usertype> findAll();
	
	/**
	 * ����ID�����û�����
	 * @return
	 */
	public Usertype findByID(String ut_uuid);
}
