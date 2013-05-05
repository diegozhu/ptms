package net.diegozhu.j2ee.ptms.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import net.diegozhu.j2ee.ptms.dao.base.IBaseDao;
import net.diegozhu.j2ee.ptms.resource.BusLineResource;

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

	private static Logger logger = Logger.getLogger(BusLineResource.class);

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
		this.getHibernateTemplate().save(t);
		return t;
	}

	@Override
	public void delete(T t) {

		try {

			java.lang.reflect.Method m = t.getClass().getMethod("getDeleted", Boolean.TYPE);
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

	@Override
	public T load(PK id) {
		return this.getHibernateTemplate().load(entityClass, id);
	}

	@SuppressWarnings("rawtypes")
	public List getByField(String Field, String value) {
		String hql = "FROM " + this.entityName + " WHERE :field = :value";

		Query query = this.getSession().createQuery(hql);

		query.setString("field", Field);
		query.setString("value", value);
		return query.list();
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Override
	public List<T> loadAll() {
		return this.getHibernateTemplate().loadAll(entityClass);
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