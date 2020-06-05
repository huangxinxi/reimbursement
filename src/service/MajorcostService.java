package service;

import java.util.ArrayList;

import util.SpringUtil;
import dao.impl.MajorcostDaoImpl;
import model.Majorcost;
import model.Majorcosttype;
import model.Project;

public interface MajorcostService {
	public boolean save(Majorcost p);

	public boolean delete(Majorcost p);
	
	public boolean deleteByPUID(String puid);

	public boolean update(Majorcost p);
	

	public java.util.ArrayList<Majorcost> findAll();
	
	public ArrayList<Majorcost> findByPUID(String puid);
}
