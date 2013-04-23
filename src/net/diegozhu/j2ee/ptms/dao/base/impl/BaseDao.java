package net.diegozhu.j2ee.ptms.dao.base.impl;

import java.io.Serializable;  
import java.lang.reflect.ParameterizedType;  
import java.lang.reflect.Type;  
import java.util.List;  
  
import javax.annotation.Resource;  
  
import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;

import org.hibernate.Session;  
import org.springframework.orm.hibernate3.HibernateTemplate;  
import org.springframework.stereotype.Repository;   
  
/** 
 * The base interface implement for all the dao layer interface implements,it 
 * provide common method 
 * 
 * @author Irwin.Ai 
 * 
 * @param <T> 
 *            The entity class type 
 * @param <PK> 
 *            The primary key of the entity class 
 */  
@Repository
public abstract class BaseDao<T, PK extends Serializable> implements IBaseDao<T, PK> {  
    

    private Class<T> entityClass;  

    private HibernateTemplate hibernateTemplate;  
  
    public HibernateTemplate getHibernateTemplate() {  
        return hibernateTemplate;  
    }  
  
    @Resource  
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {  
        this.hibernateTemplate = hibernateTemplate;  
    }  
  
    /** 
     * Method to judge the type of class 
     */  
    @SuppressWarnings("unchecked")  
    public BaseDao() {  
        Type type = getClass().getGenericSuperclass();  
        if (type instanceof ParameterizedType) {  
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();  
            this.entityClass = (Class<T>) types[0];  
        }  
    }  
  
    @Override  
    public T add(T t) {  
        hibernateTemplate.save(t);  
        return t;  
    }  
  
    @Override  
    public void delete(T t) {  
        hibernateTemplate.delete(t);  
    }  
  
    @Override  
    public T load(PK id) {  
        return hibernateTemplate.load(entityClass, id);  
    }  
  
    @Override  
    public List<T> loadAll() {  
        return hibernateTemplate.loadAll(entityClass);  
    }  
  
    @Override  
    public void update(T t) {  
        hibernateTemplate.update(t);    
    }  
  
    @Override  
    public T get(PK id) {  
        return hibernateTemplate.get(entityClass, id);  
    }  
  
    /** 
     * If there is a session alive, we will use it instead of open an new 
     * Session. 
     * 
     * @return 
     */  
    public Session getCurrentSession() {  
        Session session = hibernateTemplate.getSessionFactory()  
                .getCurrentSession();  
        if (session == null) {  
            session = hibernateTemplate.getSessionFactory().openSession();  
        }  
        return session;  
    }  
  
  
}  