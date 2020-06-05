package service.impl;

import java.util.ArrayList;
import model.Usertype;
import dao.impl.UsertypeDaoImpl;
import service.UsertypeService;

public class UsertypeServiceImpl implements UsertypeService{
	private UsertypeDaoImpl UsertypeDaoImpl;
	
	public UsertypeDaoImpl getUsertypeDaoImpl() {
		return UsertypeDaoImpl;
	}

	public void setUsertypeDaoImpl(UsertypeDaoImpl usertypeDaoImpl) {
		UsertypeDaoImpl = usertypeDaoImpl;
	}

	@Override
	public boolean save(Usertype ut) {
		// TODO 自动生成的方法存根
		UsertypeDaoImpl.save(ut);
		return false;
	}

	@Override
	public boolean delete(Usertype ut) {
		// TODO 自动生成的方法存根
		UsertypeDaoImpl.delete(ut);
		return false;
	}

	@Override
	public boolean update(Usertype ut) {
		// TODO 自动生成的方法存根
		UsertypeDaoImpl.update(ut);
		return false;
	}

	@Override
	public ArrayList<Usertype> findAll() {
		// TODO 自动生成的方法存根	
		return UsertypeDaoImpl.findAll();
	}

	@Override
	public Usertype findByID(String ut_uuid) {
		// TODO 自动生成的方法存根
		return UsertypeDaoImpl.findByID(ut_uuid);
	}

}
