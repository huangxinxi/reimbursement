package dao;


import java.util.ArrayList;

import model.Majorcosttype;
import model.Project;

public interface ProjectDao {


	public boolean save(Project p);

	public boolean delete(Project p);

	public boolean update(Project p);

	public java.util.ArrayList<Project> findAll(String u_uuid);
	
	public java.util.ArrayList<Project> loadAllWait();
	
	public java.util.ArrayList<Project> loadReviewed();

	public Project findByID(int id);
	
	public ArrayList<Majorcosttype> loadMajorCostType();
	
	public boolean pass(Project p);
	
	public boolean reject(Project p);
}
