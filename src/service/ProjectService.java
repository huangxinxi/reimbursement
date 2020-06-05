package service;

import java.util.ArrayList;

import model.Majorcosttype;
import model.Project;

public interface ProjectService {
	public boolean save(Project p);

	public boolean delete(Project p);
	
	public boolean pass(Project p);

	public boolean reject(Project p);
	
	public boolean update(Project p);
	

	public java.util.ArrayList<Project> findAll(String u_uuid);
	
	public java.util.ArrayList<Project> loadAllWait();
	
	public java.util.ArrayList<Project> loadReviwed();

	public Project findByID(int id);
	
	public ArrayList<Majorcosttype> loadMajorCostType();
	
	/**
	 * ��ݣգգɣĻ�ȡ��������
	 * @param id
	 * @return
	 */
	public Project findByUUID(String uuid);
}
