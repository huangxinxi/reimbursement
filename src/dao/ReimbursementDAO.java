package dao;

import java.util.List;

import model.Reimbursement;
import model.Subcosttype;

/** 
* @author 作者 :王家南
* @version 创建时间：2017年7月10日 下午1:08:15 
* 类说明 
*/
public interface ReimbursementDAO {
	/**
	 * 添加报销
	 * @param mct
	 * @return
	 */
	public boolean save(Reimbursement T);
	/**
	 * 删除报销
	 * @param mct
	 * @return
	 */
	public boolean delete(Reimbursement T);
	/**
	 * 根据UUID删除报销
	 * @param uuid
	 * @return
	 */
	public boolean deleteByID(String UUID);
	/**
	 * 修改报销
	 * @param mct
	 * @return
	 */
	public boolean update(Reimbursement T);
	/**
	 * 查找所有报销
	 * @return
	 */
	public List<Reimbursement> findAll();
	/**
	 * 根据UUIDID查找报销
	 * @return
	 */
	public Reimbursement findByID(String UUID);
	/**
	 * 根据项目ＵＵＩＤ查找所有报销
	 * @return
	 */
	public List<Reimbursement> findAllByPID(String UUID);
	
	/**
	 * 查询所有未审核的值
	 * @return
	 */
	public List<Reimbursement> findAll_check();

}
 