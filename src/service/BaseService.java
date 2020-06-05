package service;

import java.io.Serializable;  
import java.util.Collection;  
import java.util.Set;  
/*  
import cn.opencil.common.util.PageResult;  
import cn.opencil.core.query.BaseQuery;  */
  
  
public interface BaseService<T> {  
    /**  
     * 分页的查询  
     * @param baseQuery  
     * @return  
     */  
    //public PageResult<T> getPageResult(final BaseQuery baseQuery);  
    /**  
     * 添加  
     *   
     * @param t  
     */  
    public void addEntry(T t);  
  
    /**  
     * 查询一个  
     *   
     * @return  
     */  
    public T getEntryById(Serializable id);  
    /**  
     * 按ids查询  
     */  
    public Set<T> getEntrysByIds(Serializable[] ids);  
      
    /**  
     * 不分页的查询  
     *   
     * @return  
     */  
    public Collection<T> getEntrys();  
  
    /**  
     * 修改  
     *   
     * @param t  
     */  
    public void updateEntry(T t);  
  
    /**  
     * 根据ids删除一些数据  
     *   
     * @param ids  
     */  
    public void deleteEntriesByIDS(Serializable[] ids);  
  
    /**  
     * 根据id删除一条数据  
     *   
     * @param id  
     */  
    public void deleteEntry(Serializable id);  
}  