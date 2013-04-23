package net.diegozhu.j2ee.ptms.service.base;

import java.io.Serializable;  
import java.util.List;  

import net.diegozhu.j2ee.ptms.exception.base.BaseException;
  
/** 
 * * The base interface for all the service layer interface,it provide common 
 * method 
 *  
 * @author Irwin.Ai 
 *  
 * @param <T> 
 *            The entity class type 
 * @param <PK> 
 *            The primary key of the entity class 
 */  
public interface IBaseService<T, PK extends Serializable> {  
  
    public T add(T t) throws BaseException;  
  
    public void delete(T t)throws BaseException;  
  
    public T load(PK id)throws BaseException;  
  
    public T get(PK id)throws BaseException;  
  
    public List<T> loadAll()throws BaseException;  
  
    public void update(T t)throws BaseException;  
  
}  