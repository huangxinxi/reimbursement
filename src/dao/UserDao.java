package dao;

import model.User;

public interface UserDao {
	
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
	
	
}
