package dao;

import java.util.List;

import model.Majorcosttype;
import model.Subcosttype;

public interface SubcosttypeDao {
	/**
	 * ��Ӵ�Ҫ��������
	 * @param mct
	 * @return
	 */
	public boolean save(Subcosttype T);
	/**
	 * ɾ����Ҫ��������
	 * @param mct
	 * @return
	 */
	public boolean delete(Subcosttype T);
	/**
	 * ����UUIDɾ����Ҫ��������
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID);
	/**
	 * �޸Ĵ�Ҫ��������
	 * @param mct
	 * @return
	 */
	public boolean update(Subcosttype T);
	/**
	 * �������д�Ҫ��������
	 * @return
	 */
	public List<Subcosttype> findAll();
	/**
	 * ����UUIDID���Ҵ�Ҫ��������
	 * @return
	 */
	public Subcosttype findByID(String UUID);
	
	/**
	 * ȫ��ģ����ѯ
	 * @param values
	 * @return
	 */
	public List<Subcosttype> findSubcosttypeBydim(String values);
}
