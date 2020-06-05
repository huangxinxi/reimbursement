package service;

import java.util.List;

import dao.ReimbursementDAO;
import model.Reimbursement;

/** 
* @author 作者 :王家南
* @version 创建时间：2017年7月11日 下午9:06:46 
* 类说明 
* 报销申请Service
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
	 * 添加报销
	 * @param mct
	 * @return
	 */
	public boolean save(Reimbursement T){
		return this.reimbursementDao.save(T);
		
	}
	/**
	 * 删除报销
	 * @param mct
	 * @return
	 */
	public boolean delete(Reimbursement T){
		return this.reimbursementDao.delete(T);
	}
	/**
	 * 根据UUID删除报销
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID){
		return this.reimbursementDao.deleteByID(UUID);
	}
	/**
	 * 修改报销
	 * @param mct
	 * @return
	 */
	public boolean update(Reimbursement T){
		return this.reimbursementDao.update(T);
	}
	
	/**
	 * 返回所有待审核的报销
	 * @return
	 */
	
	public List<Reimbursement> findAll_check(){
		return this.reimbursementDao.findAll_check();
	}
	/**
	 * 查找所有报销
	 * @return
	 */
	public List<Reimbursement> findAll(){
		return this.reimbursementDao.findAll();
	}
	/**
	 * 根据UUIDID查找报销
	 * @return
	 */
	public Reimbursement findByID(String UUID){
		return this.reimbursementDao.findByID(UUID);
	}
	/**
	 * 根据项目ＵＵＩＤ查找所有报销
	 * @return
	 */
	public List<Reimbursement> findAllByPID(String UUID){
		return this.reimbursementDao.findAllByPID(UUID);
	}
}
 