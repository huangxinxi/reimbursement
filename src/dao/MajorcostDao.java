package dao;

import java.util.ArrayList;

import model.Majorcost;

public interface MajorcostDao {
	public boolean save(Majorcost mc);
	public boolean delete(Majorcost mc);
	public boolean deleteByPUID(String puid);
	public boolean update(Majorcost mc);
	public java.util.ArrayList<Majorcost> findAll();
	public ArrayList<Majorcost> findByPUID(String puid);
}
