package action;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import dao.impl.MajorcostDaoImpl;
import model.Majorcost;
import model.Reimbursement;
import model.Subcost;
import model.Subcosttype;
import service.SubcostService;
import service.SubcosttypeService;
import util.AjaxResponse;
import util.Pagekit;
import util.SpringUtil;

/** 
* @author 作者 :王家南
* @version 创建时间：2017年7月12日 下午1:45:11 
* 类说明 
*/
public class SubcostAction extends SuperAction {
	

	private static final long serialVersionUID = 1L;
	private SubcostService  subcostService;
	private SubcosttypeService subcosttypeService;
	public void setSubcostService(SubcostService subcostService) {
		this.subcostService = subcostService;
	}
	public void setSubcosttypeService(SubcosttypeService subcosttypeService) {
		this.subcosttypeService = subcosttypeService;
	}

	/**
	 * 根据报销uuid查询报销项
	 * @return
	 */
	public String findSubcostByRUUID(){
		String UUID=request.getParameter("ruuid");	
		String result;
		List<Subcost> subcosts= this.subcostService.findAllByRUUID(UUID);
		for(Subcost sc:subcosts){
			sc.setSubcosttype(this.subcosttypeService.findByID(sc.getSubcosttype().getSt_uuid()));
		}
		try {
			result = Pagekit.PageData2PageXML(subcosts, Subcost.KEY, Subcost.FIELD);
			HttpServletResponse response = ServletActionContext.getResponse();
			AjaxResponse.printUTF8XML(result, response);
			System.out.println(result);
			return null;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**王家南
	 * 根据主费用的UUID查找次费用使用情况
	 * @return
	 */
	public String findSubcostByPubUUID(){
		String Pubuuid=request.getParameter("Pubuuid");
		String ruuid=request.getParameter("ruuid");
		MajorcostDaoImpl majorcostDaoImpl=(MajorcostDaoImpl) SpringUtil.getBean("MajorcostDaoImpl");
		Majorcost m=majorcostDaoImpl.findByUUID(Pubuuid);
		SubcosttypeService subcosttypeService=(SubcosttypeService) SpringUtil.getBean("SubcosttypeService");
		List<Subcosttype> list= subcosttypeService.findAll();
		Map<String, Subcosttype> tempMap = new HashMap<String, Subcosttype>();		
		for(Subcosttype s:list){
			if(m.getMajorcosttype().getMt_uuid().equals(s.getMajorcosttype().getMt_uuid())){
				tempMap.put(s.getSt_uuid(), s);
			}
		}
		SubcostService subcostService=(SubcostService) SpringUtil.getBean("SubcostService");
		List<Subcost> subcosts= this.subcostService.findAllByRUUID(ruuid);
		for(Subcost sc:subcosts){
			sc.setSubcosttype(this.subcosttypeService.findByID(sc.getSubcosttype().getSt_uuid()));
		}
		List<Subcost> list4=new ArrayList<Subcost>();
		for (Subcost s : subcosts) {
			if(tempMap.containsKey(s.getSubcosttype().getSt_uuid())){
				list4.add(s);
			}	
		}
		
		String result;
		try {
			result = Pagekit.PageData2PageXML(list4, Subcost.KEY, Subcost.FIELD);
			HttpServletResponse response = ServletActionContext.getResponse();
			AjaxResponse.printUTF8XML(result, response);
			return null;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
}
 