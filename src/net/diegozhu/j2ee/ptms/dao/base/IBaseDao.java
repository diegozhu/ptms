package net.diegozhu.j2ee.ptms.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.diegozhu.j2ee.ptms.exception.base.BaseException;

import org.springframework.stereotype.Repository;

/**
 * The base interface for all the dao layer interface,it provide common method
 * 
 * 
 * @param <T>
 *            The entity class type
 * @param <PK>
 *            The primary key of the entity class
 */
@Repository
public interface IBaseDao<T, PK extends Serializable> {

	@SuppressWarnings("rawtypes")
	public List getByField(String Field, String value) throws BaseException;

	public T add(T t) throws BaseException;

	public void delete(T t) throws BaseException;

	public void delete(PK id) throws BaseException;

	public T load(PK id) throws BaseException;

	public T get(PK id) throws BaseException;

	public List<T> loadAll() throws BaseException;

	public void update(T t) throws BaseException;

	public List<T> getByFields(Map<String, String> map) throws BaseException;
}