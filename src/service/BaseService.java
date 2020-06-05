package service;

import java.io.Serializable;  
import java.util.Collection;  
import java.util.Set;  
/*  
import cn.opencil.common.util.PageResult;  
import cn.opencil.core.query.BaseQuery;  */
  
  
public interface BaseService<T> {  
    /**  
     * ��ҳ�Ĳ�ѯ  
     * @param baseQuery  
     * @return  
     */  
    //public PageResult<T> getPageResult(final BaseQuery baseQuery);  
    /**  
     * ���  
     *   
     * @param t  
     */  
    public void addEntry(T t);  
  
    /**  
     * ��ѯһ��  
     *   
     * @return  
     */  
    public T getEntryById(Serializable id);  
    /**  
     * ��ids��ѯ  
     */  
    public Set<T> getEntrysByIds(Serializable[] ids);  
      
    /**  
     * ����ҳ�Ĳ�ѯ  
     *   
     * @return  
     */  
    public Collection<T> getEntrys();  
  
    /**  
     * �޸�  
     *   
     * @param t  
     */  
    public void updateEntry(T t);  
  
    /**  
     * ����idsɾ��һЩ����  
     *   
     * @param ids  
     */  
    public void deleteEntriesByIDS(Serializable[] ids);  
  
    /**  
     * ����idɾ��һ������  
     *   
     * @param id  
     */  
    public void deleteEntry(Serializable id);  
}  