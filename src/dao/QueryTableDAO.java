package dao;

import java.util.List;
import java.util.Map;


public interface QueryTableDAO {
	/**
     * ��������¼��ѯ
     * @param clazz
     * @param varables
     * @return
     */
	public <T> T querySingleResult(Class<T> clazz, Map<String, Object> varables);
	
	/**
     * ��������¼��ѯ
     * @param clazz
     * @param varables
     * @return
     */
	public <T> T querySingleResultByValue(Class<T> clazz, Map<String, Object> varables);
	
	/**
     * ���������¼��ѯ
     * @param className Ҫ��ѯ�Ķ���
     * @param varables ��װ��ѯ������map
     * @return ���ز�ѯ�����List����
     */
	public <T> List<T> queryResultList(Class<T> className, Map<String,Object> varables);
	/**
     * ƴ��SQL��ѯ�ַ���,�õ�Query����ֵ��ѯ����
     * @param className
     * @param varables
     * @param session
     * @return Query
     */
	public <T> List<T> queryResultListByValue(Class<T> className, Map<String,Object> varables);
	/**
     * ƴ��SQL��ѯ�ַ���,�õ�Query����ֵ��ѯ����
     * @param className
     * @param varables
     * @param session
     * @return Query
     */
	
}
