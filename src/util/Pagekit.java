package util;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import model.Majorcosttype;
import model.Subcosttype;



/** 
* @author ���� :������
* @version ����ʱ�䣺2017��7��10�� ����8:47:43 
* ��˵�� 
*/
public class Pagekit {
	 private static final String xmlHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";  
	    
		/**
		 * 
		 * @param list ����
		 * @param pk row����
		 * @param field չʾ�ֶ�����
		 * @param clazz javabean����
		 * @return
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 * @throws IntrospectionException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 * @throws NoSuchMethodException
		 * @throws SecurityException
		 */
		public static String  PageData2PageXML(@SuppressWarnings("rawtypes") List list,String pk,String[] field) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
			StringBuffer str=new StringBuffer();
			str.append(xmlHead);
			str.append("<rows>");
			for (Object one : list) {
				Method PkMethod = one.getClass().getMethod("get" + pk);//
				str.append("<row id='"+(String)PkMethod.invoke(one)+"'>");
				for (int i = 0; i < field.length; i++) {
					String att = field[i];
					Method method = one.getClass().getMethod("get" + att);
					Object object=method.invoke(one);
					if (object==null) {
						str.append("<cell></cell>");
						continue;
					}else  {
						str.append("<cell>"+method.invoke(one).toString()+"</cell>");
					}
					
				}
				str.append("</row>");
			}
			str.append("</rows>");
			return str.toString();
		}
		

		public static String  PageData2treeXML(List<Majorcosttype> majorcosttypes){
			List<Subcosttype> subcosttypes =new ArrayList<Subcosttype>();
			StringBuffer str=new StringBuffer();
			str.append(xmlHead);
			str.append("<tree id='0'>");
			for (Majorcosttype one : majorcosttypes) {	
				if(one.getSubcosttypes().size()!=0){
					str.append("<item id='"+one.getMt_uuid()+"' text='"+ one.getMttype()+"' open='1'>");
					subcosttypes=one.getSubcosttypes();
					for(Subcosttype s:subcosttypes){
						str.append("<item id='"+s.getSt_uuid()+"' text='"+s.getSttype()+"'/>");
					}
					str.append("</item>");
				}else{
					str.append("<item id='"+one.getMt_uuid()+"' text='"+ one.getMttype()+"'>");
					str.append("</item>");
				}
			}
			str.append("</tree>");
			return str.toString();
		}
		
		public static String  PageData2treeXML(List<Majorcosttype> majorcosttypes,List<String> updateList){
			List<Subcosttype> subcosttypes =new ArrayList<Subcosttype>();
			StringBuffer str=new StringBuffer();
			str.append(xmlHead);
			str.append("<tree id='0'>");
			for (Majorcosttype one : majorcosttypes) {	
				if(one.getSubcosttypes().size()!=0){
					str.append("<item id='"+one.getMt_uuid()+"' text='"+ one.getMttype()+"' open='1'>");
					subcosttypes=one.getSubcosttypes();
					boolean flage;
					for(Subcosttype s:subcosttypes){
						flage=false;
						for(String ruuid:updateList){
							if(ruuid.equals(s.getSt_uuid())){
								str.append("<item id='"+s.getSt_uuid()+"' text='"+s.getSttype()+"' checked='1' />");
								flage=true;
								break;
							}
						}
						if(flage!=true)
						str.append("<item id='"+s.getSt_uuid()+"' text='"+s.getSttype()+"'/>");	
					}
					str.append("</item>");
				}else{
					str.append("<item id='"+one.getMt_uuid()+"' text='"+ one.getMttype()+"'>");
					str.append("</item>");
				}
			}
			str.append("</tree>");
			return str.toString();
		}
}
 