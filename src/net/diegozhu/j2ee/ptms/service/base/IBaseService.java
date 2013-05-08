package net.diegozhu.j2ee.ptms.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.diegozhu.j2ee.ptms.exception.base.BaseException;

/**
 * * The base interface for all the service layer interface,it provide common
 * method
 * 
 * 
 * @param <T>
 *            The entity class type
 * @param <PK>
 *            The primary key of the entity class
 */
public interface IBaseService<T, PK extends Serializable> {

	public T add(T t) throws BaseException;

	public void delete(T t) throws BaseException;

	public void delete(PK id) throws BaseException;

	public T load(PK id) throws BaseException;

	public T get(PK id) throws BaseException;

	public List<T> loadAll() throws BaseException;

	public void update(T t) throws BaseException;

	public List<T> getByField(String field, String value) throws BaseException;

	public List<T> getByFields(Map<String, String> map) throws BaseException;
}