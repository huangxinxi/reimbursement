package dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.QueryTableDAO;

public class QueryTableDAOImpl extends HibernateDaoSupport implements QueryTableDAO {

	@SuppressWarnings("unchecked")
	public <T> T querySingleResult(Class<T> clazz, Map<String, Object> varables) {
		Query query = selectStatement(clazz, varables);
        return (T) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T querySingleResultByValue(Class<T> clazz, Map<String, Object> varables) {
		Query query = selectStatementByValue(clazz, varables);
        return (T) query.uniqueResult();
	}
	public <T> List<T> queryResultList(Class<T> className, Map<String, Object> varables) {
		 @SuppressWarnings("unchecked")
		List<T> valueList = selectStatement(className, varables).list();
	    return valueList;        
	}	
	public <T> List<T> queryResultListByValue(Class<T> className, Map<String, Object> varables) {
		 @SuppressWarnings("unchecked")
		List<T> valueList = selectStatement(className, varables).list();
	    return valueList;        
	}
	private <T> Query selectStatement(Class<T> className, Map<String,Object> varables) {
        StringBuilder stringBuilder = new StringBuilder();
        /*
         * ͨ��className�õ���ʵ������ַ�����ʽ,
         */
        stringBuilder.append("from " + this.getSessionFactory().getClassMetadata(className).getEntityName());
        stringBuilder.append(" where 1=1 ");
        /*
         * ��̬��ƴ��sql���,���һ�����Ե�ֵΪ"", �������������.
         */
        for(Entry<String, Object> entry : varables.entrySet()){
            if(!entry.getValue().equals("")){
                stringBuilder.append(" and " + entry.getKey()+" like:" + "value");
            }
        }
        Query query = this.getSession().createQuery(stringBuilder.toString());
        /*
         * ��̬�ĸ�������ֵ
         */
        for(Entry<String, Object> entry : varables.entrySet()){
            if(!entry.getValue().equals("")){
                query.setParameter("value", "%"+entry.getValue()+"%");
            }
        }
        return query;
    }
	
	private <T> Query selectStatementByValue(Class<T> className, Map<String,Object> varables) {
        StringBuilder stringBuilder = new StringBuilder();
        /*
         * ͨ��className�õ���ʵ������ַ�����ʽ,
         */
        stringBuilder.append("from " + this.getSessionFactory().getClassMetadata(className).getEntityName());
        stringBuilder.append(" where 1=1 ");
        /*
         * ��̬��ƴ��sql���,���һ�����Ե�ֵΪ"", �������������.
         */
        for(Entry<String, Object> entry : varables.entrySet()){
            if(!entry.getValue().equals("")){
                stringBuilder.append(" and " + entry.getKey()+" =:" + "value");
            }
        }
        Query query = this.getSession().createQuery(stringBuilder.toString());
        /*
         * ��̬�ĸ�������ֵ
         */
        for(Entry<String, Object> entry : varables.entrySet()){
            if(!entry.getValue().equals("")){
                query.setParameter("value", entry.getValue());
            }
        }
        return query;
    }


}
