package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/** 
* @author 作者 :王家南
* @version 创建时间：2017年7月10日 上午9:38:09 
* 类说明 
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
 