package net.diegozhu.j2ee.ptms.dao.impl;

import net.diegozhu.j2ee.ptms.dao.IUserDao;
import net.diegozhu.j2ee.ptms.dao.base.impl.BaseDao;
import net.diegozhu.j2ee.ptms.model.User;
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
public class UserDao extends BaseDao<User, Integer> implements IUserDao{
  
}  