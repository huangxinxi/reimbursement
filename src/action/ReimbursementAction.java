package action;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import dao.impl.MajorcostDaoImpl;
import model.Majorcost;
import model.Majorcosttype;
import model.Project;
import model.Reimbursement;
import model.Subcost;
import model.Subcosttype;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.MajorcosttypeService;
import service.ReimbursementService;
import service.SubcostService;
import service.SubcosttypeService;
import service.impl.ProjectServiceImpl;
import util.AjaxResponse;
import util.Pagekit;
import util.SpringUtil;

/**
 * @author ���� :������
 * @version ����ʱ�䣺2017��7��10�� ����10:03:56 ��˵�� ���������action
 */
public class ReimbursementAction extends SuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MajorcosttypeService majorcosttypeService;
	private SubcosttypeService subcosttypeService;
	private SubcostService subcostService;
	private Reimbursement reimbursement;
	private ReimbursementService reimbursementService;

	public void setReimbursementService(ReimbursementService reimbursementService) {
		this.reimbursementService = reimbursementService;
	}

	public void setReimbursement(Reimbursement reimbursement) {
		this.reimbursement = reimbursement;
	}

	public void setMajorcosttypeService(MajorcosttypeService majorcosttypeService) {
		this.majorcosttypeService = majorcosttypeService;
	}

	public void setSubcosttypeService(SubcosttypeService subcosttypeService) {
		this.subcosttypeService = subcosttypeService;
	}

	public void setSubcostService(SubcostService subcostService) {
		this.subcostService = subcostService;
	}

	public String InitTree() {
		List<Majorcosttype> majorcosttypes = majorcosttypeService.findAll();
		List<Subcosttype> subcosttypes = subcosttypeService.findAll();
		for (Majorcosttype m : majorcosttypes) {
			m.setSubcosttypes(new ArrayList<Subcosttype>());
			for (Subcosttype s : subcosttypes) {
				if (m.getMt_uuid().equals(s.getMajorcosttype().getMt_uuid()))
					m.getSubcosttypes().add(s);
			}
		}
		String result = Pagekit.PageData2treeXML(majorcosttypes);
		util.AjaxResponse.printUTF8XML(result, response);
		System.out.println(result);
		return null;
	}

	/**
	 * ��ʼ������˵ı������뵥
	 * @return
	 */
	public String InitReimbursementList(){
		
		List<Reimbursement> list = this.reimbursementService.findAll_check();
		try {
			String result=Pagekit.PageData2PageXML(list, Reimbursement.KEY, Reimbursement.FIELD2);
			HttpServletResponse response=ServletActionContext.getResponse();
			AjaxResponse.printUTF8XML(result, response);
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
	/**
	 * ��ݱ����ģգգɣĹ�ѡ����ֵ
	 * @return
	 */
	public String updateTree(){
		String ruuid=request.getParameter("REID");
		List<Majorcosttype> majorcosttypes = majorcosttypeService.findAll();
		List<Subcosttype> subcosttypes = subcosttypeService.findAll();
		List<Subcost> subcosts=subcostService.findAllByRUUID(ruuid);
		List<String> updateList=new ArrayList<String>();
		for(Subcost sc:subcosts){
			updateList.add(sc.getSubcosttype().getSt_uuid());
		}
		for (Majorcosttype m : majorcosttypes) {
			m.setSubcosttypes(new ArrayList<Subcosttype>());
			for (Subcosttype s : subcosttypes) {
				if (m.getMt_uuid().equals(s.getMajorcosttype().getMt_uuid()))
					m.getSubcosttypes().add(s);
			}
		}
		String result = Pagekit.PageData2treeXML(majorcosttypes,updateList);
		util.AjaxResponse.printUTF8XML(result, response);
		System.out.println(result);
		return null;
	}
	/**
	 * �����Ľ������뵥���д���
	 * @return
	 */
	public String checkresult(){
		String id=request.getParameter("id");
		String ruuid=request.getParameter("ruuid");
		Reimbursement reimbursement=this.reimbursementService.findByID(ruuid);
		if(id.equals("ok")){
			/*reimbursement.setRuser();*/
			reimbursement.setRstate("A");//ͨ��
			this.reimbursementService.update(reimbursement);
		}else{
			reimbursement.setRstate("N");//��ͨ��
			this.reimbursementService.update(reimbursement);
		}
		
		JSONObject jb = new JSONObject();
		response.setCharacterEncoding("UTF-8");   
	    try {
			response.getWriter().print(jb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		return null;
	}
	
	public String findMajorcostByRUUID(){
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
		String ruuid = request.getParameter("ruuid");
		ReimbursementService reimbursementService =(ReimbursementService) SpringUtil.getBean("ReimbursementService");
		Reimbursement reimbursement=reimbursementService.findByID(ruuid);	
		String puuid=reimbursement.getProject().getP_uuid();
		MajorcostDaoImpl majorcostDaoImpl=(MajorcostDaoImpl) SpringUtil.getBean("MajorcostDaoImpl");
		String result;
		try {
			result = Pagekit.PageData2PageXML(majorcostDaoImpl.findByPUID(puuid), Majorcost.KEY, Majorcost.FIELD);
			response = ServletActionContext.getResponse();
			AjaxResponse.printUTF8XML(result, response);
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
	
	public String InitReimbursement() throws IOException {
		String list = request.getParameter("List");
		String[] arr = list.split(",");
		Map<String, Subcosttype> tempMap = new HashMap<String, Subcosttype>();
		Map<String, Subcosttype> tempMap2 = new HashMap<String, Subcosttype>();
		List<Subcosttype> subcosttypes = subcosttypeService.findAll();
		for (Subcosttype s : subcosttypes) {
			tempMap.put(s.getSt_uuid(), s);
		}
		for (String uuid : arr) {
			if (tempMap.containsKey(uuid)) {
				tempMap2.put(uuid, tempMap.get(uuid));
			}
		}
		Iterator<Map.Entry<String, Subcosttype>> it = tempMap2.entrySet().iterator();
		subcosttypes = new ArrayList<Subcosttype>();
		while (it.hasNext()) {
			;
			Map.Entry<String, Subcosttype> entry = it.next();
			Subcosttype s = entry.getValue();
			s.setMajorcosttype(null);
			subcosttypes.add(s);
			System.out.println(entry.getValue().getSt_uuid());
		}
		JSONArray ja = new JSONArray().fromObject(subcosttypes);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(ja);
		return null;
	}
	
	public String updateReimbursement(){
		String REID = request.getParameter("REID");
		List<Subcost> subcosts = subcostService.findAllByRUUID(REID);
		List<Majorcosttype> list=new ArrayList<Majorcosttype>();
		int i=0;
		for(Subcost s:subcosts){//��Majorcosttype����Subcost���ݴ������ȥ
			Majorcosttype m=new Majorcosttype();
			m.setMt_uuid(s.getS_uuid());//id
			m.setMttype((this.subcosttypeService.findByID(s.getSubcosttype().getSt_uuid())).getSttype());//
			m.setMtid(s.getScost()+"");
			m.setMtstate(s.getSubcosttype().getSt_uuid());
			m.setSubcosttypes(null);
			list.add(m);
		}	
		try {
			JSONArray ja = new JSONArray().fromObject(list);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(ja);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * ������ �����ĿUUID��ѯ��ʷ�������
	 * 
	 * @return
	 */
	public String findByPUUID() {
		String P_uuid = request.getParameter("P_uuid");
		List<Reimbursement> reimbursements = this.reimbursementService.findAllByPID(P_uuid);
		String result;
		try {
			result = Pagekit.PageData2PageXML(reimbursements, Reimbursement.KEY, Reimbursement.FIELD);
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

	/**
	 * ������ ���汨������
	 * 
	 * @return
	 */
	public String saveReimbursement() {
		int toallcost = 0;
		Date date = null;
		String ruuid = request.getParameter("ruuid");//�޸�ʱʹ��	
		String projectID = request.getParameter("projectID");
		String uuids = request.getParameter("uuids");
		String values = request.getParameter("values");
		for (String id : uuids.split(",")) {
			System.out.println(id);
		}
		for (String value : values.split(",")) {
			toallcost += Integer.parseInt(value);
		}		
		Project project = new Project();
		project.setP_uuid(projectID);
		String r_uuid = UUID.randomUUID().toString();// ���ñ����uuid
		reimbursement.setRcostall(toallcost);
		reimbursement.setProject(project);
		reimbursement.setRdate(new Date());
		reimbursement.setRuser(null);
		if(ruuid!=null){
			date=this.reimbursementService.findByID(ruuid).getRdate();
			reimbursement.setRdate(date);
			this.reimbursementService.deleteByID(ruuid);
		}
			reimbursement.setR_uuid(r_uuid);	
			this.reimbursementService.save(reimbursement);
		List<Subcost> sublist = new ArrayList<Subcost>();
		for (String id : uuids.split(",")) {
			Subcost subcost = new Subcost();
			Subcosttype st = new Subcosttype();
			st.setSt_uuid(id);
			subcost.setSubcosttype(st);
			subcost.setReimbursement(reimbursement);
			sublist.add(subcost);
		}
		int i = 0;
		for (String value : values.split(",")) {
			sublist.get(i).setScost(Integer.parseInt(value));
			i++;
		}
		for (Subcost s : sublist) {
			this.subcostService.save(s);
		}
		return null;
	}
	
	/**
	 * ɾ����
	 * 
	 * @return
	 */
	public String deleteByUUID() {
		String uuid = request.getParameter("uuid");
		boolean result = false;
		if (this.reimbursementService.findByID(uuid).getRstate().equals("W")||this.reimbursementService.findByID(uuid).getRstate().equals("N")) {
			this.reimbursementService.deleteByID(uuid);
			result = true;
		}
		JSONObject jb =new JSONObject();
		jb.put("result", result);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(jb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ��ݣգգɣ�ɾ����
	 * 
	 * @return
	 */
	public String deleteByUUID(String uuid) {	
		boolean result = false;
		if (this.reimbursementService.findByID(uuid).getRuser() == null) {
			this.reimbursementService.deleteByID(uuid);
			result = true;
		}
		JSONObject jb =new JSONObject();
		jb.put("result", result);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(jb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
