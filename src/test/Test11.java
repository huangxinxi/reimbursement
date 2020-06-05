package test;

import model.Reimbursement;
import model.User;
import model.Usertype;
import util.SpringUtil;

import java.util.UUID;

import org.junit.Test;

import dao.impl.ReimbursementDAOImpl;
import dao.impl.UserDaoImpl;;


public class Test11 {
	@Test
	public void test(){
		/*User u = (User) SpringUtil.getBean("User");
		UserDaoImpl ud = (UserDaoImpl) SpringUtil.getBean("UserDaoImpl");
		u.setU_uuid(UUID.randomUUID().toString());
		ud.save(u);*/
		/*Reimbursement r = (Reimbursement) SpringUtil.getBean("Reimbursement");
		ReimbursementDAOImpl rd = (ReimbursementDAOImpl) SpringUtil.getBean("ReimbursementDAOImpl");
		r.setR_uuid(UUID.randomUUID().toString());
		r.setRcostall(11);
		rd.save(r);*/
	
	}
}
