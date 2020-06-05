package dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UploadDao;
import model.FileUpload;

public class UploadDaoImpl extends HibernateDaoSupport implements UploadDao{

	@Override
	public FileUpload writeroad(FileUpload fileupload) {
		// TODO 自动生成的方法存根
		try{
			this.getHibernateTemplate().save(fileupload);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
