package net.diegozhu.j2ee.ptms.action.base;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport implements SessionAware,ApplicationAware,RequestAware {

    private static final long serialVersionUID = 489759208358910870L;
    private Map<String, Object> request;
    private Map<String, Object> application;
    private Map<String, Object> session;

    private static final Log log = LogFactory.getLog(BaseAction.class);
	
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }
    public void setRequestAttribute(String key,Object value){
        this.request.put(key, value);
    }
    public void setSessionAttribute(String key,Object value){
        this.session.put(key, value);
    }
    public void setApplicationAttribute(String key,Object value){
        this.application.put(key, value);
    }
    public void removeRequestAttribute(String key){
        this.request.remove(key);
    }
    public void removeSessionAttribute(String key){
        this.session.remove(key);
    }
    public void removeApplicationAttribute(String key){
        this.application.remove(key);
    }
    public Object getRequestAttribute(String key){
        return this.request.get(key);
    }
    public Object getSessionAttribute(String key){
        return this.session.get(key);
    }
    public Object getApplicationAttribute(String key){
        return this.application.get(key);
    }
}
