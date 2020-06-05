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
		// TODO �Զ����ɵķ������
		UsertypeDaoImpl.save(ut);
		return false;
	}

	@Override
	public boolean delete(Usertype ut) {
		// TODO �Զ����ɵķ������
		UsertypeDaoImpl.delete(ut);
		return false;
	}

	@Override
	public boolean update(Usertype ut) {
		// TODO �Զ����ɵķ������
		UsertypeDaoImpl.update(ut);
		return false;
	}

	@Override
	public ArrayList<Usertype> findAll() {
		// TODO �Զ����ɵķ������	
		return UsertypeDaoImpl.findAll();
	}

	@Override
	public Usertype findByID(String ut_uuid) {
		// TODO �Զ����ɵķ������
		return UsertypeDaoImpl.findByID(ut_uuid);
	}

}
