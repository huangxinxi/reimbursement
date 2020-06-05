package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import com.opensymphony.xwork2.ActionSupport;

import model.FileUpload;
import service.impl.UploadServiceImpl;
import util.SpringUtil;

public class UploadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	 
    private File myFile;//�ϴ����ļ�����Ӧ�?��file��name����
    private String myFileContentType;//�ļ����ͣ�xxxContentType��xxx��Ӧ�?file��name����
    private String myFileFileName;
    private UploadServiceImpl uploadServiceImpl = (UploadServiceImpl) SpringUtil.getBean("UploadServiceImpl");
    private FileUpload fileUpload = (FileUpload) SpringUtil.getBean("FileUpload");

    public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public UploadServiceImpl getUploadServiceImpl() {
		return uploadServiceImpl;
	}
	public void setUploadServiceImpl(UploadServiceImpl uploadServiceImpl) {
		this.uploadServiceImpl = uploadServiceImpl;
	}
	public FileUpload getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
	@Override
    public String execute() throws Exception {
        if (myFile == null) {
        	System.out.println(myFileFileName);
            this.addFieldError("file", "请选择上传文件");          
            return "upload_null";
        } 	
		else{
            InputStream is = new FileInputStream(this.getMyFile());
            OutputStream os = new FileOutputStream(new File("D:/", this.getMyFileFileName()));
            
            fileUpload.setFileroad("D:/");
            fileUpload.setMyFileFileName(this.getMyFileFileName());
            uploadServiceImpl.writeroad(fileUpload);
            
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = is.read(buf)) > 0) {
                os.write(buf, 0, length);
            }
            is.close();
            os.close();
		}
        return "upload_success";
    }
 
  
 
}
