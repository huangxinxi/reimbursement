package action;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import service.ReimbursementService;
import service.impl.MajorcostServiceImpl;
import service.impl.ProjectServiceImpl;
import util.AjaxResponse;
import util.Pagekit;
import util.SpringUtil;
import model.Majorcost;
import model.MajorcostDelPandMT;
import model.Majorcosttype;
import model.Project;
import model.ProjectDelU;
import model.Reimbursement;
import model.User;

import com.mysql.fabric.Server;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActProject extends ActionSupport{
	public ProjectServiceImpl service;
	public MajorcostServiceImpl service2;
	
	public void setService(ProjectServiceImpl service) {
		this.service = service;
	}
	
	public String loadWaitProject() throws Exception
	{
		
		service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		List<Project> list = service.loadAllWait();
		
		JSONArray ja = new JSONArray();
		JSONObject jb = null;
		Project p = null;
		ProjectDelU pdu = null;
		for(int i = 0;i<list.size();i++)
		{
			p = list.get(i);
			pdu = new ProjectDelU(p);
			jb = new JSONObject();
			jb.put("p_uuid",pdu.getP_uuid());
			jb.put("pid",pdu.getPid());
			jb.put("pname",pdu.getP_name());
			jb.put("pstate",pdu.getPstate());
			ja.add(jb);
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(ja);  

		return null;
	}
	
	public String loadReviewedProject() throws Exception
	{
		
		service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		List<Project> list = service.loadReviwed();
		
		JSONArray ja = new JSONArray();
		JSONObject jb = null;
		Project p = null;
		ProjectDelU pdu = null;
		for(int i = 0;i<list.size();i++)
		{
			p = list.get(i);
			pdu = new ProjectDelU(p);
			jb = new JSONObject();
			jb.put("p_uuid",pdu.getP_uuid());
			jb.put("pid",pdu.getPid());
			jb.put("pname",pdu.getP_name());
			jb.put("pstate",pdu.getPstate());
			ja.add(jb);
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(ja);  

		return null;
	}
	
	public String passProject() throws Exception
	{
		
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
		service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		int pid = Integer.valueOf(request.getParameter("pid"));
		Project p = service.findByID(pid);
		service.pass(p);
		
		
		JSONObject jb = new JSONObject();
		response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(jb);  
		return null;
	}
	
	public String rejectProject() throws Exception
	{
		
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
		service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		int pid = Integer.valueOf(request.getParameter("pid"));
		Project p = service.findByID(pid);
		service.reject(p);
		
		
		JSONObject jb = new JSONObject();
		response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(jb);  
		return null;
	}
	
	public String loadProject() throws Exception
	{
		
		service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		
		String u_uuid = request.getParameter("uuid");
		
		System.out.println("heyheyheyheyhey "+u_uuid);
		
		List<Project> list = service.findAll(u_uuid);
		
		JSONArray ja = new JSONArray();
		JSONObject jb = null;
		Project p = null;
		ProjectDelU pdu = null;
		for(int i = 0;i<list.size();i++)
		{
			p = list.get(i);
			pdu = new ProjectDelU(p);
			jb = new JSONObject();
			jb.put("p_uuid",pdu.getP_uuid());
			jb.put("pid",pdu.getPid());
			jb.put("pname",pdu.getP_name());
			jb.put("pstate",pdu.getPstate());
			ja.add(jb);
		}
		
		response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(ja);  

		return null;
	}

	public String findProject() throws Exception
	{
		
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
		
   //     System.out.println("findProject");
		service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		int pid = Integer.valueOf(request.getParameter("pid"));
		Project p = service.findByID(pid);
		ProjectDelU pdu = new ProjectDelU(p);
		
		JSONObject jb = JSONObject.fromObject(pdu);
		
	//	 System.out.println("findProject3");
      //  HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);  
        response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(jb);  
		return null;
	}
	
	
	public String addProject() throws Exception
	{
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		service2 = (MajorcostServiceImpl) SpringUtil.getApplicationContext().getBean("MajorcostServiceImpl");
		
        SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
        
		Project p = new Project();
		User u = new User();
		Majorcost mc = null;
		Majorcosttype mt = null;
		String puid = UUID.randomUUID().toString();
		
		u.setU_uuid("1");
		p.setP_uuid(puid);
		p.setP_name(request.getParameter("p_name"));
		p.setPtype(request.getParameter("ptype"));
		p.setPfield(request.getParameter("pfield"));
		p.setPsource(request.getParameter("psource"));
		p.setPresuser(u);
		p.setPcostidp(Integer.valueOf(request.getParameter("pcostidp")));
		p.setPcostpub(Integer.valueOf(request.getParameter("pcostpub")));
		p.setPbegintime(sdf.parse(request.getParameter("pbegintime")));
		p.setPendtime(sdf.parse(request.getParameter("pendtime")));
		p.setPstate("W");
		
	//	System.out.println(p.getP_name()+" "+p.getPtype()+" "+p.getPfield()+" "+p.getPsource()+" "+
	//			p.getPcostidp()+" "+p.getPcostpub()+" "+p.getPbegintime()+" "+p.getPendtime());
	
		service.save(p);
		
		
		String mct = request.getParameter("mct");
		String mcv = request.getParameter("mcv");
		System.out.println(mct+"\n"+mcv);
		String[] amct = mct.split(",");
		String[] amcv = mcv.split(",");
		for(int i = 0;i<amct.length;i++)
		{
	//		System.out.println("amct"+amct[i]);
	//		System.out.println("amcv"+amcv[i]);
			if(amct[0].equals(""))
				break;
			mc = new Majorcost();
			mt = new Majorcosttype();
			mt.setMt_uuid(amct[i]);
			mc.setProject(p);
			mc.setMajorcosttype(mt);
			mc.setMcost(Integer.valueOf(amcv[i]));
			mc.setMstate("A");
			service2.save(mc);
		}
		
		
		JSONObject jb = new JSONObject();
		response.setCharacterEncoding("UTF-8");   
	    response.getWriter().print(jb);
		return null;
	}
	
	
	public String modifyProject() throws Exception
	{
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		service2 = (MajorcostServiceImpl) SpringUtil.getApplicationContext().getBean("MajorcostServiceImpl");
		
        SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
        String pid = request.getParameter("pid");
		Project p = service.findByID(Integer.valueOf(pid));
	//	User u = new User();
		Majorcost mc = null;
		Majorcosttype mt = null;
	//	u.setU_uuid("1");
		p.setP_name(request.getParameter("p_name"));
		p.setPtype(request.getParameter("ptype"));
		p.setPfield(request.getParameter("pfield"));
		p.setPsource(request.getParameter("psource"));
	//	p.setPresuser(u);
		p.setPcostidp(Integer.valueOf(request.getParameter("pcostidp")));
		p.setPcostpub(Integer.valueOf(request.getParameter("pcostpub")));
		p.setPbegintime(sdf.parse(request.getParameter("pbegintime")));
		p.setPendtime(sdf.parse(request.getParameter("pendtime")));
		p.setPstate("W");
		
	//	System.out.println(p.getP_name()+" "+p.getPtype()+" "+p.getPfield()+" "+p.getPsource()+" "+
	//			p.getPcostidp()+" "+p.getPcostpub()+" "+p.getPbegintime()+" "+p.getPendtime());
	
		service.update(p);
		service2.deleteByPUID(p.getP_uuid());
		
		String mct = request.getParameter("mct");
		String mcv = request.getParameter("mcv");
		System.out.println(mct+"\n"+mcv);
		String[] amct = mct.split(",");
		String[] amcv = mcv.split(",");
		for(int i = 0;i<amct.length;i++)
		{
	//		System.out.println("amct"+amct[i]);
	//		System.out.println("amcv"+amcv[i]);
			if(amct[0].equals(""))
				break;
			mc = new Majorcost();
			mt = new Majorcosttype();
			mt.setMt_uuid(amct[i]);
			mc.setProject(p);
			mc.setMajorcosttype(mt);
			mc.setMcost(Integer.valueOf(amcv[i]));
			mc.setMstate("A");
			service2.save(mc);
		}
		
		
		JSONObject jb = new JSONObject();
		response.setCharacterEncoding("UTF-8");   
	    response.getWriter().print(jb);
		return null;
	}
	
	
	public String delProject() throws Exception
	{
		
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
		service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		int pid = Integer.valueOf(request.getParameter("pid"));
		Project p = service.findByID(pid);
		service.delete(p);
		
		
		JSONObject jb = new JSONObject();
		response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(jb);  
		return null;
	}
	
	
	
	public String loadMajorCostType() throws Exception
	{
		
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
        List<Majorcosttype> list = service.loadMajorCostType();
		JSONArray ja = new JSONArray().fromObject(list);
        response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(ja);  
		return null;
	}
	public String getMajorcost() throws Exception
	{
		
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        service2 = (MajorcostServiceImpl) SpringUtil.getApplicationContext().getBean("MajorcostServiceImpl");
	
        String puid = "";
        puid = request.getParameter("p_uuid");
//        System.out.println("hey1");
        List<Majorcost> list = service2.findByPUID(puid);
        JSONArray ja = new JSONArray();
        JSONObject jb = null;
        Majorcost mc = null;
        MajorcostDelPandMT mcd = null;
	//	JSONObject jb = JSONObject.fromObject(pdu);
        for(int i = 0;i<list.size();i++)
        {
        	mc = list.get(i);
        	mcd = new MajorcostDelPandMT(mc);
      //  	System.out.println(mc.getM_uuid()+" "+mc.getProject()+" "+mc.getMajorcosttype()+" "+mc.getMcost()+" ");
        	jb = JSONObject.fromObject(mcd);
      //  	System.out.println("hey");
        	ja.add(jb);
        }
        
      //  System.out.println("hey2");
        response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(ja);  
		return null;
	} 
	
	
	
	/**
	 * 王家南
	 * 初始化项目列表
	 * @return
	 */
	public String initProject(){
		service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		HttpServletRequest request= ServletActionContext.getRequest();
		User u = (User) request.getSession().getAttribute("user");
		String u_uuid = u.getU_uuid();
		List<Project> list = service.findAll(u_uuid);
		try {
			String result=Pagekit.PageData2PageXML(list, Project.KEY, Project.FIELD);
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
	
	/**王家南
	 * @return
	 * @throws Exception
	 * 根据报销单uuid查询项目具体信息
	 */
	public String findProjectDetail() throws Exception
	{
		HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
		service = (ProjectServiceImpl) SpringUtil.getApplicationContext().getBean("ProjectServiceImpl");
		String ruuid = request.getParameter("ruuid");
		ReimbursementService reimbursementService =(ReimbursementService) SpringUtil.getBean("ReimbursementService");
		Reimbursement reimbursement=reimbursementService.findByID(ruuid);
		
		Project p = service.findByUUID(reimbursement.getProject().getP_uuid());
		ProjectDelU pdu = new ProjectDelU(p);	
		JSONObject jb = JSONObject.fromObject(pdu);
        response.setCharacterEncoding("UTF-8");   
        response.getWriter().print(jb); 
		return null;
	}
}
