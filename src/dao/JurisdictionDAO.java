package dao;

import model.Jurisdiction;

public interface JurisdictionDAO {

	/**
	 * ���Ȩ��
	 * @param T
	 * @return
	 */
	public boolean save(Jurisdiction T);
	/**
	 * ɾ��Ȩ��
	 * @param T
	 * @return
	 */
	public boolean delete(Jurisdiction T);
	
	/**
	 * ����Ȩ��
	 * @param T
	 * @return
	 */
	public boolean update(Jurisdiction T);
	
	/**
	 * ��������Ȩ��
	 * @return
	 */
	public java.util.ArrayList<Jurisdiction> findAll();
	
	/**
	 * ���ݲ���һ��Ȩ��
	 * @param ID
	 * @return
	 */
	public Jurisdiction findByID(String ID);
}
