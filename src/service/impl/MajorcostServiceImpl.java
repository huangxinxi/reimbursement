package service.impl;

import java.util.ArrayList;

import dao.impl.MajorcostDaoImpl;
import dao.impl.ProjectDaoImpl;
import model.Majorcost;
import model.Majorcosttype;
import model.Project;
import service.MajorcostService;
import service.ProjectService;
import util.SpringUtil;

public class MajorcostServiceImpl implements MajorcostService{
	private MajorcostDaoImpl dao;

	
	
	public MajorcostDaoImpl getDao() {
		return dao;
	}

	public void setDao(MajorcostDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public boolean save(Majorcost p) {
		dao = (MajorcostDaoImpl) SpringUtil.getApplicationContext().getBean("MajorcostDaoImpl");
		return dao.save(p);
	}

	@Override
	public boolean delete(Majorcost p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Majorcost p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Majorcost> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Majorcost> findByPUID(String puid) {
		dao = (MajorcostDaoImpl) SpringUtil.getApplicationContext().getBean("MajorcostDaoImpl");
		return dao.findByPUID(puid);
	}

	@Override
	public boolean deleteByPUID(String puid) {
		dao = (MajorcostDaoImpl) SpringUtil.getApplicationContext().getBean("MajorcostDaoImpl");
		return dao.deleteByPUID(puid);
	}

}
