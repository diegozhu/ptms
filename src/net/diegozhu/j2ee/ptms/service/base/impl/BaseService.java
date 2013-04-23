package net.diegozhu.j2ee.ptms.service.base.impl;

import java.io.Serializable;
import java.util.List;
import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.exception.base.BaseException;
import net.diegozhu.j2ee.ptms.service.base.IBaseService;

/**
 * * The base interface implement for all the service layer interface
 * implements,it provide common method
 * 
 * @author Irwin.Ai
 * 
 * @param <T>
 *            The entity class type
 * @param <PK>
 *            The primary key of the entity class
 */
public class BaseService<T, PK extends Serializable> implements IBaseService<T, PK> {

	private IBaseDao<T, PK>	baseDao;

	public IBaseDao<T, PK> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public T add(T t) throws BaseException {
		return baseDao.add(t);
	}

	@Override
	public void delete(T t) throws BaseException {
		baseDao.delete(t);
	}

	@Override
	public T load(PK id) throws BaseException {
		return baseDao.load(id);
	}

	@Override
	public List<T> loadAll() throws BaseException {
		return baseDao.loadAll();
	}

	@Override
	public void update(T t) throws BaseException {
		baseDao.update(t);
	}

	@Override
	public T get(PK id) throws BaseException {
		return baseDao.get(id);
	}

}