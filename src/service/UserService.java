package service;

import java.util.List;

import model.Majorcosttype;
import model.User;

public interface UserService {
	/**
	 * ����û�
	 * @param u
	 * @return
	 */
	public boolean save(User u);
	/**
	 * ɾ���û�
	 * @param u
	 * @return
	 */
	public boolean delete(User u);
	/**
	 * �޸��û�
	 * @param u
	 * @return
	 */
	public boolean update(User u);
	/**
	 * ���������û�
	 * @return
	 */
	public java.util.ArrayList<User> findAll();
	
	/**
	 * ���ID�����û�
	 * @return
	 */
	public User findByID(String u_uuid);

	/**
	 * ��¼��֤
	 * @param user
	 * @return
	 */
	public User checklogin(User user);
	/**
	 * ��ѯ
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<User> refreshUserTable(String select,String checkbox);
}
