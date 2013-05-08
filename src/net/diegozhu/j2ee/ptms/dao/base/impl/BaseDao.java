package net.diegozhu.j2ee.ptms.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.exception.base.BaseException;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * The base interface implement for all the dao layer interface implements,it
 * provide common method
 * 
 * 
 * @param <T>
 *            The entity class type
 * @param <PK>
 *            The primary key of the entity class
 */
@Repository
public class BaseDao<T, PK extends Serializable> extends HibernateDaoSupport implements IBaseDao<T, PK> {

	protected Class<T> entityClass;

	private String entityName = "";

	private static Logger logger = Logger.getLogger(BaseDao.class);

	@Resource
	public void setHTemplate(HibernateTemplate hibernateTemplate) {
		this.setHibernateTemplate(hibernateTemplate);

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
		try {
			Method method = t.getClass().getMethod("setDeleted", Boolean.TYPE);
			method.invoke(t, false);
		} catch (NoSuchMethodException e) {
			logger.info(e);
			e.printStackTrace();
		} catch (SecurityException e) {
			logger.info(e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.info(e);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			logger.info(e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.info(e);
			e.printStackTrace();
		}
		this.getHibernateTemplate().save(t);
		return t;
	}

	@Override
	public void delete(T t) {

		try {

			java.lang.reflect.Method m = t.getClass().getMethod("setDeleted", Boolean.TYPE);
			m.invoke(t, true);

		} catch (NoSuchMethodException e) {
			logger.info(e);
			e.printStackTrace();
		} catch (SecurityException e) {
			logger.info(e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.info(e);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			logger.info(e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.info(e);
			e.printStackTrace();
		}
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(PK id) {
		T t = this.get(id);
		this.delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(PK id) {
		return (T) this.getByField("id", id.toString()).get(0);
	}

	@SuppressWarnings("rawtypes")
	public List getByField(String Field, String value) {
		String hql = "FROM " + this.entityName + " WHERE " + Field + " = :value and deleted != 1";

		Query query = this.getSession().createQuery(hql);

		query.setString("value", value);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	public List getByFields(Map<String, String> map) throws BaseException {

		String hql = "FROM " + this.entityName + " WHERE deleted != 1";
		Set<String> keys = map.keySet();

		for (String key : keys) {
			hql += " AND " + key + " = " + map.get(key);
		}

		Query query = this.getSession().createQuery(hql);

		return query.list();
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> loadAll() {
		String hql = "FROM " + this.entityName + " WHERE deleted != 1";

		Query query = this.getSession().createQuery(hql);

		return query.list();
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public T get(PK id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

}