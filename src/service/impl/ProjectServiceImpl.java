package service.impl;

import java.util.ArrayList;

import dao.impl.ProjectDaoImpl;
import model.Majorcosttype;
import model.Project;
import service.ProjectService;
import util.SpringUtil;

public class ProjectServiceImpl implements ProjectService{
	private ProjectDaoImpl dao;
	
	public ProjectDaoImpl getDao() {
		return dao;
	}

	public void setDao(ProjectDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public boolean save(Project p) {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.save(p);
	}

	@Override
	public boolean delete(Project p) {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.delete(p);
	}

	@Override
	public boolean update(Project p) {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.update(p);
	}

	@Override
	public ArrayList<Project> findAll(String u_uuid) {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.findAll(u_uuid);
	}

	@Override
	public Project findByID(int id) {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.findByID(id);
	}

	@Override
	public ArrayList<Majorcosttype> loadMajorCostType() {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.loadMajorCostType();
	}

	@Override
	public ArrayList<Project> loadAllWait() {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.loadAllWait();
	}

	@Override
	public boolean pass(Project p) {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.pass(p);
	}
	
	@Override
	public boolean reject(Project p) {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.reject(p);
	}

	@Override
	public ArrayList<Project> loadReviwed() {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.loadReviewed();
	}


	@Override
	public Project findByUUID(String uuid) {
		dao = (ProjectDaoImpl) SpringUtil.getApplicationContext().getBean("ProjectDaoImpl");
		return dao.findByUUID(uuid);
	}
}
