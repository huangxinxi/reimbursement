package dao;

import java.util.List;

import model.Reimbursement;
import model.Subcosttype;

/** 
* @author ���� :������
* @version ����ʱ�䣺2017��7��10�� ����1:08:15 
* ��˵�� 
*/
public interface ReimbursementDAO {
	/**
	 * ��ӱ���
	 * @param mct
	 * @return
	 */
	public boolean save(Reimbursement T);
	/**
	 * ɾ������
	 * @param mct
	 * @return
	 */
	public boolean delete(Reimbursement T);
	/**
	 * ����UUIDɾ������
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID);
	/**
	 * �޸ı���
	 * @param mct
	 * @return
	 */
	public boolean update(Reimbursement T);
	/**
	 * �������б���
	 * @return
	 */
	public List<Reimbursement> findAll();
	/**
	 * ����UUIDID���ұ���
	 * @return
	 */
	public Reimbursement findByID(String UUID);
	/**
	 * ������Ŀ�գգɣĲ������б���
	 * @return
	 */
	public List<Reimbursement> findAllByPID(String UUID);
	
	/**
	 * ��ѯ����δ��˵�ֵ
	 * @return
	 */
	public List<Reimbursement> findAll_check();

}
 