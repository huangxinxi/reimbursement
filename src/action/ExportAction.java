package action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import model.Reimbursement;
import service.ReimbursementService;
import util.SpringUtil;

/**
 * 导出excel
 * @author Administrator
 *
 */
public class ExportAction extends ActionSupport{
	private ReimbursementService reimbursementService = (ReimbursementService) SpringUtil.getBean("ReimbursementService");
	private Reimbursement reimbursement = (Reimbursement) SpringUtil.getBean("Reimbursement");
	
	public ReimbursementService getReimbursementService() {
		return reimbursementService;
	}
	public void setReimbursementService(ReimbursementService reimbursementService) {
		this.reimbursementService = reimbursementService;
	}
	public Reimbursement getReimbursement() {
		return reimbursement;
	}
	public void setReimbursement(Reimbursement reimbursement) {
		this.reimbursement = reimbursement;
	}


	public String execute() throws Exception 
	{   

	/** 
	*如果是从数据库里面取数据，就让List=取数据的函数： 
	*
	*/ 
	List rList=reimbursementService.findAll();//报销LIst 

	/*设置表头：对Excel每列取名 
	*(必须根据你取的数据编写) 
	*/ 
	String []tableHeader={"教师姓名","报销数","预算数","剩余预算数"}; 
	/* 
	             *下面的都可以拷贝不用编写 
	             */ 
	short cellNumber=(short)tableHeader.length;//表的列数 
	HSSFWorkbook workbook = new HSSFWorkbook();	//创建一个excel 
	HSSFCell cell = null;	//Excel的列 
	HSSFRow row = null;	//Excel的行 
	HSSFCellStyle style = workbook.createCellStyle();	//设置表头的类型 
	style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
	HSSFCellStyle style1 = workbook.createCellStyle();	//设置数据类型 
	style1.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
	HSSFFont font = workbook.createFont();	//设置字体 
	HSSFSheet sheet = workbook.createSheet("sheet1");	//创建一个sheet 
	HSSFHeader header = sheet.getHeader();//设置sheet的头 
	try {              /** 
	                     *根据是否取出数据，设置header信息 
	                     * 
	                     */ 
	if(rList.size() < 1 ){ 
	header.setCenter("查无资料"); 
	}else{ 
	header.setCenter("报销表"); 
	row = sheet.createRow(0); 
	row.setHeight((short)400); 
	for(int k = 0;k < cellNumber;k++){	
	cell = row.createCell(k);//创建第0行第k列 
	cell.setCellValue(tableHeader[k]);//设置第0行第k列的值 
	sheet.setColumnWidth(k,8000);//设置列的宽度 
	font.setColor(HSSFFont.COLOR_NORMAL); // 设置单元格字体的颜色. 
	font.setFontHeight((short)350); //设置单元字体高度 
	style1.setFont(font);//设置字体风格 
	cell.setCellStyle(style1); 
	} 
	                        /* 
	                         * // 给excel填充数据这里需要编写 
	                         *     
	                         */ 
	for(int i = 0 ;i < rList.size() ;i++){	   
	Reimbursement reimbursement1 = (Reimbursement)rList.get(i);//获取student对象 
	    row = sheet.createRow((short) (i + 1));//创建第i+1行 
	    row.setHeight((short)400);//设置行高 
	    
	    if(reimbursement1.getProject().getPresuser().getUname() != null){ 
	    cell = row.createCell(0);//创建第i+1行第0列 
	    cell.setCellValue(reimbursement1.getProject().getPresuser().getUname());//设置第i+1行第0列的值 
	    cell.setCellStyle(style);//设置风格 
	    }    
	    if(reimbursement1.getRcostall() != 0){ 
		    cell = row.createCell(1); //创建第i+1行第1列 
		    cell.setCellValue(reimbursement1.getRcostall());//设置第i+1行第1列的值 
		    cell.setCellStyle(style); //设置风格 
		} 
	    if(reimbursement1.getProject().getPcostidp()!= 0&&reimbursement1.getProject().getPcostpub()!=0){ 
		    cell = row.createCell(2); //创建第i+1行第1列 
		    cell.setCellValue(reimbursement1.getProject().getPcostidp()+reimbursement1.getProject().getPcostpub());//设置第i+1行第1列的值 
		    cell.setCellStyle(style); //设置风格 
		} 
	    if(reimbursement1.getProject().getPcostidp()!= 0&&reimbursement1.getProject().getPcostpub()!=0&&reimbursement1.getRcostall() != 0){ 
		    cell = row.createCell(3); //创建第i+1行第1列 
		    cell.setCellValue(reimbursement1.getProject().getPcostidp()+reimbursement1.getProject().getPcostpub()-reimbursement1.getRcostall());//设置第i+1行第1列的值 
		    cell.setCellStyle(style); //设置风格 
		} 
	} 

	} 

	} catch (Exception e) { 
	e.printStackTrace(); 
	} 

	  /* 
	   *下面的可以不用编写，直接拷贝 
	   * 
	   */ 
	HttpServletResponse response = null;//创建一个HttpServletResponse对象 
	OutputStream out = null;//创建一个输出流对象 
	try { 
	response = ServletActionContext.getResponse();//初始化HttpServletResponse对象 
	out = response.getOutputStream();// 
	        response.setHeader("Content-disposition","attachment; filename="+"reimbursement.xls");//filename是下载的xls的名，建议最好用英文 
	        response.setContentType("application/msexcel;charset=UTF-8");//设置类型 
	        response.setHeader("Pragma","No-cache");//设置头 
	        response.setHeader("Cache-Control","no-cache");//设置头 
	        response.setDateHeader("Expires", 0);//设置日期头 
	        workbook.write(out); 
	        out.flush(); 
	workbook.write(out); 
	} catch (IOException e) { 
	e.printStackTrace(); 
	}finally{ 
	try{ 

	if(out!=null){ 
	out.close(); 
	} 

	}catch(IOException e){ 
	e.printStackTrace(); 
	} 

	} 
	return "export_success"; 
	} 
}