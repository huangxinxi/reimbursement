package dao;

import java.util.List;

import model.Subcost;

/** 
* @author ���� :������
* @version ����ʱ�䣺2017��7��12�� ����9:04:07 
* ��˵�� 
* ��Ҫ����
*/
public interface SubcostDAO {
	/**
	 * ��Ӵ�Ҫ����
	 * @param mct
	 * @return
	 */
	public boolean save(Subcost T);
	/**
	 * ɾ����Ҫ����
	 * @param mct
	 * @return
	 */
	public boolean delete(Subcost T);
	/**
	 * ����UUIDɾ����Ҫ��������
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID);
	/**
	 * �޸Ĵ�Ҫ����
	 * @param mct
	 * @return
	 */
	public boolean update(Subcost T);
	/**
	 * �������д�Ҫ��������
	 * @return
	 */
	public List<Subcost> findAll();
	/**
	 * ����UUIDID���Ҵ�Ҫ��������
	 * @return
	 */
	public Subcost findByID(String UUID);
	/**
	 * ���ݱ�������UUID�������д�Ҫ��������
	 * @return
	 */
	public List<Subcost> findAllByRUUID(String UUID);
}
 