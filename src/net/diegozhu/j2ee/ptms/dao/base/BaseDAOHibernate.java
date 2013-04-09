package net.diegozhu.j2ee.ptms.dao.base;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class BaseDAOHibernate <T extends Serializable> extends HibernateDaoSupport {
    
	public static int i=0;
	private static final Log log = LogFactory.getLog(BaseDAOHibernate.class);
	
    public BaseDAOHibernate(){}
    public void doCreateObject(T entity){
        this.getHibernateTemplate().save(entity);
      }

    public void doUpdateObject(T entity){
        this.getHibernateTemplate().update(entity);
    }
}
