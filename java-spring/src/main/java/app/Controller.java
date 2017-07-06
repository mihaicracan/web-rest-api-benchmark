package app;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Country;
import model.User;

@RestController
public class Controller {
	
	private SessionFactory sessionFactory;
	
	public Controller(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @RequestMapping(value = "/hello", produces = "application/json")
    public String hello() throws JSONException {
        return new JSONObject().put("hello", "world").toString();
    }
    
    @RequestMapping(value = "/compute", produces = "application/json")
    public String compute() throws JSONException {
        long x = 0, y = 1, z, max;
        
        Random r = new Random();
        max = 10000 + r.nextInt(500);
        
        for (int i = 0; i <= max; i++) {
        	z = x + y;
		    x = y;
		    y = z;
		}
        
        return new JSONObject().put("status", "done").toString();
    }
    
    @RequestMapping(value = "/countries", produces = "application/json")
    @Transactional
    public List<Country> countries() throws JSONException {
    	List<Country> data = (List<Country>) sessionFactory.getCurrentSession()
    			.createCriteria(Country.class)
    			.list();
    	return data;
    }
    
    @RequestMapping(value = "/users", produces = "application/json")
    @Transactional
    public List<User> users() throws JSONException {
    	List<User> data = (List<User>) sessionFactory.getCurrentSession()
    			.createCriteria(User.class)
    			.createAlias("countries", "countriesAlias")
    			.add(Restrictions.eq("countriesAlias.name", "France"))
    			.list();
    	return data;
    }
}
