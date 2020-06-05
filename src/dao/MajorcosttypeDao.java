package dao;

import java.util.List;

import model.Majorcosttype;

public interface MajorcosttypeDao {
	/**
	 * �����Ҫ��������
	 * @param mct
	 * @return
	 */
	public boolean save(Majorcosttype T);
	/**
	 * ɾ����Ҫ��������
	 * @param mct
	 * @return
	 */
	public boolean delete(Majorcosttype T);
	/**
	 * ����UUIDɾ����Ҫ��������
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID);
	/**
	 * �޸���Ҫ��������
	 * @param mct
	 * @return
	 */
	public boolean update(Majorcosttype T);
	/**
	 * ����������Ҫ��������
	 * @return
	 */
	public List<Majorcosttype> findAll();
	/**
	 * ����UUIDID������Ҫ��������
	 * @return
	 */
	public Majorcosttype findByID(String UUID);
	
	/**
	 * ȫ�ֶ�����
	 * @param values
	 * @return
	 */
	public List<Majorcosttype> findMajorcosttypeBydim(String values);
}
