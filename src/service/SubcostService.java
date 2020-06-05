package service;

import java.util.List;

import dao.SubcostDAO;
import model.Subcost;

/** 
* @author ���� :������
* @version ����ʱ�䣺2017��7��12�� ����9:09:33 
* ��˵�� 
*/
public class SubcostService {
	private SubcostDAO subcostDao;

	public SubcostDAO getSubcostDao() {
		return subcostDao;
	}

	public void setSubcostDao(SubcostDAO subcostDao) {
		this.subcostDao = subcostDao;
	}
	/**
	 * ��Ӵ�Ҫ����
	 * @param mct
	 * @return
	 */
	public boolean save(Subcost T){
		return this.subcostDao.save(T);
	}
	/**
	 * ɾ����Ҫ����
	 * @param mct
	 * @return
	 */
	public boolean delete(Subcost T){
		return this.subcostDao.delete(T);
	}
	/**
	 * ����UUIDɾ����Ҫ��������
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID){
		return this.subcostDao.deleteByID(UUID);
		}
	/**
	 * �޸Ĵ�Ҫ����
	 * @param mct
	 * @return
	 */
	public boolean update(Subcost T){
		return this.subcostDao.update(T);
	}
	/**
	 * �������д�Ҫ��������
	 * @return
	 */
	public List<Subcost> findAll(){
		return this.subcostDao.findAll();
	}
	/**
	 * ����UUIDID���Ҵ�Ҫ��������
	 * @return
	 */
	public Subcost findByID(String UUID){
		return this.subcostDao.findByID(UUID);
	}
	
	/**
	 * ���ݱ�������uuid��ѯ������
	 * @param UUID
	 * @return
	 */
	public List<Subcost> findAllByRUUID(String UUID){
		return this.subcostDao.findAllByRUUID(UUID);
	}
	
}
 