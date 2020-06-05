package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/** 
* @author ���� :������
* @version ����ʱ�䣺2017��7��10�� ����9:38:09 
* ��˵�� 
*/
public class AjaxResponse {
	 public static void printUTF8XML(Object result, HttpServletResponse response) {
		    try {
		      response.setContentType("text/xml;charset=UTF-8");
		      PrintWriter out = response.getWriter();
		      out.print(result.toString());
		    }
		    catch (IOException localIOException)
		    {
		    }
		  }
	 public static void printUTF8JSON(Object result, HttpServletResponse response) {
		 try {
			 response.setContentType("application/json;charset=UTF-8");
			 PrintWriter out = response.getWriter();
			 out.print(result.toString());
		 }
		 catch (IOException localIOException)
		 {
		 }
	 }
}
 