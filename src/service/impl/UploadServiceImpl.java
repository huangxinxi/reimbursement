package service.impl;

import model.FileUpload;
import service.UploadService;
import dao.impl.*;

public class UploadServiceImpl implements UploadService{
	private UploadDaoImpl UploadDaoImpl;
	
	public UploadDaoImpl getUploadDaoImpl() {
		return UploadDaoImpl;
	}
	public void setUploadDaoImpl(UploadDaoImpl uploadDaoImpl) {
		UploadDaoImpl = uploadDaoImpl;
	}


	@Override
	public FileUpload writeroad(FileUpload fileupload) {
		// TODO �Զ����ɵķ������	
		return UploadDaoImpl.writeroad(fileupload);
	}

}
