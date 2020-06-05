package service;

import java.util.List;

import dao.ReimbursementDAO;
import model.Reimbursement;

/** 
* @author ���� :������
* @version ����ʱ�䣺2017��7��11�� ����9:06:46 
* ��˵�� 
* ��������Service
*/
public class ReimbursementService {
	private ReimbursementDAO reimbursementDao;
	
	public ReimbursementDAO getReimbursementDao() {
		return reimbursementDao;
	}
	public void setReimbursementDao(ReimbursementDAO reimbursementDao) {
		this.reimbursementDao = reimbursementDao;
	}
	/**
	 * ��ӱ���
	 * @param mct
	 * @return
	 */
	public boolean save(Reimbursement T){
		return this.reimbursementDao.save(T);
		
	}
	/**
	 * ɾ������
	 * @param mct
	 * @return
	 */
	public boolean delete(Reimbursement T){
		return this.reimbursementDao.delete(T);
	}
	/**
	 * ����UUIDɾ������
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID){
		return this.reimbursementDao.deleteByID(UUID);
	}
	/**
	 * �޸ı���
	 * @param mct
	 * @return
	 */
	public boolean update(Reimbursement T){
		return this.reimbursementDao.update(T);
	}
	
	/**
	 * �������д���˵ı���
	 * @return
	 */
	
	public List<Reimbursement> findAll_check(){
		return this.reimbursementDao.findAll_check();
	}
	/**
	 * �������б���
	 * @return
	 */
	public List<Reimbursement> findAll(){
		return this.reimbursementDao.findAll();
	}
	/**
	 * ����UUIDID���ұ���
	 * @return
	 */
	public Reimbursement findByID(String UUID){
		return this.reimbursementDao.findByID(UUID);
	}
	/**
	 * ������Ŀ�գգɣĲ������б���
	 * @return
	 */
	public List<Reimbursement> findAllByPID(String UUID){
		return this.reimbursementDao.findAllByPID(UUID);
	}
}
 