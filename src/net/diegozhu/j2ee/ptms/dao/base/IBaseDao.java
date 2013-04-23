package net.diegozhu.j2ee.ptms.dao.base;

import java.io.Serializable;  
import java.util.List;  

import org.springframework.stereotype.Repository;

import net.diegozhu.j2ee.ptms.exception.base.BaseException;
  
/** 
 * The base interface for all the dao layer interface,it provide common method 
 * 
 * @author Irwin.Ai 
 * 
 * @param <T> 
 *            The entity class type 
 * @param <PK> 
 *            The primary key of the entity class 
 */  
@Repository
public interface IBaseDao<T, PK extends Serializable>{  
	
    public T add(T t)throws BaseException;  
  
    public void delete(T t)throws BaseException;  
  
    public T load(PK id)throws BaseException;  
  
    public T get(PK id)throws BaseException;  
  
    public List<T> loadAll()throws BaseException;  
  
    public void update(T t)throws BaseException;  
  
}  